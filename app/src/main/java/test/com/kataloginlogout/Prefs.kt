package test.com.kataloginlogout

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import kotlinx.serialization.json.JSON
import kotlinx.serialization.parse
import kotlinx.serialization.stringify

class Prefs (context: Context) {

    val PREFS_FILENAME = "com.kataloginlogout.prefs"
    val PREFERENCE_CONTACTS = "SharedpreferencesContacts"

    val preferences = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)


    fun getContact(id: Int) : String{
        return preferences.getString(id.toString(), "nonExistent")
    }

    @kotlinx.serialization.ImplicitReflectionSerializer
    fun setContact(contact: Contact){
        var contactString: String = JSON.stringify(contact)
        print(contactString)

        val editor = preferences.edit()
        editor.putString(contact.id.toString(), contactString)
        editor.apply()
    }

    @kotlinx.serialization.ImplicitReflectionSerializer
    fun getAllContacts(): Map<String, *>{
        return preferences.all
    }

    @kotlinx.serialization.ImplicitReflectionSerializer
    fun deleteAllContacts(){
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }

}
