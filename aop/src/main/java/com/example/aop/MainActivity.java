package com.example.aop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aop.aop.Event;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mtv = (TextView) findViewById(R.id.tv);
        mtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });

    }

    @Event(eventId = "id", parameterKey = "key", parameterValue = "value")
    private void show() {
        Toast.makeText(MainActivity.this, "aaa", Toast.LENGTH_SHORT).show();
    }
}
