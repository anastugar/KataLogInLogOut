package test.com.kataloginlogout

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var userNameText = ""
    var userPassText = ""

    val login = Login()
    var view = ViewLogin()

    var et_username : EditText = username
    var et_userpass : EditText = userpass
    var bt_login : Button = loginBtn

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userNameText = et_username.text.toString()

        userPassText = et_userpass.text.toString()

        loginBtn.setOnClickListener(){
                view.hideLoginForm(userNameText, userPassText)
        }


    }


    fun hideLogin(){
        //et_username.visibility = View.INVISIBLE
        //et_userpass.visibility = View.INVISIBLE
        //loginBtn.visibility = View.INVISIBLE
    }

    fun showLogin() {
    }


    fun showLogout(){
        //logoutBtn.visibility = View.VISIBLE
    }

    fun hideLogout(){

    }

}



