package com.zyyoona7.hencoderpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zyyoona7.hencoderpractice.draw1.Draw1Activity;

public class MainActivity extends AppCompatActivity {

    private Button mDraw1Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvent();
    }

    private void initViews() {
        mDraw1Btn = (Button) findViewById(R.id.btn_draw1);
    }

    private void initEvent() {
        mDraw1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(Draw1Activity.class);
            }
        });
    }

    private void goTo(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
