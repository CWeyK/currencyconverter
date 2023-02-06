package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Spinner initialCurrency,finalCurrency;
    EditText inputField;
    Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialise id
        inputField = findViewById(R.id.inputField);
        initialCurrency = findViewById(R.id.initialCurrency);
        finalCurrency = findViewById(R.id.finalCurrency);
        convertButton = findViewById(R.id.convertButton);
        Button resetButton = findViewById(R.id.resetButton);
        TextView result = findViewById(R.id.result);
        TextView rate = findViewById(R.id.rate);


        String[] from = {"MYR"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);
        initialCurrency.setAdapter(ad1);

        String[] to = {"GBP", "SGD", "USD", "THB", "IDR", "CNY", "JPY", "KRW"};
        ArrayAdapter ad2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, to);
        finalCurrency.setAdapter(ad2);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double tot;
                String rateDisplay = "-";
                Double rateMultiply = 0.0;
                String currencySymbol = "-";
                double amount = 0.0;

                //get initial amount

                //if user hasnt inputed any values do not do anything
                if (inputField.getText().length() > 0) {
                    amount = Double.parseDouble(inputField.getText().toString());

                    //calculate rates based on selected options
                    //MYR to GBP
                    if (initialCurrency.getSelectedItem().toString() == "MYR" && finalCurrency.getSelectedItem().toString() == "GBP") {
                        rateMultiply = 0.18;
                        rateDisplay = "1:0.18";
                        currencySymbol = "£";
                    }//MYR to SGD
                    else if (initialCurrency.getSelectedItem().toString() == "MYR" && finalCurrency.getSelectedItem().toString() == "SGD") {
                        rateMultiply = 0.30;
                        rateDisplay = "1:0.30";
                        currencySymbol = "$";
                    }//MYR to USD
                    else if (initialCurrency.getSelectedItem().toString() == "MYR" && finalCurrency.getSelectedItem().toString() == "USD") {
                        rateMultiply = 0.21;
                        rateDisplay = "1:0.21";
                        currencySymbol = "$";
                    }//MYR to THB
                    else if (initialCurrency.getSelectedItem().toString() == "MYR" && finalCurrency.getSelectedItem().toString() == "THB") {
                        rateMultiply = 7.82;
                        rateDisplay = "1:7.82";
                        currencySymbol = "฿";
                    }//MYR to IDR
                    else if (initialCurrency.getSelectedItem().toString() == "MYR" && finalCurrency.getSelectedItem().toString() == "IDR") {
                        rateMultiply = 3291.96;
                        rateDisplay = "1:3291.96";
                        currencySymbol = "Rp";
                    }//MYR to CNY
                    else if (initialCurrency.getSelectedItem().toString() == "MYR" && finalCurrency.getSelectedItem().toString() == "CNY") {
                        rateMultiply = 1.54;
                        rateDisplay = "1:1.54";
                        currencySymbol = "¥";
                    }//MYR to JPY
                    else if (initialCurrency.getSelectedItem().toString() == "MYR" && finalCurrency.getSelectedItem().toString() == "JPY") {
                        rateMultiply = 30.23;
                        rateDisplay = "1:30.23";
                        currencySymbol = "¥";
                    }//MYR to KRW
                    else if (initialCurrency.getSelectedItem().toString() == "MYR" && finalCurrency.getSelectedItem().toString() == "KRW") {
                        rateMultiply = 283.98;
                        rateDisplay = "1:283.98";
                        currencySymbol = "₩";
                    }

                    //print out results
                    tot = amount * rateMultiply;
                    DecimalFormat currency = new DecimalFormat("###,###.##");
                    result.setText("Converted amount: " + currencySymbol + currency.format(tot));
                    rate.setText("Rate: " + rateDisplay);

                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Converted amount: ");
                rate.setText("Rate: ");
            }
        });
    }

}