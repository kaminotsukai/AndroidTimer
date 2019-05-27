package sample.com.timer;

import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import static android.os.SystemClock.*;

public class MainActivity extends AppCompatActivity {

//    private Chronometer chronometer;

    private Chronometer chronometer;
    private long stopOffSet;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ((Chronometer)findViewById(R.id.c)).start();
        chronometer = findViewById(R.id.c);


    }

    public void onStart(View view) {
       if(!running){
           //SystemClock.elapsedRealtime()。stop時間も込みの時間を表示(elapsed＝経過)
           chronometer.setBase(SystemClock.elapsedRealtime() - stopOffSet);
//           chronometer.start();
           running = true;
       }
        chronometer.start();
    }

    public void onStop(View view) {
        if(running){
            chronometer.stop();
            stopOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void onReset(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        stopOffSet = 0;


    }
}
