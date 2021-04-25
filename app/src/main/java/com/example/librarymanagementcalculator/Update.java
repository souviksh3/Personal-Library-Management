package com.example.librarymanagementcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {


    EditText medt1,medt2,medt3;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        medt1 = findViewById(R.id.edt8);
        medt2 = findViewById(R.id.edt9);
        medt3 = findViewById(R.id.edt10);
        dbhelper = new DatabaseHelper(this);
    }


    public void updatefunc(View view)//update function code
    {
        String str_id =  medt1.getText().toString();
        String str_name = medt2.getText().toString();
        String str_author = medt3.getText().toString();

        Boolean check = dbhelper.updatedata(str_id,str_name,str_author); //Boolen to check data update
        //db helper.update is used to store data
        if(check)
        {
            Toast.makeText(this,"data updated",Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this,"Data not updated",Toast.LENGTH_LONG).show();
        }
    }

}
