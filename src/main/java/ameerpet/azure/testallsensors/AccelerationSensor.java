package ameerpet.azure.testallsensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerationSensor extends AppCompatActivity {


    Sensor s;
    SensorEventListener sel;
    SensorManager sm;
    TextView stv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceleration_sensor);


        stv=findViewById(R.id.stv);

        tv=findViewById(R.id.tv);
        tv.setText("Accelerometer Sensor");


        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(s==null)
        {
            stv.setText("Open window and throw outside ur phone");
        }
        else
        {
            sel=new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {

                    stv.setText("X = "+event.values[0]+" m/sec^2"+"\n Y = "+event.values[1]+" m/sec^2"+"\n Z = "+event.values[2]+" m/sec^2");

                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };

            sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);

        }

    }
}
