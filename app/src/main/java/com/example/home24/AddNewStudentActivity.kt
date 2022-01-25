package com.example.home24

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.home24.databinding.ActivityAddNewStudentBinding

class AddNewStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addNewStudent()
    }

    private fun addNewStudent() {

        val students: ArrayList<Student> = intent.getParcelableArrayListExtra("students")!!

        binding.btnAddStd.setOnClickListener {

            val newStudent = binding.etName.text.toString()
            students.add(Student(newStudent, false))
            val intent = Intent(this@AddNewStudentActivity, MainActivity::class.java)
            intent.putParcelableArrayListExtra("students", students)

            if(newStudent.isNotEmpty()) {
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext,"Please enter the new student name!",Toast.LENGTH_SHORT).show()
            }

            binding.btnBack.setOnClickListener {
                finish()
            }
        }
    }
}

