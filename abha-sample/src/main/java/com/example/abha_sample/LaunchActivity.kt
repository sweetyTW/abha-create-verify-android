package com.example.abha_sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity


class LaunchActivity  : AppCompatActivity() {

    fun invokeSampleAbhaActivity(boolean: Boolean) {
        val intent = Intent(this, SampleAbhaActivity::class.java)
        startActivity(intent);
    }
}