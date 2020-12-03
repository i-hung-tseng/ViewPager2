package com.tom.viewpagerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //創建adapter，回傳總共的頁數 object直接生成類
        viewPager2.adapter = object : FragmentStateAdapter(this) {

            //getItemCount() 總共有幾個頁面
            override fun getItemCount() = 3

            override fun createFragment(position: Int) =
                when(position){
                    //創建一個實例給他，實例是class裡面的內容
                    0->ScaleFragment()
                    1->RorateFragment()
                    //when一定要有一個else
                    else->TranslateFragment()
        }
        }
        //設置tabLayout，第一個是 tabLayout，第二個是要連的viewPager2，
        //再過來{後面是tab,position->是
        TabLayoutMediator(tabLayout,viewPager2){tab,position ->
            when(position){
            0->tab.text ="縮放"
            1->tab.text ="旋轉"
            else->tab.text ="移動"}
            //寫完後加上.attach()連接兩個
        }.attach()
    }
}