package com.nbs.mykotlinlearning.basic

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.nbs.mykotlinlearning.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOpenUrl.setOnClickListener(this)
        btnIntentSendDatas.setOnClickListener(this)
        btnSendParcelable.setOnClickListener(this)
        btnTemprature.setOnClickListener(this)
        btnToast.setOnClickListener(this)
        btnIntentForResult.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            btnTemprature -> openTempActivity()
            btnOpenUrl -> openURL()
            btnIntentSendDatas -> sendPrivitiveData()
            btnSendParcelable -> sendParcelable()
            btnToast -> toast("Hello Kotlin, Semangat Belajarnya!")
            btnIntentForResult -> openActivityForResult()
        }
    }

    private fun openActivityForResult() {
        startActivityForResult(Intent(MainActivity@this, GiveBackActivity::class.java), 200)
    }

    private fun sendParcelable() {
        val book = Book("Harry Potter and Goblet of Fire", "JK Rowling", 2002)
        startActivity(intentFor<ParcelableReceiverActivity>(ParcelableReceiverActivity.BOOK to book))
    }

    private fun sendPrivitiveData() {
        startActivity(intentFor<PrimitiveDataReceiverActivity>(PrimitiveDataReceiverActivity.NAME to "Sidiq Permana",
                PrimitiveDataReceiverActivity.AGE to 29,
                PrimitiveDataReceiverActivity.EMAIL to "permana.sidiq@gmail.com",
                PrimitiveDataReceiverActivity.IS_MARRIED to true))
    }

    private fun openURL() {
        browse("http://nusantarabetastudio.com")
    }

    private fun openTempActivity() {
        startActivity(Intent(MainActivity@this, TempratureConverterActivity::class.java))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 200) if (resultCode == 100) toast(data?.getStringExtra("name").toString())
    }
}
