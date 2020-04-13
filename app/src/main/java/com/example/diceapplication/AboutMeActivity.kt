package com.example.diceapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.diceapplication.databinding.ActivityAboutMeBinding



class AboutMeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutMeBinding
    private val myName: myname = myname("Aleks Haecky")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_about_me)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_about_me)
        //findViewById<Button>(R.id.done_button).setOnClickListener {
            //addnickname(it)
        //}
        binding.myName=myName

        binding.doneButton.setOnClickListener {
            addnickname(it)
        }
    }

    private fun addnickname(view:View) {
        binding.apply {
            myName?.nickname = nickname.text.toString()
            binding.invalidateAll()
            binding.nickname.visibility=View.GONE
            binding.doneButton.visibility=View.GONE
            binding.textNick.visibility=View.VISIBLE

        }
        //val editText=findViewById<EditText>(R.id.nickname);
        //val nicktext=findViewByd<TextView>(R.id.text_nick)




        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }
}
