package test.com.kataloginlogout

import android.content.Context
import kotlinx.serialization.json.JSON
import kotlinx.serialization.parse
import test.com.kataloginlogout.exceptions.ContactNotExistsException
import test.com.kataloginlogout.exceptions.NullContactException

class ContactsRepository(context: Context){

    val prefs = Prefs(context)

    @kotlinx.serialization.ImplicitReflectionSerializer
    fun saveContact(contact: Contact?) {
        when(contact){
            null -> throw NullContactException("Contact is null")
            else -> prefs!!.setContact(contact)
        }
    }

    @kotlinx.serialization.ImplicitReflectionSerializer
    fun getContactById(id: Int?): Contact{
        when(id) {
            null -> throw NullContactException("Contact is null")
            else -> {
                var contactString = prefs!!.getContact(id)

                when (contactString) {
                    "nonExistent" -> throw ContactNotExistsException("This contact does not exist")
                    else -> return JSON.parse<Contact>(contactString)
                }
            }
        }
    }


    @kotlinx.serialization.ImplicitReflectionSerializer
    fun getAll(): MutableList<Contact>{
        val contactList = mutableListOf<Contact>()

        var allContacts = prefs.getAllContacts()
        allContacts.forEach{ (key, value) ->
            var contact = JSON.parse<Contact>(value.toString())
            contactList.add(contact)
        }
        return contactList
    }

    @kotlinx.serialization.ImplicitReflectionSerializer
    fun deleteAll() {
        prefs.deleteAllContacts()
    }

}