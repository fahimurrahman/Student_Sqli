package com.hod.fahim.student_sqli.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hod.fahim.student_sqli.R;
import com.hod.fahim.student_sqli.model.Student;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student>{

    ArrayList<Student> data;
    Context context;

    public StudentAdapter(ArrayList<Student> data, Context context) {
        super(context, R.layout.row_student, data);
        this.data = data;
        this.context = context;
    }

    public static class ViewHolder{
        TextView tvName;
        TextView tvEmail;
        TextView tvPhone;
        TextView tvAddress;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Student student = getItem(position);
        ViewHolder holder;
        final View result;

        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_student,parent,false);

            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvEmail = convertView.findViewById(R.id.tvEmail);
            holder.tvPhone = convertView.findViewById(R.id.tvPhone);
            holder.tvAddress = convertView.findViewById(R.id.tvAddress);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tvName.setText(String.valueOf(student.getStudentName()));
        holder.tvPhone.setText(student.getStudentPhone());
        holder.tvEmail.setText(student.getStudentEmail());
        holder.tvAddress.setText(student.getStudentAddress());
        return convertView;
    }
}
