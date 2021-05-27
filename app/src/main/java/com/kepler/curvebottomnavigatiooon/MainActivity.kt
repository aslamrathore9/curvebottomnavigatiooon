package com.kepler.curvebottomnavigatiooon

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kepler.curvebottomnavigatiooon.fragment.GpsFragment
import com.kepler.curvebottomnavigatiooon.fragment.GrassFragment
import com.kepler.curvebottomnavigatiooon.fragment.HomeFragment
import com.kepler.curvebottomnavigatiooon.fragment.MicFragment

class MainActivity : AppCompatActivity() {

    var floatingBtn:FloatingActionButton? = null


    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        floatingBtn = findViewById<FloatingActionButton>(R.id.fab) as FloatingActionButton

        floatingBtn!!.setOnClickListener {
            Toast.makeText(this,"Click ad btn", Toast.LENGTH_SHORT).show()
        }

        bottomNavigationView = findViewById<View>(R.id.bottomnavigationbar) as BottomNavigationView
        bottomNavigationView!!.background = null
        bottomNavigationView!!.menu.getItem(2).isEnabled = false
        supportFragmentManager.beginTransaction().replace(R.id.framecontainer, HomeFragment())
            .commit()
        bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
            var temp: Fragment? = null
            when (item.itemId) {
                R.id.mHome -> temp = HomeFragment()
                R.id.mSearch -> temp = GpsFragment()
                R.id.mPerson -> temp = GrassFragment()
                R.id.mSetting -> temp = MicFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.framecontainer,
                temp!!
            ).commit()
            true
        }
    }
}