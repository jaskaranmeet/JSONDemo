package com.example.hp.jsondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hp on 12-Apr-17.
 */


public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Employee> employeeArrayList;
    private LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<Employee> singleRowArrayList) {
        this.context = context;
        this.employeeArrayList = singleRowArrayList;
    }

    @Override
    public int getCount() {
        return employeeArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_employee, parent, false);

        //find all views of employee.xml
        TextView txtname = (TextView) convertView.findViewById(R.id.txtname);
        TextView txtid = (TextView) convertView.findViewById(R.id.txtid);
        TextView txtsalary = (TextView) convertView.findViewById(R.id.txtsalary);

        //getting data from adapter

        Employee employee = employeeArrayList.get(position);
        String name = employee.getName();
        int id = employee.getId();
        int salary = employee.getSalary();

        //setting data
        txtname.setText(name);
        txtid.setText(String.valueOf(id));
        txtsalary.setText(String.valueOf(salary));
        return convertView;
    }
}


