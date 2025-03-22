package com.example.cafeapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LocationActivity extends AppCompatActivity {

    public static final String EXTRA_LOCATIONID = "locationId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        int locationId = (Integer)getIntent().getExtras().get(EXTRA_LOCATIONID);
        Location location = Location.locations[locationId];

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(location.getName());

        TextView address = (TextView)findViewById(R.id.address);
        address.setText(location.getAddress());

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(location.getImageResourceId());
        photo.setContentDescription(location.getName());

        TextView openingHours = (TextView)findViewById(R.id.openingHours);
        openingHours.setText(location.getOpeningHours());
    }
}