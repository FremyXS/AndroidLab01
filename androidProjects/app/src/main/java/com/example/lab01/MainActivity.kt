package com.example.lab01

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.lab01.databinding.ActivityMainBinding
import com.example.lab01.view.activity.ContainerFragment
import com.example.lab01.view.activity.DeployedProductFragment


class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)
    }

    override fun onStart() {
        super.onStart()
    }

    fun onClick(view: View){
        navController.navigate(R.id.action_containerFragment_to_deployedProductFragment, null)

    }
}