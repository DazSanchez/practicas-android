package me.hsanchez.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView heading = (TextView) findViewById(R.id.headingLabel);
        Button listBtn = (Button) findViewById(R.id.listBtn);
        Button accelerometerBtn = (Button) findViewById(R.id.acceletometerBtn);
        Button exitBtn = (Button) findViewById(R.id.exitBtn);

        String fontPath = "fonts/BRLNSR.TTF";
        Typeface font = Typeface.createFromAsset(getAssets(), fontPath);
        heading.setTypeface(font);
        listBtn.setTypeface(font); 
        accelerometerBtn.setTypeface(font);
        exitBtn.setTypeface(font);

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
                startActivity(intent);
            }
        });

        accelerometerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AcelerometerActivity.class);
            startActivity(intent);
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
