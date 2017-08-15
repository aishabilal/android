package com.example.alirazarao.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNextScreen = (Button) findViewById(R.id.btn_add);

        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent nextScreen = new Intent(getApplicationContext(),
                        Add_Contact.class);
                startActivity(nextScreen);
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

                Intent Intent_Del = new Intent(getApplicationContext(),
                        DeleteActivity.class);
                startActivity(Intent_Del);
            }
        });
        Button btnUpdate = (Button) findViewById(R.id.btn_update);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent Intent_update = new Intent(getApplicationContext(),
                        UpdateActivity.class);
                startActivity(Intent_update);
            }
        });
    }
}
