package ameerpet.azure.testallsensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LinearAccelerationSensor extends AppCompatActivity {

    Sensor s;
    SensorEventListener sel;
    SensorManager sm;
    TextView stv;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_acceleration_sensor);

        stv=findViewById(R.id.stv);
        tv=findViewById(R.id.tv);
        tv.setText("Linear Acceleration Sensor");
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        if(s==null)
        {
            stv.setText("Open window and throw outside ur phone");
        }
        else
        {
            sel=new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {

                    stv.setText("Along X axis--> "+event.values[0]+" m/sec^2 "+"\n Along Y axis--> "+event.values[1]+" m/sec^2"+"\n Along Z axis--> "+event.values[2]+" m/sec^2");

                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };

            sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);

        }



    }
}
