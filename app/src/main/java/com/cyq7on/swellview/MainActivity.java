package com.cyq7on.swellview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Runnable {

    private SwellView swellView;
    private int percent = 0;
    private static final int delayTime = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                percent = 0;
                swellView.reset();
            }
        });*/

        swellView = (SwellView) findViewById(R.id.swellView);
        swellView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swellView.setSubtitleText("开始");
                swellView.postDelayed(MainActivity.this, delayTime);
            }
        });
    }

    @Override
    public void run() {
        if (percent <= 100) {
            swellView.setTitleText(percent++ + "%");
            swellView.swell(0.01f,0.01f,delayTime);
            swellView.postDelayed(MainActivity.this, delayTime);
        }
    }
}
