package kr.or.dgit.it.chapter13_14;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class RunningActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> datas;


    Button detailBtn;
    Button dialogBtn;

    private static final String TAG = "RunningActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);
        setTitle(getIntent().getStringExtra("title"));

        listView.findViewById(R.id.listView);

        detailBtn = findViewById(R.id.btn1);
        dialogBtn = findViewById(R.id.btn2);


        datas=new ArrayList<>();

        datas.add("onCreate....");

        Log.d(TAG, "onCreate : ");


    }

    @Override
    protected void onStart() {
        datas.add("onStart....");
        super.onStart();

    }

    @Override
    protected void onResume() {
        datas.add("onResume....");
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
