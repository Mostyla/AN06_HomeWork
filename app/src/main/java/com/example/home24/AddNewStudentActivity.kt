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
        back()
    }

    private fun addNewStudent() {


        binding.btnAddStd.setOnClickListener {

            val newStudent = binding.etName.text.toString()
            if(newStudent.isNotEmpty()) {
                SingletonStudentsArray.addNewStudent(Student(newStudent,false))
                finish()
            } else {
                Toast.makeText(applicationContext,"Please enter the new student name!",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun back() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val KEY = "students"
    }
}

private fun <E> ArrayList<E>.add(element: String) {

}

