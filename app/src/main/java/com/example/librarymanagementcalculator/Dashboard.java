package com.example.librarymanagementcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    TextView mtv1,mtv2,mtv3,mtv4,mtv5,mtv6;
    DatabaseHelper dbhelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mtv1 = findViewById(R.id.tv1);
        mtv2 = findViewById(R.id.tv2);
        mtv3 = findViewById(R.id.tv3);
        mtv4 = findViewById(R.id.tv4);
        mtv5 = findViewById(R.id.tv5);
        mtv6 = findViewById(R.id.tv6);

        mtv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Add.class);
                startActivity(intent);
            }
        });
        mtv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Delete.class);
                startActivity(intent);
            }
        });

        mtv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Update.class);
                startActivity(intent);
            }
        });


        mtv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Dashboard.this,Webview.class);
                startActivity(intent);
            }
        });
        mtv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Calculator.class);
                startActivity(intent);
            }
        });



    }
    public void  readfunc(View view)//read function code
    {
        Intent intent = new Intent(Dashboard.this,ShowBooks.class);
        Cursor res = dbhelper.readData();
        StringBuffer str_buffer = new StringBuffer();
        while(res.moveToNext())//move to next is used to check whether next row is available or not
        {
            str_buffer.append("ID: "+res.getString(0)+ "\n");
            str_buffer.append("Book: "+res.getString(1)+ "\n");
            str_buffer.append("Author: "+res.getString(2)+ "\n");
        }
        intent.putExtra("Data",str_buffer.toString());
        startActivity(intent);


    }

}
