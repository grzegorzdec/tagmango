package com.grzegorzdec.tagmango

import android.app.Application
import com.grzegorzdec.databinding.PropertyMapper

class TagmangoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PropertyMapper.bindableResourceClass = BR::class.java
    }
}