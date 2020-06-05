package me.hsanchez.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AcelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private EditText ax, ay, az;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometer);

        ax = (EditText) findViewById(R.id.axEdit);
        ay = (EditText) findViewById(R.id.ayEdit);
        az = (EditText) findViewById(R.id.azEdit);
        Button exitBtn = (Button) findViewById(R.id.aclExitBtn);

        exitBtn.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if(!sensorList.isEmpty()) {
            sensorManager.registerListener(this, sensorList.get(0), SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    protected void onPause() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        ax.setText(String.valueOf(event.values[0]));
        ay.setText(String.valueOf(event.values[1]));
        az.setText(String.valueOf(event.values[2]));
    }
}
