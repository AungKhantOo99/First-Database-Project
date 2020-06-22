
package com.ako.lgmpj1


import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlin.time.ExperimentalTime

class MainActivity : AppCompatActivity(){


    @ExperimentalTime
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val tabLayout: TabLayout=findViewById(R.id.tabs)
        val viewPager:ViewPager=findViewById(R.id.view_pager)
        val viewPagerAdapter = viewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(LoginFragment(),"LOG IN")
        viewPagerAdapter.addFragment(SignupFragment(),"SIGN UP")
        viewPager.adapter=viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
    internal class viewPagerAdapter(fragmentManager: FragmentManager):
            FragmentPagerAdapter(fragmentManager)
      {
        private val fragments: ArrayList<Fragment>
        private val titles: ArrayList<String>
        init{
            fragments =ArrayList<Fragment>()
            titles= ArrayList<String>()
        }
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }
        override fun getCount(): Int {
            return fragments.size
        }
        fun addFragment(fragment: Fragment,title: String)
        {
            fragments.add(fragment)
            titles.add(title)
        }
        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }
    }

}