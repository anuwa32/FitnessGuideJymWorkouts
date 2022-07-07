package com.example.myapplication4;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FitnessVH extends RecyclerView.ViewHolder

{
    //Define the textView

    public TextView txt_date,txt_forearms,txt_biceps,txt_triceps,txt_upper_chest,txt_lower_chest,txt_both,txt_squat,txt_leg_press,txt_running_machine,txt_option;

    public FitnessVH(@NonNull View itemView) {


        super(itemView);
        txt_date = itemView.findViewById(R.id.txt_date);          // find the reference id by itemView
        txt_forearms = itemView.findViewById(R.id.txt_forearms);
        txt_biceps = itemView.findViewById(R.id.txt_biceps);
        txt_triceps = itemView.findViewById(R.id.txt_triceps);
        txt_upper_chest = itemView.findViewById(R.id.txt_upper_chest);
        txt_lower_chest = itemView.findViewById(R.id.txt_lower_chest);
        txt_both =  itemView.findViewById(R.id.txt_both);
        txt_squat = itemView.findViewById(R.id.txt_squat);
        txt_leg_press = itemView.findViewById(R.id.txt_leg_press);
        txt_running_machine =  itemView.findViewById(R.id.txt_running_machine);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}
