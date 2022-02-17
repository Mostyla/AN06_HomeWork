package com.example.home24

import android.os.Bundle
import android.view.animation.AnimationUtils.loadAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.home24.R.anim.*
import com.example.home24.databinding.ActivityRandomBinding
import java.util.*

class RandomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRandomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRandomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        conclusion()

        binding.BtnBack.setOnClickListener {
            finish()
        }
    }

    var i = 0
    private val animAlpha by lazy { loadAnimation(this, myalpha) }
    private val animScale by lazy { loadAnimation(this, myscale) }
    private val animTrans by lazy { loadAnimation(this, mytranslation) }
    private val anims by lazy { arrayOf(animAlpha, animScale, animTrans) }

    private fun conclusion() {

        binding.BtnSelect.setOnClickListener {
            when (Random().nextInt(12)) {
                0 -> binding.image.setImageResource(R.drawable.stud_1)
                1 -> binding.image.setImageResource(R.drawable.stud_2)
                2 -> binding.image.setImageResource(R.drawable.stud_3)
                3 -> binding.image.setImageResource(R.drawable.stud_4)
                4 -> binding.image.setImageResource(R.drawable.stud_5)
                5 -> binding.image.setImageResource(R.drawable.stud_6)
                6 -> binding.image.setImageResource(R.drawable.stud_7)
                7 -> binding.image.setImageResource(R.drawable.stud_8)
                8 -> binding.image.setImageResource(R.drawable.stud_9)
                9 -> binding.image.setImageResource(R.drawable.stud_10)
                10 -> binding.image.setImageResource(R.drawable.stud_11)
                11 -> binding.image.setImageResource(R.drawable.stud_12)
            }

            binding.image.startAnimation(anims[i % anims.size])

            val selectedStudents = SingletonStudentsArray.students.filter { it.isSelected }

            binding.StdName.text = selectedStudents[Random().nextInt(selectedStudents.size)].name
            binding.StdName.startAnimation(anims[i % anims.size])
            i++

        }

    }
}
