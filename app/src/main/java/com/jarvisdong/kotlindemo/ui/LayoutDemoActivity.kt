package com.jarvisdong.kotlindemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jarvisdong.kit.utils.CommonUtils
import com.jarvisdong.kotlindemo.R
import kotlinx.android.synthetic.main.activity_layout_demo.*

class LayoutDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_demo)

        initView()
    }

    private fun initView() {
        text1.text = CommonUtils.getStringId(R.string.test_str1)
        text2.text = CommonUtils.getStringId(R.string.test_str2)

        text4.text = CommonUtils.getStringId(R.string.test_str3)
        text4_content.text = CommonUtils.getStringId(R.string.test_str4)

        img.setImageResource(R.mipmap.icon_weather0)
        img2.setImageResource(R.mipmap.icon_weather1)
    }
}