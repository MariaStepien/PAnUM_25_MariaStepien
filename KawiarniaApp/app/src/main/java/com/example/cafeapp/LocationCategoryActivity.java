package com.example.cafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LocationCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_category);
        ArrayAdapter<Location> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Location.locations);
        ListView listLocations = (ListView) findViewById(R.id.list_locations);
        listLocations.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> listLocations,
                                            View itemView,
                                            int position,
                                            long id) {
                        Intent intent = new Intent(LocationCategoryActivity.this,
                                LocationActivity.class);
                        intent.putExtra(LocationActivity.EXTRA_LOCATIONID, (int) id);
                        startActivity(intent);
                    }
                };
        listLocations.setOnItemClickListener(itemClickListener);
    }
}