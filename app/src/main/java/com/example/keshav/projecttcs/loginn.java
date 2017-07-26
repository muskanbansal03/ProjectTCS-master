package com.example.keshav.projecttcs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.*;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

/**
 * Created by muskan on 19-06-2017.
 */

public class loginn extends MainActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    public static FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private GoogleApiClient mGoogleApiClient;
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;

    static boolean flag = false;

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

    //Shared Preferences file and Editor
    SharedPreferences logInPref;

    SharedPreferences.Editor logInEditor;
    // a permanent variable storing the file name for ease of change
    public static final String LOGIN_FILE = "LogInFile";

    EditText userName, password;
    Button mlogin;
    TextView createAccount;
//    TextView textView = (TextView) findViewById(R.id.user_name);
//    ImageView imageView = (ImageView) findViewById(R.id.imageView);

    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();
            displayMessage(profile);
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_loginn);
        init();

        //Firebase Listener//
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User Signed In
                    Log.d("Firebase", "onAuthStateChanged:signed_in:" + user.getUid());
                    logInEditor.putString("Uid", user.getUid());
                    logInEditor.putString("user", user.getDisplayName());
                    logInEditor.putString("name", user.getDisplayName());
                    logInEditor.putBoolean("isLoggedIn", true);
                    logInEditor.apply();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(i);

                } else {
                    //User Signed out
                    Log.d("Firebase", "onAuthStateChanged:signed_out");
                }
            }
        };

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Signup.class));
            }
        });
        SignInButton g_plus = (SignInButton) findViewById(R.id.btn_google);

        g_plus.setOnClickListener(this);
        mlogin.setOnClickListener(this);

        callbackManager = CallbackManager.Factory.create();
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };

        profileTracker = new ProfileTracker() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                displayMessage(currentProfile);
            }
        };

        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        LoginButton loginButton = (LoginButton) findViewById(R.id.fb_login_bn);
        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager, callback);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void displayMessage(Profile profile){
        if (profile != null){
           // textView.setText(profile.getName());
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
        accessTokenTracker.startTracking();
        profileTracker.stopTracking();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onResume(){
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        displayMessage(profile);
    }

    private void init() {

        userName = (EditText) findViewById(R.id.edemail);
        password = (EditText) findViewById(R.id.edpassword);
        createAccount = (TextView) findViewById(R.id.bsignup);
        mlogin = (Button) findViewById(R.id.blogin);

        logInPref = getSharedPreferences(LOGIN_FILE, 0);
        logInEditor = logInPref.edit();

        // FireBase
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.blogin:
                String u = userName.getText().toString();
                String p = password.getText().toString();
                Log.i("user", u);
                Log.i("password", p);

                if (u.isEmpty() || p.isEmpty()) {
                    Snackbar.make(v, "Fill All details", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (!isNetworkAvailable()) {
                    Snackbar.make(v, getString(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(u, p)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("FireBase", "signInWithEmail:onComplete:" + task.isSuccessful());

                                Toast temp = Toast.makeText(loginn.this, "Welcome!", Toast.LENGTH_SHORT);
                                temp.show();

                                flag = true;

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Log.w("Firebase", "signInWithEmail", task.getException());
                                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        })
                        .addOnFailureListener(this, new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("FireBase", "signInWithEmail:onComplete: Failed");
                                if (e instanceof FirebaseAuthException) {
                                    String error = ((FirebaseAuthException) e).getErrorCode();
                                    Log.e("Error", error);
                                }
                            }
                        });
                break;
            case R.id.btn_google:
                if (!isNetworkAvailable()) {
                    Snackbar.make(v, getString(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                    return;
                }
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);

                Toast temp = Toast.makeText(loginn.this, "Welcome!", Toast.LENGTH_SHORT);
                temp.show();

                flag = true;

                Intent intent = new Intent(loginn.this, MainActivity.class);
                startActivity(intent);

            } else {
                Log.i(TAG, "Failed SignIn");
                Log.d(TAG, String.valueOf(result.getStatus()));

            }
        }
        else{
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }

    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("Firebase with Google", "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
        // [END_EXCLUDE]

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("Firebase with Google", "signInWithCredential", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // [START_EXCLUDE]
                        // [END_EXCLUDE]
                    }
                });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
// [END auth_with_google]

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void onBackPressed() {
        startActivity(new Intent(loginn.this, MainActivity.class));
        super.onBackPressed();
    }
}