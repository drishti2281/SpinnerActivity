package com.example.spinneractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.spinneractivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.navController)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment, R.id.secondFragment))
        setupActionBarWithNavController(navController, appBarConfiguration )
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menuHome-> navController.navigate(R.id.firstFragment)
                R.id.menuProfile-> navController.navigate(R.id.secondFragment)
            }
            return@setOnItemSelectedListener true
        }

        navController.addOnDestinationChangedListener{_,destination,_->
            when(destination.id){
                R.id.firstFragment -> binding.bottomNavigation.menu.getItem(0).isChecked = true
                R.id.secondFragment -> binding.bottomNavigation.menu.getItem(1).isChecked = true
            }
        }
    }

    override fun onNavigateUp(): Boolean {
        return super.onNavigateUp() || navController.popBackStack()
    }
}
