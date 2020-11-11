package com.example.android.androidexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int unknownNum;
    private EditText edtNum;
    int topValue;
    int bottomValue;
    TextView txtViewTop;
    TextView txtViewBottom;
    Button btnGuess;
    Button btnQuestion;
    String message;
    int numCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get value from application class to make the unknown value the same across all activities
        unknownNum = ((AppValues) getApplicationContext()).unknown;

        edtNum = (EditText) findViewById(R.id.edtNum);
        txtViewTop = (TextView) findViewById(R.id.topValue);
        txtViewBottom = (TextView) findViewById(R.id.bottomValue);

        bottomValue = ((AppValues) getApplicationContext()).getBottomValue();
        topValue = ((AppValues) getApplicationContext()).getTopValue();

        txtViewBottom.setText(String.valueOf(bottomValue));
        txtViewTop.setText(String.valueOf(topValue));

        btnQuestion = (Button) findViewById(R.id.btnQuestion);
        btnQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnQuestion.setText(String.valueOf(unknownNum));
            }
        });

        btnGuess = (Button) findViewById(R.id.btnGuess);
        btnGuess.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    numCheck = Integer.parseInt(edtNum.getText().toString());
                } catch(Exception e) {
                    e.printStackTrace();
                }

                if (numCheck <= 100 && numCheck >= 0) {
                    if (unknownNum == numCheck) {
                        message = getResources().getString(R.string.status_correct);
                    } else if (unknownNum < numCheck) {
                        message = getResources().getString(R.string.status_greater);
                        ((AppValues) getApplicationContext()).setBottomValue(numCheck);
                    } else if (unknownNum > numCheck) {
                        message = getResources().getString(R.string.status_lower);
                        ((AppValues) getApplicationContext()).setTopValue(numCheck);
                    }
                } else {
                    message = getResources().getString(R.string.status_invalid);
                }

                Intent i = new Intent(MainActivity.this, MessageView.class);
                i.putExtra("key1", message);
                startActivity(i);

            }
        });

    }
}