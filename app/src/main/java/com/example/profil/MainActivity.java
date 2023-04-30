package com.example.profil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

import com.example.profil.fragments.Empty_Fragment;
import com.example.profil.fragments.Pending_Fragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabl1;
    NestedScrollView NS1;
    Fragment frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabl1=findViewById(R.id.tabl1);

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