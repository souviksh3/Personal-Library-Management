package com.example.librarymanagementcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {

    EditText medt3,medt4,medt5;
    Button mbtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        medt3=findViewById(R.id.edt3);
        medt4=findViewById(R.id.edt4);
        medt5=findViewById(R.id.edt5);
        mbtn3=findViewById(R.id.btn2);

        mbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = medt3.getText().toString();
                String u = medt4.getText().toString();
                String p = medt5.getText().toString();

                SharedPreferences sp = getSharedPreferences("USER", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("NAME",n);
                editor.putString("USERNAME",u);
                editor.putString("PASS",p);
                editor.apply();
                Toast.makeText(Sign_up.this, "Successfully Registered", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Sign_up.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

