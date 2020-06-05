package me.hsanchez.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GreetingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting_screen);
        EditText resultInput = (EditText) findViewById(R.id.resultInput);
        Button backBtn = (Button) findViewById(R.id.greetingBackBtn);

        String name = getIntent().getExtras().getString("name");
        resultInput.setText(name);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GreetingScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
