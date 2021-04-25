package com.example.librarymanagementcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    EditText medt1,medt2,medt3;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        medt1= findViewById(R.id.edt1);
        medt2 = findViewById(R.id.edt2);
        medt3 = findViewById(R.id.edt3);

        dbhelper = new DatabaseHelper(this);


    }
    public void addfunc(View view) //add button code
    {
        String str_id   = medt1.getText().toString();
        String str_name = medt2.getText().toString();
        String str_author = medt3.getText().toString();

        Boolean check = dbhelper.insertdata(str_id,str_name,str_author);

        if(check)
        {
            Toast.makeText(this,"data inserted",Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this,"Data not inserted",Toast.LENGTH_LONG).show();
        }
    }
}
