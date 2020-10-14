package ru.test.worktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.test.worktest.fragments.BoysFragment
import ru.test.worktest.fragments.GirlsFragment
import ru.test.worktest.fragments.adapter.ViewPageAdapter

class MainActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTabs()
    }

    private fun setUpTabs(){
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(BoysFragment(), "Boys")
        adapter.addFragment(GirlsFragment(), "Girls")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_mars)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_venus)
    }



}
