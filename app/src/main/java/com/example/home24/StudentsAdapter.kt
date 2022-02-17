package com.example.home24

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.home24.StudentsAdapter.StudentsViewHolder
import com.example.home24.databinding.ItemStudentBinding

class StudentsAdapter() :
    RecyclerView.Adapter<StudentsViewHolder>() {

     var students: List<Student> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    inner class StudentsViewHolder(itemStudentBinding: ItemStudentBinding) :
        RecyclerView.ViewHolder(itemStudentBinding.root) {
        private val checkBox = itemStudentBinding.checkBox

        fun bind(position: Int) {
            val student = students[position]

            checkBox.text = student.name
            checkBox.isSelected = student.isSelected

            checkBox.setOnCheckedChangeListener { _, isChecked ->
                    student.isSelected = isChecked
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return students.size
    }
}