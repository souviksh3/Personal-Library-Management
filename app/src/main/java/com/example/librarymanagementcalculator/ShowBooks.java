package com.example.librarymanagementcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

public class ShowBooks extends AppCompatActivity {
    TextView mtv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_books);
        mtv7 = findViewById(R.id.tv7);

        String res =  getIntent().getStringExtra("Data");

        if(res.length()==0)
            {
                mtv7.setText("no data available");
                return;
            }
            mtv7.setText(res);

    }

}

