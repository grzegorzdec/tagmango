package com.grzegorzdec.tagmango

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.grzegorzdec.tagmango.qr.show.QrShowDialogFragment
import com.grzegorzdec.tagmango.tools.Toaster
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var toaster: Toaster

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottom_bar)

        init()
        setup()

    }

    private fun init() {
        toaster = Toaster(this)
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
}
