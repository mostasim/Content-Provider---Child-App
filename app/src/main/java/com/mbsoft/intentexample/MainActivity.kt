package com.mbsoft.intentexample

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.mbsoft.intentexample.db.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var  allUser :ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        val data = intent.data
        allUser = ContentResolverHelper(this).allUser
        val email = data?.getQueryParameter("email")
        val password = data?.getQueryParameter("password")
        tvEmail.text = email
        tvPassword.text = password
        if (isUserExist()) {
            setUserData()
            openHomeActivity()
        }
        btLogin.setOnClickListener {
            ContentResolverHelper(this).insertUser(User(1,"ADMIN","ADMIN"))
            openHomeActivity()

        }
        btClear.setOnClickListener {
            ContentResolverHelper(this).clearAllUser()
        }
    }

    private fun setUserData() {
        tvEmail.text = allUser[0].email
        tvPassword.text = allUser[0].password
    }

    private fun isUserExist() = allUser.isNotEmpty()

    private fun openHomeActivity() {
        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 2000)
    }
}