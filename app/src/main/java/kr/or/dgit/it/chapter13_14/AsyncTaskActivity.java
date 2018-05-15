package kr.or.dgit.it.chapter13_14;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskActivity extends AppCompatActivity {
    private TextView tv;
    private AsyncTask asyncTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_message);
        setTitle(getIntent().getStringExtra("title"));

        tv = findViewById(R.id.main_textView);


        asyncTask = new MyAsyncTask();


    }


    public void btnStart(View view) {
        asyncTask.execute(5);
    }

    public void btnPause(View view) {

    }

    class MyAsyncTask extends AsyncTask<Void, Integer, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           Toast.makeText(AsyncTaskActivity.this, "onPreExecute", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(Void... voids) {

            for(int i=0; i<5; i++){
                publishProgress(i);
            }

            return "Finish!!";
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv.setText("aa" + values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(AsyncTaskActivity.this, "onPostExecute() -> " + s, Toast.LENGTH_SHORT).show();
            super.onPostExecute(s);
            tv.setText(s);
        }
    }
}
