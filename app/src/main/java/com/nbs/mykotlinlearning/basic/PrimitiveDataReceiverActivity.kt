package com.nbs.mykotlinlearning.basic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.nbs.mykotlinlearning.R
import kotlinx.android.synthetic.main.activity_primitive_data_receiver.*

class PrimitiveDataReceiverActivity : AppCompatActivity() {

    companion object {
        val NAME = "id"
        val AGE = "age"
        val EMAIL = "email"
        val IS_MARRIED = "is_married"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primitive_data_receiver)

        val name = intent.getStringExtra(NAME)
        val age = intent.getIntExtra(AGE, 0)
        val email = intent.getStringExtra(EMAIL)
        val isMarried = intent.getBooleanExtra(IS_MARRIED, false)

        val married = if (isMarried) "Sudah Menikah" else "Belum Menikah"
        val text = "<b>$name</b> saat ini berusia <b>$age</b> dengan alamat email <b>$email</b> dan tentunya <b>$married</b>"
        tvReceivedData.text = Html.fromHtml(text)
    }
}
