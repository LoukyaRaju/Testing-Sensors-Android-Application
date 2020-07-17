package ameerpet.azure.testallsensors;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TerminalSensor extends AppCompatActivity {


    TextView stv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminal_sensor);

        stv=findViewById(R.id.stv);
        tv=findViewById(R.id.tv);
        tv.setText("Terminal Sensor");
        stv.setText("Sorry .. Can't test this sensor !!");

    }
}
