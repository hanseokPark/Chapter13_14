package kr.or.dgit.it.chapter13_14;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import kr.or.dgit.it.chapter13_14.Call.CallLogAdapter;
import kr.or.dgit.it.chapter13_14.Call.CallLogVO;
import kr.or.dgit.it.chapter13_14.Database.DBHelper;

public class Mission1 extends AppCompatActivity {
    boolean callPermission;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission1);
        setTitle(getIntent().getStringExtra("title"));

        /*//원본
        ArrayList<Map<String, String>> cursorDatas = new ArrayList<>();
        dbHelper = DBHelper.getInstance(this);
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(tbl_name, new String[]{"_id","eng", "han"}, null,null,null,null,null);

        while (cursor.moveToNext()){
            HashMap<String, String> data = new HashMap<>();
            data.put("eng",cursor.getString(0));
            data.put("han", cursor.getString(1));
            cursorDatas.add(data);
        }
        //CursorAdapter
        CursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_activated_2,
                cursor,
                new String[]{"eng","han"},
                new int[]{android.R.id.text1, android.R.id.text2},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        //ListView
        ListView cursorListView = findViewById(R.id.listview_cursor);
        cursorListView.setAdapter(cursorAdapter);*/

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
            callPermission = true;
        }

        if(!callPermission){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},200);
        }

        ListView listView = findViewById(R.id.mission_main_list);
        ArrayList<CallLogVO> datas = new ArrayList<>();

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select name, photo, date, phone from tb_calllog",null);
        while(cursor.moveToNext()){
            CallLogVO vo = new CallLogVO();
            vo.name=cursor.getString(0);
            vo.photo=cursor.getString(1);
            vo.date=cursor.getString(2);
            vo.phone=cursor.getString(3);
            datas.add(vo);

        }
        db.close();
        CallLogAdapter adapter = new CallLogAdapter(this, R.layout.mission_list_item, datas);
        listView.setAdapter(adapter);

    }





    }

