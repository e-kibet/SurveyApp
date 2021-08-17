package com.kosgei.survey.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kosgei.survey.R
import androidx.databinding.DataBindingUtil
import com.kosgei.survey.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)

        val toolbar = binding.mainToolbar
        setSupportActionBar(toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        binding.navigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{_, destination, _->{
            run{
                when(destination.id){
                    R.id.questionsFragment->{
                        supportActionBar?.setDisplayHomeAsUpEnabled(false)
                        binding.mainToolbar.title = "Questions"
                    }
                    else->{
                        supportActionBar?.setDisplayHomeAsUpEnabled(true)
                        binding.mainToolbar.title = "Start the Survey"
                    }
                }
            }
        }
        }


    }


}