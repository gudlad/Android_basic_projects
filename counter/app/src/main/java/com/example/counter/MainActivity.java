package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Button btnstart,btnstop;
    TextView textcount;
    int i=1;
    Handler newhandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {  super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart = findViewById(R.id.buttonstart); btnstop = findViewById(R.id.buttonstop);
        textcount = findViewById(R.id.txtcount);
        btnstart.setOnClickListener(new View.OnClickListener() {  @Override
        public void onClick(View v) {
            newhandler.postDelayed(upTimerthread,0);  }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {  @Override
        public void onClick(View v) {
            newhandler.removeCallbacks(upTimerthread);  }
        });
    }
    private Runnable upTimerthread = new Runnable() {  @Override
    public void run() {
        textcount.setText(""+i);  newhandler.postDelayed(this,1000);  i++;
    }
    };
}
