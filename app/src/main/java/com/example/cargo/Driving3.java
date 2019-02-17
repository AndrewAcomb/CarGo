package com.example.cargo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Driving3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving3);

        Button dropperson = findViewById(R.id.dropperson);
        dropperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDrop();
            }
        });
    }

    private void goToDrop() {
        Intent intent = new Intent(this, Drop.class);
        startActivity(intent);
    }

}
