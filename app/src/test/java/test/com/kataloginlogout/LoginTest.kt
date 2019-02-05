package test.com.kataloginlogout

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class LoginTest{

    var login = Login()
    val adminName = "admin"
    val invalidName = "testuser"

    @Test
    fun username_and_userpass_correct_login(){
        var result = login.performLogin(adminName, adminName)

        assertEquals(true, result)
    }

    @Test
    fun username_and_userpass_empty_no_login(){
        var result = login.performLogin(adminName, adminName)

        assertEquals(false, result)
    }

    @Test
    fun username_empty_no_login(){
        var result = login.performLogin("", adminName)

        assertEquals(false, result)
    }

    @Test
    fun userpass_empty_no_login(){
        var result = login.performLogin(adminName, "")

        assertEquals(false, result)
    }

    @Test
    fun username_and_userpass_incorrect_no_login(){
        var result = login.performLogin(invalidName, invalidName)

        assertEquals(false, result)
    }

    @Test
    fun login_view_mocked(){
        var view = Mockito.mock(ViewLogin::class.java)
        var loginM = Mockito.mock(Login::class.java)

        `when`(loginM.performLogin(adminName, adminName)).thenReturn(true)
    }


}