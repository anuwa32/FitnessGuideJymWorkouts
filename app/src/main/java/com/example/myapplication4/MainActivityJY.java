package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

public class MainActivityJY extends AppCompatActivity {


    //initialize variable

     TextView tvDate;
     EditText edit_data;
     DatePickerDialog.OnDateSetListener setListener;

   // AwesomeValidation awesomeValidation;



    // date type

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvDate = findViewById(R.id.tv_date);
        edit_data = findViewById(R.id.edit_date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(

                        MainActivityJY.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                         datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                         datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day+"/"+month+"/"+year;
                tvDate.setText(date);

            }
        };

        edit_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog =  new DatePickerDialog(

                        MainActivityJY.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        month = month+1;
                        String date =  day+"/"+month+"/"+year;
                        edit_data.setText(date);
                    }
                },year,month,day);
                 datePickerDialog.show();

            }
        });




        //find reference from xml file control by using id
        
        final EditText edit_date = findViewById(R.id.edit_date);
        final EditText edit_forearms = findViewById(R.id.edit_forearms);
        final EditText edit_biceps = findViewById(R.id.edit_biceps);
        final EditText edit_triceps = findViewById(R.id.edit_triceps);
        final EditText edit_upper_chest = findViewById(R.id.edit_upper_chest);
        final EditText edit_lower_chest = findViewById(R.id.edit_lower_chest);
        final EditText edit_both = findViewById(R.id.edit_both);
        final EditText edit_squat = findViewById(R.id.edit_squat);
        final EditText edit_leg_press = findViewById(R.id.edit_leg_press);
        final EditText edit_running_machine = findViewById(R.id.edit_running_machine);

        /*
        //Initialize validation style
        awesomeValidation= new AwesomeValidation(ValidationStyle.BASIC);

        //add validation

        awesomeValidation.addValidation(this,R.id.edit_date, RegexTemplate.NOT_EMPTY,R.string.invalid_date);
         */



        Button btn = findViewById(R.id.btn_submit);
        Button btn_open =  findViewById(R.id.btn_open);

        btn_open.setOnClickListener(v->
        {
            Intent intent = new Intent(MainActivityJY.this, JYActivity.class);  //redirect JVActivity class

            startActivity(intent);
        });


        DAOFitness dao = new DAOFitness();
        Fitness fit_edit = (Fitness)getIntent().getSerializableExtra("EDIT");

        if(fit_edit!=null)
        {


            btn.setText("UPDATE");
            edit_date.setText(fit_edit.getDate());
            edit_forearms.setText(fit_edit.getForearms());
            edit_biceps.setText(fit_edit.getBiceps());
            edit_triceps.setText(fit_edit.getTriceps());
            edit_upper_chest.setText(fit_edit.getUpper_chest());
            edit_lower_chest.setText(fit_edit.getLower_chest());
            edit_both.setText(fit_edit.getBoth());
            edit_squat.setText(fit_edit.getSquat());
            edit_leg_press.setText(fit_edit.getLeg_press());
            edit_running_machine.setText(fit_edit.getRunning_machine());

            btn_open.setVisibility(View.GONE);
        }
        else {

            btn.setText("SUBMIT");
            btn_open.setVisibility(View.VISIBLE);
        }

        btn.setOnClickListener(v->
        {



            //insert data to the firebase

                Fitness fit = new Fitness(edit_date.getText().toString(), edit_forearms.getText().toString(), edit_biceps.getText().toString(), edit_triceps.getText().toString(), edit_upper_chest.getText().toString(), edit_lower_chest.getText().toString(), edit_both.getText().toString(), edit_squat.getText().toString(), edit_leg_press.getText().toString(), edit_running_machine.getText().toString());
                if (fit_edit == null) {


                               //call the methods from DAOFitness class
                        dao.add(fit).addOnSuccessListener(suc ->
                        {

                            Toast.makeText(this, "Details are successfully inserted", Toast.LENGTH_SHORT).show();
                        }).addOnFailureListener(er ->
                        {
                            Toast.makeText(this, "error" + er.getMessage(), Toast.LENGTH_SHORT).show();
                        });


                } else {

                    // data update

                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("date", edit_date.getText().toString());
                    hashMap.put("forearms", edit_forearms.getText().toString());
                    hashMap.put("biceps", edit_biceps.getText().toString());
                    hashMap.put("triceps", edit_triceps.getText().toString());
                    hashMap.put("upper_chest", edit_upper_chest.getText().toString());
                    hashMap.put("lower_chest", edit_lower_chest.getText().toString());
                    hashMap.put("both", edit_both.getText().toString());
                    hashMap.put("squat", edit_squat.getText().toString());
                    hashMap.put("leg_press", edit_leg_press.getText().toString());
                    hashMap.put("running_machine", edit_running_machine.getText().toString());


                    dao.update(fit_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                    {
                        Toast.makeText(this, "Details are successfully updated", Toast.LENGTH_SHORT).show();
                        finish();
                    }).addOnFailureListener(er ->  // if details are fail
                    {
                        Toast.makeText(this, "error" + er.getMessage(), Toast.LENGTH_SHORT).show();
                    });


                }



        });



    }
}
