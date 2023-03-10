package com.codewithmanju.myfamily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottombar= findViewById<BottomNavigationView>(R.id.bottom_bar)

        bottombar.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.nav_guard -> {
                    inflateFragment(GuardFragment.newInstance())
                }
                R.id.nav_home -> {
                    inflateFragment(HomeFragment.newInstance())
                }
                R.id.nav_dashboard -> {
                    inflateFragment(MapFragment())
                }
                R.id.nav_user -> {
                    inflateFragment(ProfileFragment.newInstance())
                }
            }

            true
        }

        bottombar.selectedItemId=R.id.nav_home

        }

    private fun inflateFragment(newInstance: Fragment) {
        var transaction =supportFragmentManager.beginTransaction()
        transaction.replace(R.id.conntainer, newInstance)
        transaction.commit()

    }

}