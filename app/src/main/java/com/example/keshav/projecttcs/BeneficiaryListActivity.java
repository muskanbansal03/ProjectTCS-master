package com.example.keshav.projecttcs;

/**
 * Created by muskan on 17-07-2017.
 */

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class BeneficiaryListActivity extends AppCompatActivity {


    DatabaseReference db;
    FirebaseRetrieve fr;
    BeneficiaryRecyclerAdapter adapter;
    ListView listView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiary_list);


        listView = (ListView) findViewById(R.id.userList);

        db = FirebaseDatabase.getInstance().getReference();
        fr = new FirebaseRetrieve(db);
        fr.retrieve();
        do {
            adapter = new BeneficiaryRecyclerAdapter(this, fr.getDonorMuskan());
        } while (fr.getDonorMuskan() == null);
        listView.setAdapter(adapter);

        Button b = (Button) findViewById(R.id.refresh);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(BeneficiaryListActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                Log.e("List Click: ",position+"");

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(BeneficiaryListActivity.this);
                alertDialogBuilder.setTitle("Blood Donation Request");
                alertDialogBuilder.setMessage("Do you want to send request to this donor?").setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Sendrequest sendRequest = new Sendrequest();
                                sendRequest.sendNotification();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }

        });
    }
}
