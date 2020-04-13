package com.example.diceapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var diceimage:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dicebtn:Button=findViewById(R.id.btn_roll)
        dicebtn.text="Lets Roll On"
        dicebtn.setOnClickListener {
            dicefun()
        }

        diceimage=findViewById(R.id.img_dice)



    }

    private fun dicefun() {
        val result= java.util.Random().nextInt(6) + 1

        val images=when(result)
        {
            1->R.drawable.dice_1;
            2->R.drawable.dice_2;
            3->R.drawable.dice_3;
            4->R.drawable.dice_4;
            5->R.drawable.dice_5;
            else -> R.drawable.dice_6
        }
        diceimage.setImageResource(images)


    }
}
