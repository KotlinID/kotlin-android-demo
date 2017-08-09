package com.nbs.mykotlinlearning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.nbs.mykotlinlearning.basic.MainActivity
import com.nbs.mykotlinlearning.http.nolibrary.WeatherActivity
import com.nbs.mykotlinlearning.http.retrofit.view.ForecastActivity
import com.nbs.mykotlinlearning.sharedpreference.SimplePrefsActivity
import com.nbs.mykotlinlearning.viewgroup.MovieActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.toast

class HomeActivity : AppCompatActivity(), AdapterView.OnItemClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.title = "Home"

        val menus = listOf<String>("Basic",
                "RecyclerView",
                "Shared Preferences",
                "SQLite",
                "Simple Network Connection",
                "Network with Retrofit")

        lvHome.setOnItemClickListener(this)
        lvHome.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, menus)


    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p2){
            0 -> openBasic()
            1 -> openRecyclerView()
            2 -> openSimpleSharedPrefs()
            4 -> openAsync()
            5 -> openWeeklyForecast()
            else -> {
                toast("Not implemented yet")
            }
        }
    }

    private fun openWeeklyForecast() {
        startActivity(Intent(HomeActivity@this, ForecastActivity::class.java))
    }

    private fun openAsync() {
        startActivity(Intent(HomeActivity@this, WeatherActivity::class.java))
    }

    private fun openSimpleSharedPrefs() {
        startActivity(Intent(HomeActivity@this, SimplePrefsActivity::class.java))
    }

    private fun openRecyclerView() {
        startActivity(Intent(HomeActivity@this, MovieActivity::class.java))
    }

    private fun openBasic() {
        startActivity(Intent(HomeActivity@this, MainActivity::class.java))
    }
}
