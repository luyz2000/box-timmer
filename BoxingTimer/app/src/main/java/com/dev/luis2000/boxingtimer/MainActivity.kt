package com.dev.luis2000.boxingtimer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    var remaining_time: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        remaining_time = findViewById(R.id.timmer)

        start_timmer.setOnClickListener { view ->
            startTimer()
        }
    }

    private fun startTimer() {
        object : CountDownTimer(180000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remaining_time?.text = (millisUntilFinished / (1000*60) % 60).toString() + ":" + (millisUntilFinished / 1000) % 60
            }
            override fun onFinish() {
                remaining_time?.text = "00:00"
            }
        }.start()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_mainactivity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.getItemId()) {
            R.id.create_new -> {
                //newGame()
                return true
            }
            R.id.open -> {
                //showHelp()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
