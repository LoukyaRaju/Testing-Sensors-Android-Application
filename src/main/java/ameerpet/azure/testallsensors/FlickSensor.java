package ameerpet.azure.testallsensors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FlickSensor extends AppCompatActivity {

    TextView stv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flick_sensor);

        stv=findViewById(R.id.stv);
        tv=findViewById(R.id.tv);
        tv.setText("Flick Sensor");
        stv.setText("Sorry .. Can't test this sensor !!");
    }
}
