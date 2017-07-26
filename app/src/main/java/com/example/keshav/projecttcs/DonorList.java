package com.example.keshav.projecttcs;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by muskan on 07-07-2017.
 */

public class DonorList extends MainActivity {

   // DatabaseHelper helper = new DatabaseHelper(this);
    //TextView donorname;

    Cursor cursor;
    TextView donorname;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donorlist);

        donorname = (TextView) findViewById(R.id.donorname);
        //helper.get_city();

        get_donor();

    }
    public void get_donor()
    {
       // cursor = helper.get_city();
        cursor.moveToFirst();
        donorname.setText(cursor.getString(1));


    }




    @Override
    public void onBackPressed() {
        startActivity(new Intent(DonorList.this,MainActivity.class));
        super.onBackPressed();
    }
}
