package kr.or.dgit.it.chapter13_14;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HandlerMessageActivity extends AppCompatActivity {
    private TextView tv;
    private boolean looFlag;
    private boolean isRun;
    private MyThread thread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_message);
        setTitle(getIntent().getStringExtra("title"));

        tv = findViewById(R.id.main_textView);
        looFlag = true;

        thread = new MyThread();

        
    }

    public void btnStart(View view) {
        isRun = true;
        thread.start();
    }

    public void btnPause(View view) {
        isRun = false;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what ==1){
                tv.setText(String.valueOf(msg.arg1));
            }else if(msg.what == 2){
                tv.setText((String) msg.obj);
            }
        }
    };
    
    class MyThread extends Thread {
        public void run(){           
                int count=10;
                Message msg;
                
                while (looFlag){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(isRun){
                        count--;
                        if(count == 0){
                            msg = Message.obtain(handler, 2, "Finish!!");
                            looFlag = false;
                        }else{
                            msg = Message.obtain(handler, 1);
                            msg.arg1 = count;
                        }
                     handler.sendMessage(msg);
                 }
                
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
