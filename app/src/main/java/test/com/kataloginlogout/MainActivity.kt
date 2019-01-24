package test.com.kataloginlogout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var userNameText = ""
    var userPassText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userNameText = username.text.toString()

        userPassText = userpass.text.toString()

        loginBtn.setOnClickListener(){
            loginUser(userNameText, userPassText)
        }


    }

    fun loginUser(name: String, pass: String){


        //val intent: Intent = Intent(applicationContext, ::class.java)
        startActivity(intent)

    }
}
