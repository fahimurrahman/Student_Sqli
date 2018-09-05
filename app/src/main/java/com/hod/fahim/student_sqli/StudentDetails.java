package com.hod.fahim.student_sqli;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hod.fahim.student_sqli.Db.DBHelper;
import com.hod.fahim.student_sqli.model.Student;

public class StudentDetails extends AppCompatActivity {
    EditText etName,etAddress,etEmail,etPhone;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);

        student = (Student)getIntent().getSerializableExtra("EDIT_STUDENT");

        if (student!=null){
            etName.setText(student.getStudentName());
            etAddress.setText(student.getStudentAddress());
            etEmail.setText(student.getStudentEmail());
            etPhone.setText(student.getStudentPhone());
        }
    }
    private boolean validateUI(){
        if(etName.getText().toString().length() == 0 ){
            etName.setError("Please enter student name!" );
            return false;
        }
        if(etAddress.getText().toString().length() == 0 ){
            etAddress.setError("Please enter address!" );
            return false;
        }
        if(etEmail.getText().toString().length() == 0 ){
            etEmail.setError("Please enter email!" );
            return false;
        }
        if(etPhone.getText().toString().length() == 0 ){
            etPhone.setError("Please enter phone!" );
            return false;
        }
        return true;
    }

    public void Edit (View view){
        if (validateUI()){
            if (student!=null){
                final DBHelper dbHelper = new DBHelper(this);
                AlertDialog.Builder altdial= new AlertDialog.Builder(this);
                altdial.setMessage("Do you want to update this student?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        student.setStudentEmail(etEmail.getText().toString());
                        student.setStudentName(etName.getText().toString());
                        student.setStudentPhone(etPhone.getText().toString());
                        student.setStudentAddress(etAddress.getText().toString());

                        if (dbHelper.updateStudent(student)>0){
                            Toast.makeText(getApplicationContext(),"Successfully updated",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),StudentList.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Failed,try again",Toast.LENGTH_LONG).show();
                        }
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alter = altdial.create();
                alter.setTitle(student.getStudentName());
                alter.show();
            }else {
                Toast.makeText(this,"Select student first",Toast.LENGTH_LONG).show();
            }
        }
    }
}
