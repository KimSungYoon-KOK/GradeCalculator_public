package com.example.grade_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import com.example.grade_calculator.MyPage.MypageFragment
import kotlinx.android.synthetic.main.activity_main.*

val nowGPA = 3.16
val goalGPA = 3.5



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBottomNavListener()
        attachHome()
    }

    fun setBottomNavListener() {

        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                R.id.nav_home -> {
                    attachHome()
                    true
                }
                R.id.nav_mypage -> {
                    attachMypage()
                    true
                }
                R.id.nav_setting -> {
                    attachSetting()
                    true
                }
                else -> false
            }
        }
    }


    lateinit var current_status:String
    fun attachHome(){
        val frag = supportFragmentManager.findFragmentByTag("home")
        val tagStr = frag?.tag.toString()
        if(tagStr == "home"){

        } else{
            val homeTransaction = supportFragmentManager.beginTransaction()
            val homeFrag = HomeFragment()
            homeTransaction.replace(R.id.frame, homeFrag)
            val clear = supportFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            homeTransaction.commit()
            current_status = "home"
        }
    }

    fun attachMypage(){
        val frag = supportFragmentManager.findFragmentByTag("mypage")
        val tagStr = frag?.tag.toString()
        if(tagStr == "mypage"){

        } else{
            val MyPageTransaction = supportFragmentManager.beginTransaction()
            val mypageFrag = MypageFragment()
            MyPageTransaction.replace(R.id.frame, mypageFrag)
            MyPageTransaction.commit()
            current_status = "mypage"
        }
    }

    fun attachSetting(){
        val frag = supportFragmentManager.findFragmentByTag("setting")
        val tagStr = frag?.tag.toString()
        if(tagStr == "setting"){

        } else{
            val ForecastTransaction = supportFragmentManager.beginTransaction()
            val addFrag = SettingFragment()
            ForecastTransaction.replace(R.id.frame, addFrag)
            val clear = supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            ForecastTransaction.commit()
            current_status = "setting"
        }
    }
}
