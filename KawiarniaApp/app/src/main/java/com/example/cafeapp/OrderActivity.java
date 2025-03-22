package com.example.cafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderActivity extends AppCompatActivity {

    private LinearLayout orderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderLayout = findViewById(R.id.orderLayout);
        ListView listOrders = findViewById(R.id.list_orders);
        TextView totalTextView = findViewById(R.id.totalText);

        Order order = Order.getInstance();

        if (order.isEmpty()) {
            TextView emptyMessage = new TextView(this);
            emptyMessage.setText("Zamówienie nie posiada żadnych elementów.");
            emptyMessage.setTextSize(18);
            orderLayout.addView(emptyMessage);
        } else {
            List<String> orderList = new ArrayList<>();
            for (Map.Entry<String, Order.OrderItem> entry : order.getItems().entrySet()) {
                String itemName = entry.getKey();
                Order.OrderItem item = entry.getValue();
                orderList.add(itemName + " x " + item.quantity + " - Cena: " + item.getTotalPrice() + " zł");
            }

            ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderList);
            listOrders.setAdapter(listAdapter);

            totalTextView.setText("Suma: " + order.getTotalOrderPrice() + " zł");
        }
    }

    public void onClickOrder(View view) {
        Toast.makeText(this, "Zamówienie zostało złożone.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(OrderActivity.this, MainActivity.class);
        startActivity(intent);

        Order.getInstance().clearOrder();

    }
}