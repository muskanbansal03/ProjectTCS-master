package com.example.keshav.projecttcs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by muskan on 10-07-2017.
 */

public class SQLiteListAdapter{

   /* Context context;

    ArrayList<String> userID;
    ArrayList<String> UserName;
    ArrayList<String> User_PhoneNumber;
    ArrayList<String> UserCity ;


    public SQLiteListAdapter(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> name,
            ArrayList<String> phone,
            ArrayList<String> city
    )
    {

        this.context = context2;
        this.userID = id;
        this.UserName = name;
        this.User_PhoneNumber = phone;
        this.UserCity = city ;
    }

    @Override
    public int getCount() {
        return userID.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return null;

        Holder holder;

        LayoutInflater layoutInflater;

        if (convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listviewdatalayout, null);

            holder = new Holder();

            holder.textviewid = (TextView) convertView.findViewById(R.id.textViewID);
            holder.textviewname = (TextView) convertView.findViewById(R.id.textViewNAME);
            holder.textviewphone_number = (TextView) convertView.findViewById(R.id.textViewPHONE_NUMBER);
            holder.textviewcity = (TextView) convertView.findViewById(R.id.textViewCITY);

            convertView.setTag(holder);

        } else {

            holder = (Holder) convertView.getTag();
        }
        holder.textviewid.setText(userID.get(position));

        //holder.textviewname.setText();


        holder.textviewname.setText(UserName.get(position));
        holder.textviewphone_number.setText(User_PhoneNumber.get(position));
        holder.textviewcity.setText(UserCity.get(position));

        return convertView;
    }

    public class Holder {
        TextView textviewid;
        TextView textviewname;
        TextView textviewphone_number;
        TextView textviewcity;
    }*/

}
