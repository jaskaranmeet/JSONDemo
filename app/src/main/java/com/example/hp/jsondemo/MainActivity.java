package com.example.hp.jsondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCreateJSON, btnParseJSON, btnShowJSON;
    private TextView txtShowJSON;



    private String jsonString;
    private StringBuffer buffer;

    //list view decalaration
    private Employee employee;
    private ArrayList<Employee> employeeArrayList;

    String name;
    int id,salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeArrayList = new ArrayList<Employee>();

        btnCreateJSON = (Button) findViewById(R.id.btnCreateJSON);
        btnParseJSON = (Button) findViewById(R.id.btnParseJSON);
        btnShowJSON = (Button) findViewById(R.id.btnShowJSON);
        txtShowJSON = (TextView) findViewById(R.id.txtShowJSON);

        btnParseJSON.setOnClickListener(this);
        btnCreateJSON.setOnClickListener(this);
        btnShowJSON.setOnClickListener(this);

        buffer=new StringBuffer();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreateJSON:


                try {
                    //create first object
                    JSONObject object1 = new JSONObject();
                    object1.put("id", 101);
                    object1.put("name", "jaskaran");
                    object1.put("salary", 50000);

                    //create second object
                    JSONObject object2 = new JSONObject();
                    object2.put("id", 102);
                    object2.put("name", "jaskaranmeet");
                    object2.put("salary", 60000);

                    JSONObject object3 = new JSONObject();
                    object2.put("id", 103);
                    object2.put("name", "oshin");
                    object2.put("salary", 25000);

                    JSONObject object4 = new JSONObject();
                    object2.put("id", 104);
                    object2.put("name", "Hemant");
                    object2.put("salary",20000);


                    //creating array of two objects
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.put(object1);
                    jsonArray.put(object2);
                    jsonArray.put(object3);
                    jsonArray.put(object4);

                    //creating outer object
                    JSONObject employee = new JSONObject();
                    employee.put("Employee", jsonArray);

                    jsonString = employee.toString();
                    txtShowJSON.setText(jsonString);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnParseJSON:
                try {
                    JSONObject object = new JSONObject(jsonString);
                    JSONArray jsonArray = object.getJSONArray("Employee");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object1 = (JSONObject) jsonArray.get(i);

                         name = object1.getString("name");
                         id = object1.getInt("id");
                        salary = object1.getInt("salary");



                        buffer.append(id+" "+name+" "+salary+"\n");


                        employee = new Employee(name, id, salary);
                        employeeArrayList.add(employee);

                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }Toast.makeText(MainActivity.this,buffer.toString(),Toast.LENGTH_LONG).show();
                break;

           case R.id.btnShowJSON:



                Intent intent = new Intent(MainActivity.this, List.class);
                intent.putParcelableArrayListExtra("key", employeeArrayList);
                startActivity(intent);
                break;
        }

    }
}
