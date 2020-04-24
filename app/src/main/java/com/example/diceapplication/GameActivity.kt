package com.example.diceapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.diceapplication.databinding.ActivityGameBinding
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var drawerlayout:DrawerLayout
    private lateinit var appconfig:AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_game)
        drawerlayout=binding.drawerLayout
        val navController=this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerlayout)
        appconfig = AppBarConfiguration(navController.graph, drawerlayout)
        NavigationUI.setupWithNavController(binding.navView, navController)


        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val nvcontroller=this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(nvcontroller,drawerlayout)
    }
}
