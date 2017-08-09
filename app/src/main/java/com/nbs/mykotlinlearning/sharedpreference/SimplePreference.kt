package com.nbs.mykotlinlearning.sharedpreference

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by sidiqpermana on 8/6/17.
 */
class SimplePreference(context: Context){
    val PREFNAME = "simplePref"
    val KEY_NAME = "name"
    val KEY_AGE = "age"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFNAME, Context.MODE_PRIVATE)

    var name: String
        get() = prefs.getString(KEY_NAME, "")
        set(value) = prefs.edit().putString(KEY_NAME, value).apply()

    var age: Int
        get() = prefs.getInt(KEY_AGE, 0)
        set(value) = prefs.edit().putInt(KEY_AGE, value).apply()

    fun clear(){
        prefs.edit().clear().apply()
    }
}