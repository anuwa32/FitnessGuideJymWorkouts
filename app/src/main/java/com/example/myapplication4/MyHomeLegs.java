package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyHomeLegs extends AppCompatActivity {

     private Button btn_legs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_home_legs);

        btn_legs = findViewById(R.id.btn_legs);
        btn_legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMainActivityJY();

            }
        });
    }

    public void openMainActivityJY(){

        Intent intent =  new Intent(this,MainActivityJY.class);
        startActivity(intent);
    }


}