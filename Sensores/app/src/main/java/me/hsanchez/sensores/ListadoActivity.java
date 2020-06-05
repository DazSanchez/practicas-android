 package me.hsanchez.sensores;

import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListadoActivity extends ListActivity {

    private List<String> sensors;

    private List<Sensor> availableSensors;

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        this.availableSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        this.sensors = new ArrayList<>(availableSensors.size());

        for (Sensor sensor : availableSensors) {
            sensors.add(sensor.getName());
        }

        setListAdapter(new ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1, this.sensors
        ));
    }
}
