package me.hsanchez.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nameInput = (EditText) findViewById(R.id.nameInput);
        Button greetButton = (Button) findViewById(R.id.greetBtn);
        Button exitButton = (Button) findViewById(R.id.exitBtn);

        greetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String name = nameInput.getText().toString();
                bundle.putString("name", name);

                Intent intent = new Intent(MainActivity.this, GreetingScreen.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
