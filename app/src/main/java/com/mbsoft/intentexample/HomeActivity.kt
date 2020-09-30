package com.mbsoft.intentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btLogout.setOnClickListener {
            ContentResolverHelper(this).clearAllUser()
            finish()
        }
    }
    override fun onBackPressed() {}
}