package com.example.alirazarao.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ali Raza Rao on 21-Aug-17.
 */

class CustomAdapter extends BaseAdapter {


    Context context;
    ArrayList<Contact> cnArrayList;

    public CustomAdapter(Context mContext, ArrayList<Contact> cnArrayList) {

        this.context = mContext;
        this.cnArrayList = cnArrayList;
    }




    @Override
    public int getCount() {
        return cnArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return cnArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.custom_row, null);

        }


        TextView id= (TextView) v.findViewById(R.id.txt_id);
        TextView name= (TextView) v.findViewById(R.id.txt_name);
        TextView ph= (TextView) v.findViewById(R.id.txt_phone);


        id.setText(cnArrayList.get(i).getID());
        name.setText(cnArrayList.get(i).getName());
        ph.setText(cnArrayList.get(i).getPhoneNumber());

        return v;
    }
}

