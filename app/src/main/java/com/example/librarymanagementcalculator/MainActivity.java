package com.example.librarymanagementcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText medt1, medt2;
    Button mbtn1, mbtn2;
    TextView mtv1;

    String u, p;
//    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medt1 = findViewById(R.id.edt1);
        medt2 = findViewById(R.id.edt2);
        mbtn1 = findViewById(R.id.btn1);
        mbtn2 = findViewById(R.id.shbtn1);
        mtv1 = findViewById(R.id.tv1);

        SharedPreferences sp = getSharedPreferences("USER", Context.MODE_PRIVATE);
        u = sp.getString("USERNAME", null);
        p = sp.getString("PASS", null);


        mbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "username:" + u + "Password:" + p, Toast.LENGTH_LONG).show();
            }
        });




        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (medt1.getText().toString().equals(u) && medt2.getText().toString().equals(p)) {
                    Intent i = new Intent(MainActivity.this, Dashboard.class);
                    startActivity(i);
//

                } else {

                    Toast.makeText(MainActivity.this,
                            "Incorrect username or password", Toast.LENGTH_SHORT).show();

                }

            }
        });
        if( u!=null && p != null)
        {
            Intent intent = new Intent(MainActivity.this,Dashboard.class);
            startActivity(intent);
        }

        mtv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sign_up.class);
                startActivity(intent);
                finish();
            }
        });


    }

}