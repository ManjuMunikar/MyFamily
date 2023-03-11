package com.codewithmanju.myfamily

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.CAMERA
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val permissions= arrayOf(
        ACCESS_FINE_LOCATION,
        CAMERA
    )
    val permissionCode= 78

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        askForPermission()

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

    private fun askForPermission() {
        ActivityCompat.requestPermissions(this, permissions, permissionCode)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == permissionCode) {

            if (allPermissionGranted()) {
                openCamera()
                
            } else {

            }
        }
    }

    private fun openCamera() {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivity(intent)
    }

    private fun allPermissionGranted(): Boolean {
        for (item in permissions) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    item
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
        }

        return true

    }

    private fun inflateFragment(newInstance: Fragment) {
        var transaction =supportFragmentManager.beginTransaction()
        transaction.replace(R.id.conntainer, newInstance)
        transaction.commit()

    }

}