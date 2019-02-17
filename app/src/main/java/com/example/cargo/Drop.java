package com.example.cargo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Drop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        double price = 0.00;

        try {/// This is for the backend ///

            // setting the_trip
            Trip the_trip = ((makeglobaltrip) this.getApplication()).getSomeVariable();
            // setting the_trip

            price = the_trip.dropOff("Zain");

            /// This is for the backend ///
        }

        catch(Exception e) {}

        finally {
            price = 0.00;
        }


        TextView t = (TextView) findViewById(R.id.price);
        t.setText("" + price);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop);

        Button confirmdrop = findViewById(R.id.confirmdrop);
        confirmdrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDriving();
            }
        });

        Button back3 = findViewById(R.id.back3);
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDriving3();
            }
        });
    }

    private void goToDriving() {
        Intent intent = new Intent(this, Driving.class);
        startActivity(intent);
    }

    private void goToDriving3() {
        Intent intent = new Intent(this, Driving3.class);
        startActivity(intent);
    }
}
