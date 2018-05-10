package kr.or.dgit.it.chapter13_14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Mission2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission2);
        setTitle(getIntent().getStringExtra("title"));


    }
}
