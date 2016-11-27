package com.example.changyuan.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class piano extends AppCompatActivity {
private  String []names=new  String[]{"钢琴","打地鼠"};
    private int []imageIds=new int[]{R.drawable.piano,R.drawable.shu};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fg2);
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <= names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", imageIds[i]);
            listItem.put("personName", names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"personName","header"},new int[]{R.id.name,R.id.header});
        ListView list=(ListView)findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
    }
}
