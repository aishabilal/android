package com.example.alirazarao.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;
import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
    String name,ph;
    int id;
    DatabaseHandler mydb;
    CustomAdapter mCustomAdapter;
    private ArrayList<Contact> cnArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNextScreen = (Button) findViewById(R.id.btn_add);

        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_add_contact, null);
                final EditText mid = (EditText) mView.findViewById(R.id.txt_id);
                final EditText mname = (EditText) mView.findViewById(R.id.txt_name);
                final EditText mph = (EditText) mView.findViewById(R.id.txt_phone);
                final Button btnadd = (Button) mView.findViewById(R.id.btnAdd_DB);
                builder.setView(mView);
                final AlertDialog dialog = builder.create();
                dialog.show();

                btnadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        id = Integer.valueOf(mid.getText().toString());
                        name = mname.getText().toString();
                        ph=mph.getText().toString();

                        Contact cn = new Contact(name, id, ph);

                        if (name.length() != 0) {
                            add(id, name, ph);
                            mid.setText("");
                            mname.setText("");
                            mph.setText("");

                            dialog.dismiss();

                        } else {
                            Toast.makeText(MainActivity.this, "You must fill in the text fields!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }


        });
        Button btnNextScreen2 = (Button) findViewById(R.id.btn_Show);

        btnNextScreen2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent nextScreen2 = new Intent(getApplicationContext(),
                        ShowContactActivity.class);
                startActivity(nextScreen2);
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_delete, null);
                final EditText mid = (EditText) mView.findViewById(R.id.txt_id);
                final EditText mname = (EditText) mView.findViewById(R.id.txt_name);
                final EditText mph = (EditText) mView.findViewById(R.id.txt_phone);
                Button btndell = (Button) mView.findViewById(R.id.btnDel_DB);
                builder.setView(mView);
                final AlertDialog dialog = builder.create();
                dialog.show();
                btndell.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name = mname.getText().toString();
                        id = Integer.valueOf(mid.getText().toString());

                        ph=mph.getText().toString();
                        for(int i=0;i<cnArrayList.size();i++){
                            if(cnArrayList.get(i).getID()==id){
                                cnArrayList.remove(i);
                            }
                        }
                        if (delete(id)) {
                            mCustomAdapter.notifyDataSetChanged();
                        }

                        dialog.dismiss();
                    }
                });


            }
        });
    }






    private void add(int id, String name, String ph) {
    }
    private boolean delete(int id) {
        boolean result = mydb.deleteContact(id);
        if (result) {
            Toast.makeText(MainActivity.this, " deleted :(.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "not deleted :(.", Toast.LENGTH_LONG).show();
        }

        return result;
    }

}



