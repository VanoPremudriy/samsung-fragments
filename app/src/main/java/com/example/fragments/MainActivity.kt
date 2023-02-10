package com.example.fragments

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.findFragment
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var  fragmentManager: FragmentManager
    private lateinit var fragment1: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.show()
        supportActionBar?.title = "Fragments"

        fragmentManager = supportFragmentManager

        binding = ActivityMainBinding.inflate(layoutInflater)

        fragmentManager.beginTransaction().add(R.id.fragment1, RedFragment()).commit()
        fragmentManager.beginTransaction().add(R.id.fragment2, BlueFragment()).commit()


        binding.caption.setOnClickListener {
            fragment1 = fragmentManager.findFragmentById(R.id.fragment1)!!

            if (fragment1.javaClass == RedFragment::class.java){
                fragmentManager.beginTransaction().add(R.id.fragment1, BlueFragment()).commit()
                fragmentManager.beginTransaction().add(R.id.fragment2, RedFragment()).commit()
            }
            else {
                fragmentManager.beginTransaction().add(R.id.fragment1, RedFragment()).commit()
                fragmentManager.beginTransaction().add(R.id.fragment2, BlueFragment()).commit()
            }


        }

        setContentView(binding.root)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getString("frag") == "red"){
            fragmentManager.beginTransaction().add(R.id.fragment1, RedFragment()).commit()
            fragmentManager.beginTransaction().add(R.id.fragment2, BlueFragment()).commit()
        }
        else {
            fragmentManager.beginTransaction().add(R.id.fragment1, BlueFragment()).commit()
            fragmentManager.beginTransaction().add(R.id.fragment2, RedFragment()).commit()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        fragment1 = fragmentManager.findFragmentById(R.id.fragment1)!!
        if (fragment1?.javaClass == RedFragment::class.java)
        outState.putSerializable("frag", "red")
        else outState.putSerializable("frag", "blue")
    }

}