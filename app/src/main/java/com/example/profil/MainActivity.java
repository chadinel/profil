package com.example.profil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.profil.fragments.Empty_Fragment;
import com.example.profil.fragments.Pending_Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TabLayout tabl1;
    NestedScrollView NS1;
    Fragment frag;
    TextView nom;
    DatabaseReference databaseReference;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabl1=findViewById(R.id.tabl1);
        nom=findViewById(R.id.prenom);
        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
        //Chenger le nom propre a l'utilisateur
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.child("Registered Users").getChildren()) {
                    if(snapshot.getKey().equals(userId)){
                    String nomComplet = snapshot.child("nomComplet").getValue(String.class);
                    nom.setText(nomComplet);}

                }

            }
        public void onCancelled(DatabaseError databaseError) {
            Log.e("MyFragment", "Error getting data", databaseError.toException());
        }
    });


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frag, new Empty_Fragment());
        ft.commit();

        tabl1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position=tab.getPosition();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (position){
                    case 0:
                        ft.replace(R.id.frag, new Empty_Fragment());
                        ft.commit();
                        break;
                    case 1:
                        ft.replace(R.id.frag, new Pending_Fragment());
                        ft.commit();
                        break;
                    default:
                        ft.replace(R.id.frag, new Empty_Fragment());
                        ft.commit();
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}