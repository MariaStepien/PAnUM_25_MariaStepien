package com.example.cafeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DrinkActivity extends Activity {
    public static final String EXTRA_DRINKID = "drinkId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);
        Drink drink = Drink.drinks[drinkId];

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(drink.getName());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(drink.getDescription());

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());

        TextView price = (TextView)findViewById(R.id.price);
        String text = (String) price.getText();
        text = text + drink.getPrice() + " zł";
        price.setText(text);
    }
    public void onClickMinus(View view) {
        TextView textView = (TextView) findViewById(R.id.amountId);
        String text = (String) textView.getText();
        int amount = Integer.parseInt(text);

        if (amount > 0) {
            amount--;
        }
        textView.setText(Integer.toString(amount));
    }

    public void onClickPlus(View view) {
        TextView textView = (TextView) findViewById(R.id.amountId);
        String text = (String) textView.getText();
        int amount = Integer.parseInt(text);

        if (amount >= 0) {
            amount++;
        }
        textView.setText(Integer.toString(amount));
    }
    public void onClickAddToChart(View view) {
        int drinkId = getIntent().getIntExtra(EXTRA_DRINKID, -1);
        if (drinkId == -1) return;

        Drink drink = Drink.drinks[drinkId];

        TextView textView = findViewById(R.id.amountId);
        int quantity = Integer.parseInt(textView.getText().toString());

        if (quantity > 0) {
            String itemName = drink.getName();
            float price = Float.parseFloat(drink.getPrice());

            Order.getInstance().addItem(itemName, quantity, price);

            Toast.makeText(this, itemName + " dodano do zamówienia", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wybierz ilość większą niż 0", Toast.LENGTH_SHORT).show();
        }
    }
}