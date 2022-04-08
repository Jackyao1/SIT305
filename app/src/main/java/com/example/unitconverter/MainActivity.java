package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //initialization
    EditText editText;
    ImageButton meterButton;
    ImageButton tempButton;
    ImageButton weightButton;



    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        editText = (EditText) findViewById(R.id.editText1);

        TextView result1 = findViewById(R.id.result1);
        TextView result2 = findViewById(R.id.result2);
        TextView result3 = findViewById(R.id.result3);
        TextView unit1 = findViewById(R.id.unit1);
        TextView unit2 = findViewById(R.id.unit2);
        TextView unit3 = findViewById(R.id.unit3);


        meterButton = (ImageButton) findViewById(R.id.meterButton);
        meterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (parent.getItemAtPosition(pos).equals("Meters")) {
                    Double num = Double.parseDouble(editText.getText().toString());
                    result1.setText(String.format("%.3f", num * 100));
                    unit1.setText("Centimetres");
                    result2.setText(String.format("%.3f", num * 3.281));
                    unit2.setText("Foot");
                    result3.setText(String.format("%.3f", num * 39.37));
                    unit3.setText("Inches");
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please select the correct conversion icon", Toast.LENGTH_LONG).show();
                }
            }
        });

        tempButton = (ImageButton) findViewById(R.id.tempButton);
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (parent.getItemAtPosition(pos).equals("Celsius")){
                    Double num = Double.parseDouble(editText.getText().toString());
                    result1.setText(String.format("%.3f", (num*9/5)+32));
                    unit1.setText("Fahrenheit");
                    result2.setText(String.format("%.3f", num+273.15));
                    unit2.setText("Kelvin");
                    result3.setText("");
                    unit3.setText("");

                }
                else{
                    Toast.makeText(getApplicationContext(),"Please select the correct conversion icon",Toast.LENGTH_LONG).show();
                }
            }
        });

        weightButton = (ImageButton) findViewById(R.id.weightButton);
        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (parent.getItemAtPosition(pos).equals("Kilograms")){
                    Double num = Double.parseDouble(editText.getText().toString());
                    result1.setText(String.format("%.3f", num*1000));
                    unit1.setText("Gram");
                    result2.setText(String.format("%.3f", num*35.275));
                    unit2.setText("Ounce(Oz)");
                    result3.setText(String.format("%.3f", num*2.205));
                    unit3.setText("Pound(lb)");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please select the correct conversion icon",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
}
}