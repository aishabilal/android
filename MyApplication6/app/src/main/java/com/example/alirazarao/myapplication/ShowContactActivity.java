package com.example.alirazarao.myapplication;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class ShowContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);
        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();
        String log=null;
        String [] contact_array = new String[contacts.size()];
        int i=0;
        for (Contact cn : contacts) {
            contact_array[i] = cn.getName() +" ("+ cn.getPhoneNumber() + ") ";
            log = log + "Id: " + cn.getID() + " ,Name: " + cn.getName() + ",Phone: " + cn.getPhoneNumber();

            Log.d("Name: ", log);
            i++;
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1 , contact_array);
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
    }

}
