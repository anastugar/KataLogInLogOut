package test.com.kataloginlogout

import kotlinx.serialization.Serializable

@Serializable
data class Contact(

    var id : Int = 0,
    var name : String = "",
    var lastName : String = "",
    var phoneNumber : String = ""
)