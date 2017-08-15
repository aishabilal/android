package com.example.alirazarao.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Add_Contact extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        Button btnNextScreen = (Button) findViewById(R.id.btnAdd_DB);

        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EditText txtName = (EditText) findViewById(R.id.txt_name);
                EditText txtPhone = (EditText) findViewById(R.id.txt_phone);

                DatabaseHandler db = new DatabaseHandler(Add_Contact.this);
                Log.d("Insert: ", "Inserting ..");
                db.addContact(new Contact(txtName.getText().toString(), txtPhone.getText().toString()));
                Toast.makeText(getApplicationContext(), "Contact Added Successfully" + txtPhone.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


