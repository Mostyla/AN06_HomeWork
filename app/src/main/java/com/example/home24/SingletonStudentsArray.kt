package com.example.home24

import androidx.lifecycle.MutableLiveData
import com.example.home24.SingletonStudentsArray.students

object SingletonStudentsArray {
     private val _students = ArrayList<Student>()

     val students: List<Student>
     get() {
          return _students
     }


     private fun fillArray() {
          _students.add(Student("Egor", false))
          _students.add(Student("Mary", false))
          _students.add(Student("Nastya", false))
          _students.add(Student("Natasha", false))
          _students.add(Student("Stas", false))
          _students.add(Student("Dasha", false))
          _students.add(Student("Anna", false))
          _students.add(Student("Nadya", false))
          _students.add(Student("Anton", false))
          _students.add(Student("Alexander", false))
          _students.add(Student("Dima", false))
          _students.add(Student("Alex", false))
          _students.add(Student("Alla", false))
          _students.add(Student("Andrey", false))
     }

     fun addNewStudent(newStudent: Student){
          _students.add(newStudent)
     }

     fun remove(removeStudent: Student){
          _students.remove(removeStudent)
     }

     init {
         fillArray()
     }

}
