package com.example.cafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SnackActivity extends AppCompatActivity {

    public static final String EXTRA_SNACKID = "snackId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);
        int snackId = (Integer)getIntent().getExtras().get(EXTRA_SNACKID);
        Snack snack = Snack.snacks[snackId];

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(snack.getName());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(snack.getDescription());

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(snack.getImageResourceId());
        photo.setContentDescription(snack.getName());

        TextView price = (TextView)findViewById(R.id.price);
        String text = (String) price.getText();
        text = text + snack.getPrice() + " zł";
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
        int snackId = getIntent().getIntExtra(EXTRA_SNACKID, -1);
        if (snackId == -1) return;

        Snack snack = Snack.snacks[snackId];

        TextView textView = findViewById(R.id.amountId);
        int quantity = Integer.parseInt(textView.getText().toString());

        if (quantity > 0) {
            String itemName = snack.getName();
            double price = Double.parseDouble(snack.getPrice());

            Order.getInstance().addItem(itemName, quantity, price);

            Toast.makeText(this, itemName + " dodano do zamówienia", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wybierz ilość większą niż 0", Toast.LENGTH_SHORT).show();
        }
    }
}