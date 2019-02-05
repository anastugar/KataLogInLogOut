package test.com.kataloginlogout

class Presenter(){

    var view = ViewLogin()
    var login = Login()

    fun onLoginButtonClick(username: String, userpass: String){
        if(login.performLogin(username, userpass)){
            view.hideLogoutForm()
        }
    }

    fun onLogoutButtonClick(){

    }
}