package com.example.android.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MessageView extends AppCompatActivity {

    Button guessAgainButton;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        if(getIntent().hasExtra("key1")){
            message = (TextView)findViewById(R.id.textView);
            String text = getIntent().getExtras().getString("key1");
            message.setText(text);
        }

        guessAgainButton = (Button) findViewById(R.id.btnGuessAgain);
        guessAgainButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MessageView.this , MainActivity.class));
            }
        });


    }
}
