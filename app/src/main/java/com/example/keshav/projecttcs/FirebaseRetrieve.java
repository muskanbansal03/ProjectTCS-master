package com.example.keshav.projecttcs;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by muskan on 23-07-2017.
 */

public class FirebaseRetrieve {
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference db = database.getReference().child("Donors");
    static ArrayList<DonorDeatils> donors = new ArrayList<>();

    public FirebaseRetrieve(DatabaseReference db){
        this.db = db;
    }

    private void getDetails(DataSnapshot dataSnapshot){
        donors.clear();
        for (DataSnapshot myds : dataSnapshot.getChildren()){
            DonorDeatils donorDeatils = new DonorDeatils();
            Log.i("muskan",myds.child("Name").getValue()+"");
            donorDeatils.setUsername(myds.child("Name").getValue().toString());
            donorDeatils.setCity(myds.child("City").getValue().toString());
            donorDeatils.setBloodgroup(myds.child("Blood Group").getValue().toString());
            donorDeatils.setMobile(myds.child("Contact").getValue().toString());
            donorDeatils.setEmail(myds.child("Email").getValue().toString());
            donors.add(donorDeatils);
//            Log.e("Firebase Retrival",donorDeatils.getAge());

        }
    }

    //RETRIEVE
    public ArrayList<DonorDeatils> retrieve(){
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

//                Log.i("muskan",dataSnapshot.child("5fjcFXiFq1Y0mPsXEu4qxMRoC8p2").child("Name").getValue().toString());
//                DonorDeatils donorDeatils = dataSnapshot.getValue(DonorDeatils.class);
//                donorDeatils.setUsername(dataSnapshot.child("Name").getValue().toString());
//                donorDeatils.setCity(dataSnapshot.child("City").getValue().toString());
//                donorDeatils.setMobile(dataSnapshot.child("Contact").getValue().toString());
//                donorDeatils.setBloodgroup(dataSnapshot.child("Blood Group").getValue().toString());
                getDetails(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getDetails(dataSnapshot);
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
        return donors;
    }

    public static ArrayList<DonorDeatils> getDonorMuskan(){
        return donors;
    }
}
