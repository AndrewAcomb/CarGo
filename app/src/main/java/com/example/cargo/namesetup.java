package com.example.cargo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class namesetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namesetup);

        Button begintrip = findViewById(R.id.begintrip);
        begintrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDriving();
            }
        });

        Button back2 = findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToSetup();
            }
        });

    }

    private void goToDriving() {


        /// This is for the backend ///

        // setting the_trip
        Trip the_trip = ((makeglobaltrip) this.getApplication()).getSomeVariable();
        // setting the_trip

        the_trip.enterName("Andrew");
        the_trip.enterName("Jenny");

        /// This is for the backend ///


        Intent intent = new Intent(this, Driving.class);
        startActivity(intent);
    }


    private void goBackToSetup() {
        Intent intent = new Intent(this, Setup.class);
        startActivity(intent);
    }
}
