package com.example.librarymanagementcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Delete extends AppCompatActivity {
    EditText medt1;
    Button   mbtn1;
    TextView mtv1;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        medt1 = findViewById(R.id.ed1);
        mtv1 = findViewById(R.id.t1);
        dbhelper = new DatabaseHelper(Delete.this);
    }

    public void deletefunc(View view)//delete function code
    {
        String str_id =  medt1.getText().toString();

        Integer check = dbhelper.deletedata(str_id);

        if(check>0)
        {
            Toast.makeText(this,"Data deleted",Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(this,"no Data",Toast.LENGTH_LONG).show();
        }
    }
}


