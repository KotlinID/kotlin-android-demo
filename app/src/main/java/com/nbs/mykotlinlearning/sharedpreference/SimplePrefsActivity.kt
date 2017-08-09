package com.nbs.mykotlinlearning.sharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.MenuItem
import com.nbs.mykotlinlearning.R
import kotlinx.android.synthetic.main.activity_simple_prefs.*

class SimplePrefsActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener{
    var prefs: SimplePreference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_prefs)

        prefs = SimplePreference(this)

        


        supportActionBar?.apply {
            title = "Simple Prefs"
            setDisplayHomeAsUpEnabled(true)
        }

        if (!TextUtils.isEmpty(prefs!!.name)) {
            val name = prefs!!.name
            val age = prefs!!.age

            edtName.setText(name)
            edtAge.setText("$age")
        }

        btnSave.setOnClickListener {
            if (!TextUtils.isEmpty(edtName.text) && !TextUtils.isEmpty(edtAge.text)){
                prefs!!.name = edtName.text.toString()
                prefs!!.age = edtAge.text.toString().toInt()
            }
        }

        btnClear.setOnClickListener {
            prefs!!.clear()
            edtName.setText("")
            edtAge.setText("")
        }
    }

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, p1: String?) {

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home)finish()
        return super.onOptionsItemSelected(item)
    }
}
