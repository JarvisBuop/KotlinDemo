package com.jarvisdong.kotlindemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jarvisdong.kotlindemo.R
import com.jarvisdong.kotlindemo.utils.DemoUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        text1.text = DemoUtils.getStringId(R.string.test_str1)
        text2.text = DemoUtils.getStringId(R.string.test_str2)

        text4.text = DemoUtils.getStringId(R.string.test_str3)
        text4_content.text = DemoUtils.getStringId(R.string.test_str4)

        img.setImageResource(R.mipmap.icon_weather0)
        img2.setImageResource(R.mipmap.icon_weather1)
    }
}
