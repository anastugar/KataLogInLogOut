package test.com.kataloginlogout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.logoutactivity.*

class Logout : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logoutBtn.setOnClickListener(){
            val intent: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


    }
}