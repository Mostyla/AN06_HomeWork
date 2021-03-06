package com.example.home24

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.home24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var students: ArrayList<Student> = ArrayList()
    private val selectedStudents: ArrayList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerWithData()
        onBtnClick()
        setUpRecyclerView(students)
    }

    private fun onBtnClick() {
        binding.btnOK.setOnClickListener {
            students.forEach {
                if (it.isSelected)
                    selectedStudents.add(it)
            }
            if (selectedStudents.size <= 0) {
                Toast.makeText(applicationContext, "Please, select the students", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this@MainActivity, RandomActivity::class.java)
            intent.putParcelableArrayListExtra("selectedStudents", selectedStudents)
            startActivity(intent)
        }

        binding.btnDlt.setOnClickListener {
            deleteStudent()
            binding.recyclerStudents.adapter = StudentsAdapter(students)
        }

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddNewStudentActivity::class.java)
            intent.putParcelableArrayListExtra("students", students)
            startActivity(intent)
        }
    }

    private fun deleteStudent() {
        for (i in students.indices.reversed())
            if (students[i].isSelected)
                students.remove(students[i])
    }

    private fun setUpRecyclerView(students: ArrayList<Student>) {
        binding.recyclerStudents.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerStudents.adapter = StudentsAdapter(students)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        if (binding.recyclerStudents.adapter != null)
            binding.recyclerStudents.adapter!!.notifyDataSetChanged()
    }

    private fun setUpRecyclerWithData() {
        fillArray()
        if (intent.getParcelableArrayListExtra<Student>("students") != null) {
            students = intent.getParcelableArrayListExtra("students")!!
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fillArray() {
        students.add(Student("Egor", false))
        students.add(Student("Mary", false))
        students.add(Student("Nastya", false))
        students.add(Student("Natasha", false))
        students.add(Student("Stas", false))
        students.add(Student("Dasha", false))
        students.add(Student("Anna", false))
        students.add(Student("Nadya", false))
        students.add(Student("Anton", false))
        students.add(Student("Alexander", false))
        students.add(Student("Dima", false))
        students.add(Student("Alex", false))
        students.add(Student("Alla", false))
        students.add(Student("Andrey", false))
    }
}