package com.example.keshav.projecttcs;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;


/**
 * Created by muskan on 25-06-2017.
 */

public class Profile extends MainActivity {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
    FirebaseDatabase fdata = FirebaseDatabase.getInstance();
    DatabaseReference db = fdata.getReference().child("Donors").child(firebaseUser.getUid());


    static TextView name, age, height, bloodgroup, city, phone;
    Button btnviewAll;

    Button display;

    static ArrayList<ProfileDetails> user_profile = new ArrayList<>();
    List<String> user = new ArrayList<>();
    ProfileDetails pd = new ProfileDetails();
    Signup signup = new Signup();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Log.e("Curr user", firebaseUser.getUid());

        name = (TextView) findViewById(R.id.prname);
        age = (TextView) findViewById(R.id.prage);
        bloodgroup = (TextView) findViewById(R.id.prweight);
        city = (TextView) findViewById(R.id.prdate);
        phone = (TextView) findViewById(R.id.prphone);

        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                int c = 1;
                String[] arr = dataSnapshot.getValue().toString().split(" ");
                for(String st : arr) {
                    c++;
                    Log.e("muskan", st + " " + c);
                    user.add(st);
                }
                if(user.size() >= 8) show_details(arr);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //show_details();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void show_details(String[] arr){
        name.setText(user.get(6));
        age.setText(user.get(0));
        bloodgroup.setText(user.get(1));
        city.setText(user.get(2));
        phone.setText(user.get(3));
    }

}
