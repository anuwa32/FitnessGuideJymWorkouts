package com.example.myapplication4;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Queue;

public class DAOFitness {

    // Database connection

    private DatabaseReference databaseReference;   //Define the database reference
    public DAOFitness()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Fitness.class.getSimpleName());
    }

    public Task<Void> add(Fitness fit) // insert data
    {

       return databaseReference.push().setValue(fit);
    }

    public Task<Void> update(String key , HashMap<String, Object> hashMap)  // find the key and update
    {
        return databaseReference.child(key).updateChildren(hashMap);
    }

    public Task<Void> remove (String key) // find the key and delete
    {
        return databaseReference.child(key).removeValue();
    }

    public Query get(String key)     // Get the details in database

    {
        if(key == null)
        {
            return databaseReference.orderByKey().limitToFirst(16);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(16);
    }

    public Query get()
    {
        return databaseReference;
    }
}
