package com.example.home24

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.home24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var myStdApapter = StudentsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBtnClick()
        setUpRecyclerView(SingletonStudentsArray.students)
    }

    override fun onResume() {
        super.onResume()
        myStdApapter.students = SingletonStudentsArray.students
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun onBtnClick() {

        binding.btnOK.setOnClickListener {
            val intent = Intent(this@MainActivity, RandomActivity::class.java)
            startActivity(intent)
        }


        binding.btnDlt.setOnClickListener {
            deleteStudent()
            myStdApapter.students = SingletonStudentsArray.students
        }

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddNewStudentActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun deleteStudent() {

        for (i in SingletonStudentsArray.students.indices.reversed())
            if (SingletonStudentsArray.students[i].isSelected)
                SingletonStudentsArray.remove(SingletonStudentsArray.students[i])

    }

    private fun setUpRecyclerView(students: List<Student>) {
        binding.recyclerStudents.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerStudents.adapter = myStdApapter
        myStdApapter.students = students
    }

}