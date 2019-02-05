package test.com.kataloginlogout
import java.time.LocalDateTime
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity

class Login() {

    fun performLogin(name: String, pass: String): Boolean{
        return checkTime(name, pass)
    }

    fun checkTime(name: String, pass: String): Boolean{
        var current = LocalDateTime.now()
        if(current.minute.toInt() % 2 == 0){
            return verifyUserInput(name, pass)
        }else return false
    }

    fun verifyUserInput(name: String, pass: String): Boolean{
        return name.equals("admin") && pass.equals("admin")
    }
}