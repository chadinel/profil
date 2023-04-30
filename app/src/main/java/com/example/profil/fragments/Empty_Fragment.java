package com.example.profil.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.profil.R;
import com.example.profil.adapter_recycle;
import com.example.profil.annonces;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class Empty_Fragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArrayList<annonces>liste1;
    public Empty_Fragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static Empty_Fragment newInstance() {
        Empty_Fragment fragment = new Empty_Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_empty_, container, false);
        recyclerView = view.findViewById(R.id.rec1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        liste1= new ArrayList<>();
        recyclerView.setAdapter(new adapter_recycle(getContext(),liste1));
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Produits");
        // Query the database for the products
       databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                liste1.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    annonces an = snapshot.getValue(annonces.class);
                    liste1.add(an);
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                Log.e("MyFragment", "Error getting data", databaseError.toException());
            }
        });
        return view;
        }

    }