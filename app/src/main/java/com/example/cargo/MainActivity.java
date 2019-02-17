package com.example.cargo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.start);                        //Button START TRIP
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStartTrip();

            }
        });
    }

    private void goToStartTrip() {                                      //Button START TRIP
        Intent intent = new Intent(MainActivity.this, Setup.class);
        startActivity(intent);
    }
}
