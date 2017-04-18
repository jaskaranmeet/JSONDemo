package com.example.hp.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    private ListView lv;
    MyAdapter myAdapter;

    private ArrayList<Employee> lst;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv= (ListView) findViewById(R.id.lv);

        lst=new ArrayList<>();
        lst=getIntent().getParcelableArrayListExtra("key");


        myAdapter=new MyAdapter(List.this,lst);
        lv.setAdapter(myAdapter);
    }
}
