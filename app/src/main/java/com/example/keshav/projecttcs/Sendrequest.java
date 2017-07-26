package com.example.keshav.projecttcs;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by muskan on 23-07-2017.
 */

public class Sendrequest extends MainActivity {

    Button notification;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    String LoggedIn_User_Email = user.getEmail();

   /* public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendrequest);

        notification = (Button)findViewById(R.id.push_notification);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendNotification();
            }
        });

    } */

    public void sendNotification()
    {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    String send_email;
                    Log.e("Notification",user.getEmail());
                    //This is a Simple Logic to Send Notification different Device Programmatically....
                    if (LoggedIn_User_Email.equals("muskan.123bansal@gmail.com")) {
                        send_email = "123user2gmail.com";
                    } else {
                        send_email = "123user2@gmail.com";
                    }

                    try {
                        String jsonResponse;

                        URL url = new URL("https://onesignal.com/api/v1/notifications");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setUseCaches(false);
                        con.setDoOutput(true);
                        con.setDoInput(true);

                        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        con.setRequestProperty("Authorization", "Basic YWU1ZmMyYWQtNjU1ZC00NDM0LWI5NDQtODM2MWM4YjQ3NzZm");
                        con.setRequestMethod("POST");

                        String strJsonBody = "{"
                                + "\"app_id\": \"cae78fe4-8d98-4853-b086-ad6dcab71a81\","

                                + "\"filters\": [{\"field\": \"tag\", \"key\": \"User_ID\", \"relation\": \"=\", \"value\": \"" + send_email + "\"}],"

                                + "\"data\": {\"foo\": \"bar\"},"
                                + "\"contents\": {\"en\": \"Hello world!\"}"
                                + "}";


                        Log.i("strJsonBody:" , strJsonBody);

                        byte[] sendBytes = strJsonBody.getBytes("UTF-8");
                        con.setFixedLengthStreamingMode(sendBytes.length);

                        OutputStream outputStream = con.getOutputStream();
                        outputStream.write(sendBytes);

                        int httpResponse = con.getResponseCode();
                        Log.i("httpResponse: " , httpResponse+"");

                        if (httpResponse >= HttpURLConnection.HTTP_OK
                                && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
                            Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        } else {
                            Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        }
                        System.out.println("jsonResponse:\n" + jsonResponse);

                    } catch (Throwable t) {


                        t.printStackTrace();
                    }
                }
            }
        });
    }

    public void sendMail(final View v, String email){
        sendNotification();
        /*String[] TO = {email};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        Log.e("to",email);
        emailIntent.setData(Uri.parse("mailto:"+email));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Request For Blood Donation");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hii, this is Blood Donation Request from the mail "+user.getEmail());

        try {
            v.getContext().startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            Log.i("Finished sending email.", "to Muskan");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }*/

        BackgroundMail.newBuilder(v.getContext())
                .withUsername("aman1751996@gmail.com")
                .withPassword("Aman@1996")
                .withMailto(email)
                .withType(BackgroundMail.TYPE_PLAIN)
                .withSubject("Request For Blood Donation")
                .withBody("Hii, this is Blood Donation Request from the mail "+user.getEmail())
                .withOnSuccessCallback(new BackgroundMail.OnSuccessCallback() {
                    @Override
                    public void onSuccess() {
                        //do some magic
                        Toast.makeText(v.getContext(), "Successful Mail Sent", Toast.LENGTH_SHORT).show();
                    }
                })
                .withOnFailCallback(new BackgroundMail.OnFailCallback() {
                    @Override
                    public void onFail() {
                        //do some magic
                        Toast.makeText(v.getContext(), "Unsuccessful Mail Sent", Toast.LENGTH_SHORT).show();
                    }
                })
                .send();
    }
}
