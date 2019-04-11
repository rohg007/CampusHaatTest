package com.example.android.campushaattest;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.campushaattest.adapters.AccomodationAdapter;
import com.example.android.campushaattest.models.Accomodation;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Accomodation> accomodations;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),"Go to overflow menu to test with dummy data", Toast.LENGTH_LONG).show();

        accomodations = new ArrayList<>();

        accomodations.add(new Accomodation(Accomodation.PG_TYPE,4,"Shastri Naggar, Jaipur"));
        accomodations.add(new Accomodation(Accomodation.HOSTEL_TYPE,6,"ML Nagar, Jaipur"));
        accomodations.add(new Accomodation(Accomodation.APARTMENT_TYPE,8,"VC Nagar, Jaipur"));

        recyclerView = findViewById(R.id.main_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        AccomodationAdapter adapter = new AccomodationAdapter(accomodations,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dummy_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.dummy_pg){
            accomodations.add(new Accomodation(Accomodation.PG_TYPE,1000,"Some Address"));
        }
        else if(id==R.id.dummy_hostel){
            accomodations.add(new Accomodation(Accomodation.HOSTEL_TYPE,1000,"Some Address"));
        }
        else if(id==R.id.dummy_apartment){
            accomodations.add(new Accomodation(Accomodation.APARTMENT_TYPE,1000,"Some Address"));
        }
        AccomodationAdapter adapter = new AccomodationAdapter(accomodations,this);
        recyclerView.setAdapter(adapter);
        return super.onOptionsItemSelected(item);
    }
}
