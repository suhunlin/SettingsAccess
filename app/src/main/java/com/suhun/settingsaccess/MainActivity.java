package com.suhun.settingsaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private TextView fieldName;
    private ListView showContentValues;
    private Button getFieldName, getContentValues;
    private SimpleAdapter simpleAdapter;
    private ArrayList<HashMap<String, String>> data = new ArrayList<>();
    private String[] from = {"layout_item"};
    private int[] to = {R.id.content_item};
    private ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListView();
        contentResolver = getContentResolver();
    }

    private void initView(){
        fieldName = findViewById(R.id.lid_fieldName);
        getFieldName = findViewById(R.id.lid_getFieldName);
        getContentValues = findViewById(R.id.lid_getSetingContent);
        getFieldName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFieldNameFun();
            }
        });

        getContentValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    private void initListView() {
        showContentValues = findViewById(R.id.lid_contentValues);
        simpleAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);
        showContentValues.setAdapter(simpleAdapter);
    }

    private void getFieldNameFun(){
        StringBuffer stringBuffer = new StringBuffer();
        Uri uri = Settings.System.CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        for(int i=0;i<cursor.getColumnCount();i++){
            stringBuffer.append(cursor.getColumnName(i)+"\n");
        }
        fieldName.setText(stringBuffer);
    }
}