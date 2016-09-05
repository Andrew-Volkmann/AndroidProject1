package com.example.andrew.project1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the text fields

        final EditText firstnumber = (EditText) findViewById(R.id.firstNumber);
        final EditText firstBase = (EditText) findViewById(R.id.Base);
        final EditText newBase = (EditText) findViewById(R.id.newBase);
        final Button convertButton = (Button) findViewById(R.id.ConvertButton);
        final TextView finaltext = (TextView) findViewById(R.id.finalNumber);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstBase.setBackgroundColor(getResources().getColor(R.color.blank));
                int originalB = Integer.parseInt(firstBase.getText().toString());
                int base = Integer.parseInt(newBase.getText().toString());
                String newNumber = "";
                // after i click the button i want the dial pad to go way
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(newBase.getWindowToken(), 0);

                // try the conversion and if it does not work, catch the exception
                try {
                    newNumber = Long.toString(Long.parseLong(firstnumber.getText().toString(), originalB), base);

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, R.string.Toast, Toast.LENGTH_LONG).show();
                    firstBase.setBackgroundColor(getResources().getColor(R.color.errorColor));
                }
                finaltext.setText(newNumber);
            }
        });
    }
}
