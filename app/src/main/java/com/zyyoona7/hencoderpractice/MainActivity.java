package com.zyyoona7.hencoderpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zyyoona7.hencoderpractice.draw1.Draw1Activity;
import com.zyyoona7.hencoderpractice.draw2.Draw2Activity;
import com.zyyoona7.hencoderpractice.draw3.Draw3Activity;
import com.zyyoona7.hencoderpractice.draw4.Draw4Activity;

public class MainActivity extends AppCompatActivity {

    private Button mDraw1Btn;
    private Button mDraw2Btn;
    private Button mDraw3Btn;
    private Button mDraw4Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvent();
    }

    private void initViews() {
        mDraw1Btn = (Button) findViewById(R.id.btn_draw1);
        mDraw2Btn = (Button) findViewById(R.id.btn_draw2);
        mDraw3Btn = (Button) findViewById(R.id.btn_draw3);
        mDraw4Btn = (Button) findViewById(R.id.btn_draw4);
    }

    private void initEvent() {
        mDraw1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(Draw1Activity.class);
            }
        });

        mDraw2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(Draw2Activity.class);
            }
        });

        mDraw3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(Draw3Activity.class);
            }
        });

        mDraw4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(Draw4Activity.class);
            }
        });
    }

    private void goTo(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
