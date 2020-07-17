package ameerpet.azure.testallsensors;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    List<Sensor> ls;
   SensorManager sm;
 //   SensorEventListener sel;
    ArrayList<String> name;
    TextView stv;
 //   Sensor s;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stv=findViewById(R.id.stv);
        lv=findViewById(R.id.sensorlist);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        ls=sm.getSensorList(Sensor.TYPE_ALL);

        name=new ArrayList<>();

        Toast.makeText(this, ""+ls.size(), Toast.LENGTH_SHORT).show();

        for (int i=0;i<ls.size();i++)
        {
            name.add(ls.get(i).getName().toString());

        }

        ArrayAdapter ad=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,name);
        lv.setAdapter(ad);

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               if (i == 0)
               {
                   Intent k=new Intent(MainActivity.this,TypeLight.class);
                   startActivity(k);
               }
               else if (i==1)
               {

                   Intent k=new Intent(MainActivity.this,ProximitySensor.class);
                   startActivity(k);
               }
               else if (i==2)
               {

                   Intent k=new Intent(MainActivity.this,DoubleTapSensor.class);
                   startActivity(k);
               }
               else if (i==3)
               {

                   Intent k=new Intent(MainActivity.this,FlickSensor.class);
                   startActivity(k);
               }
               else if (i==4)
               {
                   Intent k=new Intent(MainActivity.this,TerminalSensor.class);
                   startActivity(k);

               }
               else if (i==5)
               {

                   Intent k=new Intent(MainActivity.this,AccelerationSensor.class);
                   startActivity(k);
               }
               else if (i==6)
               {

                   Intent k=new Intent(MainActivity.this,MagneticFieldSensor.class);
                   startActivity(k);
               }
               else if (i==7)
               {
                   Intent k=new Intent(MainActivity.this,OrientationSensor.class);
                   startActivity(k);

               }
               else if (i==8)
               {

                   Intent k=new Intent(MainActivity.this,GravitySensor.class);
                   startActivity(k);
               }
               else if (i==9)
               {

                   Intent k=new Intent(MainActivity.this,LinearAccelerationSensor.class);
                   startActivity(k);
               }
               else if (i==10)
               {

                   Intent k=new Intent(MainActivity.this,RotationVectorSensor.class);
                   startActivity(k);
               }
               else if (i==11)
               {

                   Intent k=new Intent(MainActivity.this,MFUncalibratedSensor.class);
                   startActivity(k);
               }
               else
               {
                   Intent k=new Intent(MainActivity.this,GeomagneticRVSensor.class);
                   startActivity(k);

               }



            }
        });


    }
}
