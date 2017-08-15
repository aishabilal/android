package com.example.alirazarao.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Button btnDelete = (Button) findViewById(R.id.btnDel_DB);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EditText txtPhone_del = (EditText)
                        findViewById(R.id.txt_phone_del);

                DatabaseHandler db = new DatabaseHandler(DeleteActivity.this);
                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfExist((txtPhone_del.getText().toString()));
                if(found)
                {

                    Contact ct = new Contact();
                    ct.setPhoneNumber((txtPhone_del.getText().toString()));
                    db.deleteContact(ct);
                    Toast.makeText(getApplicationContext(), "Record Deleted",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Record Not Found",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

