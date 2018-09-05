package com.hod.fahim.student_sqli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hod.fahim.student_sqli.Db.DBHelper;
import com.hod.fahim.student_sqli.model.Student;

public class MainActivity extends AppCompatActivity {

    EditText etName,etAddress,etEmail,etPhone;
    //String name,email,phone,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
    }

    private boolean validataUI(){
        if (etName.getText().toString().length() == 0){
            etName.setError("Please enter student name");
            return false;
        }
        if (etAddress.getText().toString().length() == 0){
            etAddress.setError("Please enter student Address");
            return false;
        }
        if (etEmail.getText().toString().length() == 0){
            etEmail.setError("Please enter student Email");
            return false;
        }
        if (etPhone.getText().toString().length() == 0){
            etPhone.setError("Please enter student Phone");
            return false;
        }
        return true;
    }

    public void Insert(View view){

        if (validataUI()){

            DBHelper dbHelper = new DBHelper(this);
            Student student = new Student();

            student.setStudentName(etName.getText().toString());
            student.setStudentAddress(etAddress.getText().toString());
            student.setStudentPhone(etPhone.getText().toString());
            student.setStudentEmail(etEmail.getText().toString());

            if (dbHelper.addStudent(student)>0){
                Toast.makeText(this, "Successfully Inserted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,StudentList.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Insertion Failed.Please try again!", Toast.LENGTH_SHORT).show();
            }
        }



    }
}
