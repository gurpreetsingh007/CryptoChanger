package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btnconvert;
    public TextView info;
    public TextView result;
    public RadioGroup rg1;
    public RadioGroup rg2;
    public RadioButton usd1,usd2,bitcoin1,bitcoin2,ltc1,ltc2;
    public double usdtobitcoin;
    public double usdtousd;
    public double usdtoltc;
    public double bitcointusd;
    public double bitcointobitcoin;
    public double bitcointoltc;
    public double ltctousd;
    public double ltctobitcoin;
    public double ltctoltc;
    public double input1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnconvert = findViewById(R.id.convert);    // convert button
        info = findViewById(R.id.input1);           // type the amount
        rg1 = findViewById(R.id.rg1);               // radio group 1 top
        rg2 = findViewById(R.id.rg2);               // radio group 2 bottom
        result =findViewById(R.id.input2);          // result after conversion
        usd1 = findViewById(R.id.usd1);             // usd 1 on top
        usd2 = findViewById(R.id.usd2);             // usd 2 on bottom
        bitcoin1 = findViewById(R.id.bitcoins1);    // bitcoin 1 on top
        bitcoin2 = findViewById(R.id.bitcoins2);    // bitcoin 2 on bottom
        ltc1 = findViewById(R.id.ltc1);             // litecoinc 1 on top
        ltc2 = findViewById(R.id.ltc2);             // litecoin 2 on bottom

        usd1.setChecked(true);      //default checked box as usd1
        usd2.setChecked(true);
//        info.setText(String.valueOf(1.0)); // default value to 1.0
        btnconvert.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(info.getText().toString())){
                    info.setError("Please enter a number");
                    return;

                }
                input1 = Double.parseDouble(info.getText().toString());
                usdtobitcoin = input1*0.00029;
                usdtousd = input1*1.0;
                usdtoltc = input1*0.029;
                bitcointusd = input1*3451.00;
                bitcointobitcoin = input1*1.0;
                bitcointoltc = input1*101.34;
                ltctousd = input1*34.08;
                ltctobitcoin = input1*0.0099;
                ltctoltc = input1*1.0;
                RadioButton selected1 = findViewById(rg1.getCheckedRadioButtonId());
                RadioButton selected2 = findViewById(rg2.getCheckedRadioButtonId());
                String s2 = getResources().getResourceEntryName(selected1.getId()); // get the string id of 2nd button
                String s1 = getResources().getResourceEntryName(selected2.getId()); // get the string id of 1st button
                if(s1.equals("usd1")){
                    switch (s2){
                        case "usd2":
                            result.setText(String.valueOf(usdtousd));
                            break;
                        case "bitcoins2":
                            result.setText(String.valueOf(usdtobitcoin));
                            break;
                        case "ltc2":
                            result.setText(String.valueOf(usdtoltc));
                            break;
                    }
                }
                if(s1.equals("bitcoins1")){
                    switch (s2){
                        case "usd2":
                            result.setText(String.valueOf(bitcointusd));
                            break;
                        case "bitcoins2":
                            result.setText(String.valueOf(bitcointobitcoin));
                            break;
                        case "ltc2":
                            result.setText(String.valueOf(bitcointoltc));
                            break;
                    }
                }
                if(s1.equals("ltc1")){
                    switch (s2){
                        case "usd2":
                            result.setText(String.valueOf(ltctousd));
                            break;
                        case "bitcoins2":
                            result.setText(String.valueOf(ltctobitcoin));
                            break;
                        case "ltc2":
                            result.setText(String.valueOf(ltctoltc));
                            break;
                    }
                }
            }
        });
    }


}
