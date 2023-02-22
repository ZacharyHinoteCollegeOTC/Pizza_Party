package com.example.pizzaparty;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
//import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    public final int SLICES_PER_PIZZA = 8;

    private EditText mNumAttendEditText;
    //private TextView mNumPizzasTextView;
    //private RadioGroup mHowHungryRadioGroup;

    private Slider mHowHungrySlider;
    public String item = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Assign the widgets to fields
        mNumAttendEditText = findViewById(R.id.num_attend_edit_text);
        //mNumPizzasTextView = findViewById(R.id.num_pizzas_text_view);
        //mHowHungryRadioGroup = findViewById(R.id.hungry_radio_group);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hungry_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });



    }

    public void calculateClick(View view) {

        // Get the text that was typed into the EditText
        String numAttendStr = mNumAttendEditText.getText().toString();

        // Convert the text into an integer
        int numAttend = Integer.parseInt(numAttendStr);

        // Determine how many slices on average each person will eat
        int slicesPerPerson = 0;
        //int checkedId = mHowHungrySlider.get
        String checkedId = item;
        if (checkedId == "light") {
            slicesPerPerson = 2;
        }
        else if (checkedId == "medium") {
            slicesPerPerson = 3;
        }
        else if (checkedId == "ravenous") {
            slicesPerPerson = 4;
        }



        // Calculate and show the number of pizzas needed
        int totalPizzas = (int) Math.ceil(numAttend * slicesPerPerson /
                (double) SLICES_PER_PIZZA);
        //mNumPizzasTextView.setText("Total pizzas: " + totalPizzas);
        Toast.makeText(MainActivity.this, "Total pizzas: " + totalPizzas, Toast.LENGTH_LONG).show();


    }



}