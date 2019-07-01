package com.grzegorzdec.tagmango

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.grzegorzdec.tagmango.api.Api
import com.grzegorzdec.tagmango.api.Service
import com.grzegorzdec.tagmango.model.Meal
import com.grzegorzdec.tagmango.qr.show.QrShowDialogFragment
import com.grzegorzdec.tagmango.tools.Toaster
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    private lateinit var toaster: Toaster
    private var api: Service? = null
    private var myJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottom_bar)

        init()
        setup()

    }

    override fun onDestroy() {
        myJob?.cancel()
        super.onDestroy()
    }

    private fun init() {
        api = Api.getApi()
        toaster = Toaster(this)
        myJob = CoroutineScope(Dispatchers.IO).launch {
            val result = getMeals()
            withContext(Dispatchers.Main) {
                result?.let {
                    if(it.isNotEmpty()) {
                        toaster.show(it[0].name)
                    }
                }
            }
        }
    }

    private fun setup() {
        fab.setOnClickListener {
            if (BuildConfig.FOODIE_MODE) {
                QrShowDialogFragment().show(supportFragmentManager, "TAG")
            }
            if (BuildConfig.SELLER_MODE) {
                IntentIntegrator(this).apply {
                    setOrientationLocked(true)
                    setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                    setBarcodeImageEnabled(false)
                }.initiateScan()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                toaster.show("Cancelled")
            } else {
                toaster.show("Scanned: ${result.contents}")
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private suspend fun getMeals(): List<Meal>? =
        api?.let {
            it.getAllMeals().await().body()
        } ?: listOf()

}
