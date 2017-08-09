package com.nbs.mykotlinlearning.basic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import com.nbs.mykotlinlearning.R
import kotlinx.android.synthetic.main.activity_temprature_converter.*
import org.jetbrains.anko.toast

class TempratureConverterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temprature_converter)

        supportActionBar?.title = "Temprature Converter"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnCalculate.setOnClickListener {
            val textCelcius = edtCelcius.text.toString()
            if (!TextUtils.isEmpty(textCelcius)){
                val celcius: Double = textCelcius.toDouble()
                val fahrenheit = ((9*celcius)/5)+32
                val result = "Result : $fahrenheit"
                tvResult.text = result
            }else{
                toast("Field can not be empty")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
