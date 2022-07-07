package com.example.myapplication4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;

public class JYActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    DAOFitness dao;
    FirebaseRecyclerAdapter adapter;    //Define the variables


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);

        swipeRefreshLayout = findViewById(R.id.swip);  // Find the reference id
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        dao = new DAOFitness();

        FirebaseRecyclerOptions<Fitness> option =
                new FirebaseRecyclerOptions.Builder<Fitness>()
                        .setQuery(dao.get(), new SnapshotParser<Fitness>() {

                            @NonNull
                            @Override

                            public Fitness parseSnapshot(@NonNull DataSnapshot snapshot) {

                                Fitness fit  =  snapshot.getValue(Fitness.class);
                                fit.setKey(snapshot.getKey());

                                return fit;
                            }
                        }).build();

                adapter = new FirebaseRecyclerAdapter(option) {
                    @Override
                    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull Object o)
                    {
                        //Display the details in text field

                        FitnessVH vh = (FitnessVH) viewHolder;  //Fitness view holder class
                        Fitness fit = (Fitness)o;
                        vh.txt_date.setText(fit.getDate());
                        vh.txt_forearms.setText(fit.getForearms());
                        vh.txt_biceps.setText(fit.getBiceps());
                        vh.txt_triceps.setText(fit.getTriceps());
                        vh.txt_upper_chest.setText(fit.getUpper_chest());
                        vh.txt_lower_chest.setText(fit.getLower_chest());
                        vh.txt_both.setText(fit.getBoth());
                        vh.txt_squat.setText(fit.getSquat());
                        vh.txt_leg_press.setText(fit.getLeg_press());
                        vh.txt_running_machine.setText(fit.getRunning_machine());

                        vh.txt_option.setOnClickListener(view ->
                        {
                            PopupMenu popupMenu = new PopupMenu(JYActivity.this,vh.txt_option);
                            popupMenu.inflate(R.menu.option_menu);
                            popupMenu.setOnMenuItemClickListener(item->{

                                switch(item.getItemId())
                                {
                                    case R.id.menu_edit:

                                        Intent intent = new Intent(JYActivity.this, MainActivityJY.class);
                                        intent.putExtra("EDIT",fit);
                                        startActivity(intent);
                                        break;

                                    case R.id.menu_remove:

                                        DAOFitness dao = new DAOFitness();
                                        dao.remove(fit.getKey()).addOnSuccessListener(suc->
                                        {
                                            Toast.makeText(JYActivity.this, "Details are successfully removed", Toast.LENGTH_SHORT).show();


                                        }).addOnFailureListener(er->
                                        {
                                            Toast.makeText(JYActivity.this, "error"+er.getMessage(), Toast.LENGTH_SHORT).show();

                                        });

                                        break;
                                }
                                return false;
                            });
                            popupMenu.show();
                        });

                    }

                    @NonNull
                    @Override
                    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
                    {
                        View view =  LayoutInflater.from(JYActivity.this).inflate(R.layout.layout_itemf,parent,false);
                        return new FitnessVH(view);
                    }

                    @Override
                    public void onDataChanged() {

                        //Toast.makeText(JYActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                };

                recyclerView.setAdapter(adapter);



    }

                     @Override
                           protected void onStart() {

                                 super.onStart();
                                 adapter.startListening();
                     }

                      @Override
                           protected void onStop() {


                                   super.onStop();
                                   adapter.stopListening();
                      }
}