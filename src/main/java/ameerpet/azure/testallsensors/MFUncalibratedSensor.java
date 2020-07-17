package ameerpet.azure.testallsensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MFUncalibratedSensor extends AppCompatActivity {

    Sensor s;
    SensorEventListener sel;
    SensorManager sm;
    TextView stv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mfuncalibrated_sensor);

        stv=findViewById(R.id.stv);

        tv=findViewById(R.id.tv);
        tv.setText("Magnetic Field Uncalibrated Sensor");


        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED);
        if(s==null)
        {
            stv.setText("Open window and throw outside ur phone");
        }
        else
        {
            sel=new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {

                    stv.setText("Along X axis--> "+event.values[0]+" micro-tesla "+"\n Along Y axis--> "+event.values[1]+" micro-tesla"+"\n Along Z axis--> "+event.values[2]+" micro-tesla");
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };

            sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);

        }


    }
}
