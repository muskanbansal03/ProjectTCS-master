package com.example.keshav.projecttcs;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by muskan on 19-06-2017.
 */

public class requestpage extends MainActivity  {

    Button request,dlist;
    EditText city;
    static String strcity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_request);
        request = (Button) findViewById(R.id.btn_request);
        city = (EditText) findViewById(R.id.editText_city);
        //dlist = (Button) findViewById(R.id.btn_display_list);


        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)

            {

                EditText etUserName = (EditText) findViewById(R.id.editText_bloodgroups);
                String strUserName = etUserName.getText().toString();

                EditText etunits = (EditText) findViewById(R.id.editText_unitss);
                String strunits = etunits.getText().toString();

                EditText etcity = (EditText) findViewById(R.id.editText_city);
                String strcity = etcity.getText().toString();

                if (TextUtils.isEmpty(strUserName)) {
                    etUserName.setError("Please specify the blood group");
                    return;
                }

                if (TextUtils.isEmpty(strunits)) {
                    etunits.setError("Please specify the Units");
                    return;
                }

                if (TextUtils.isEmpty(strcity)) {
                    etcity.setError("Please specify the city");
                    return;
                }

                if (!(strUserName.equals("b+") || strUserName.equals("a+") || strUserName.equals("o+") || strUserName.equals("ab+") || strUserName.equals("b-") || strUserName.equals("a-") || strUserName.equals("o-") || strUserName.equals("ab-") || strUserName.equals("A+") || strUserName.equals("B+") || strUserName.equals("O+") || strUserName.equals("AB+") || strUserName.equals("B-") || strUserName.equals("A-") || strUserName.equals("O-") || strUserName.equals("AB-") || strUserName.equals("Ab+") || strUserName.equals("Ab-") || strUserName.equals("aB+") || strUserName.equals("aB-"))) {
                    Toast t = Toast.makeText(requestpage.this, "Enter valid blood group!", Toast.LENGTH_SHORT);
                    t.show();

                } else {
                    Toast t = Toast.makeText(requestpage.this, "You made a request", Toast.LENGTH_SHORT);
                    t.show();

                    Intent intent = new Intent(requestpage.this, BeneficiaryListActivity.class);
                    startActivity(intent);
                }

            }
        });

       /* dlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)

            {

                EditText etUserName = (EditText) findViewById(R.id.editText_bloodgroups);
                String strUserName = etUserName.getText().toString();

                EditText etunits = (EditText) findViewById(R.id.editText_unitss);
                String strunits = etunits.getText().toString();

                EditText etcity = (EditText) findViewById(R.id.editText_city);
                String strcity = etcity.getText().toString();

                if (TextUtils.isEmpty(strUserName)) {
                    etUserName.setError("Please specify the blood group");
                    return;
                }

                if (TextUtils.isEmpty(strunits)) {
                    etunits.setError("Please specify the Units");
                    return;
                }

                if (TextUtils.isEmpty(strcity)) {
                    etcity.setError("Please specify the city");
                    return;
                }

                if (!(strUserName.equals("b+") || strUserName.equals("a+") || strUserName.equals("o+") || strUserName.equals("ab+") || strUserName.equals("b-") || strUserName.equals("a-") || strUserName.equals("o-") || strUserName.equals("ab-") || strUserName.equals("A+") || strUserName.equals("B+") || strUserName.equals("O+") || strUserName.equals("AB+") || strUserName.equals("B-") || strUserName.equals("A-") || strUserName.equals("O-") || strUserName.equals("AB-") || strUserName.equals("Ab+") || strUserName.equals("Ab-") || strUserName.equals("aB+") || strUserName.equals("aB-"))) {
                    Toast t = Toast.makeText(requestpage.this, "Enter valid blood group!", Toast.LENGTH_SHORT);
                    t.show();
                }
                else {
                    Intent intent = new Intent(requestpage.this, DonorList.class);
                    startActivity(intent);
                }
            }

        });*/
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(requestpage.this,MainActivity.class));
        super.onBackPressed();
    }
}