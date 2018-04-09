package com.saucelabs.deviceinfo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.LinearLayout
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView


class DeviceInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_info)

        val metrics = resources.displayMetrics

        val llDisplayMetrics = findViewById<LinearLayout>(R.id.llDisplayMetrics)

        llDisplayMetrics.addView(createItemView("density", metrics.density.toString()))
        llDisplayMetrics.addView(createItemView("density*160f", (160f * metrics.density).toString()))
        llDisplayMetrics.addView(createItemView("xdpi", metrics.xdpi.toString()))
        llDisplayMetrics.addView(createItemView("ydpi", metrics.ydpi.toString()))
        llDisplayMetrics.addView(createItemView("densityDpi", metrics.densityDpi.toString()))
        llDisplayMetrics.addView(createItemView("heightPixels", metrics.heightPixels.toString()))
        llDisplayMetrics.addView(createItemView("widthPixels", metrics.widthPixels.toString()))

    }

    private fun createItemView(name: String, value: String): View {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val infoItem = inflater.inflate(R.layout.info_item, null)

        (infoItem.findViewById(R.id.tvItemName) as TextView).setText(name)
        (infoItem.findViewById(R.id.tvItemValue) as TextView).setText(value)

        return infoItem
    }
}
