package com.example.alirazarao.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class UpdateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final EditText txt_update_search = (EditText)
                findViewById(R.id.txt_update_search);

        final TextView lbl_name = (TextView) findViewById(R.id.lbl_name);
        final EditText txt_update_name = (EditText)
                findViewById(R.id.txt_update_name);
        final TextView lbl_phone = (TextView) findViewById(R.id.lbl_phone);
        final EditText txt_update_phone = (EditText)
                findViewById(R.id.txt_update_phone);
        final Button btnUpdate_DB = (Button) findViewById(R.id.btnUpdate_DB);
        lbl_name.setVisibility(View.INVISIBLE);
        txt_update_name.setVisibility(View.INVISIBLE);
        lbl_phone.setVisibility(View.INVISIBLE);
        txt_update_phone.setVisibility(View.INVISIBLE);
        btnUpdate_DB.setVisibility(View.INVISIBLE);
        Button btnsearch_DB = (Button) findViewById(R.id.btnsearch_DB);

        btnsearch_DB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                DatabaseHandler db = new DatabaseHandler(UpdateActivity.this);
                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfExist((txt_update_search.getText().toString()));
                if (found) {
                    lbl_name.setVisibility(View.VISIBLE);
                    txt_update_name.setVisibility(View.VISIBLE);
                    lbl_phone.setVisibility(View.VISIBLE);
                    txt_update_phone.setVisibility(View.VISIBLE);
                    btnUpdate_DB.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Found Phone Number", Toast.LENGTH_SHORT).show();

                    Button btnUpdate_DB = (Button) findViewById(R.id.btnUpdate_DB);

                    btnUpdate_DB.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View arg0) {

                            Contact contact = new Contact();
                            contact.setName(txt_update_name.getText().toString());
                            contact.setPhoneNumber(txt_update_phone.getText().toString());
                            DatabaseHandler db = new DatabaseHandler(UpdateActivity.this);
                            db.updateContact_Phone(contact, txt_update_search.getText().toString());
                            Toast toast = new Toast(getApplicationContext());
                            toast.setDuration(Toast.LENGTH_LONG);
                            toast.show();

                        }
                    });
                } else {
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.show();

                }
            }
        });
    }
}

