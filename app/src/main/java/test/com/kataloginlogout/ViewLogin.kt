package test.com.kataloginlogout

class ViewLogin(){

    var main = MainActivity()
    var presenter = Presenter()

    fun hideLoginForm(username: String, userpass: String){
        presenter.onLoginButtonClick(username, userpass)
    }

    fun hideLogoutForm(){
        main.hideLogout()
    }

    fun showLoginForm(){

    }

    fun showLogOutForm(){
        main.showLogout()
    }
}