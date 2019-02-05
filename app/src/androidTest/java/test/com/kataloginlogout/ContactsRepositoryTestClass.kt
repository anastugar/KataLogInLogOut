package test.com.kataloginlogout

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import test.com.kataloginlogout.exceptions.ContactNotExistsException
import test.com.kataloginlogout.exceptions.NullContactException

@RunWith(AndroidJUnit4::class)
class ContactsRepositoryTestClass {

    val cont = InstrumentationRegistry.getTargetContext()
    val contactsRepository = ContactsRepository(cont)

    val contact1 = Contact(0, "Pedro", "Picapiedra", "609854678")
    val contact2 = Contact(1, "Mario", "Bros", "678987543")
    val contactNull : Contact? = null


    @Test
    @kotlinx.serialization.ImplicitReflectionSerializer
    fun saveContactCorrectly(){

        contactsRepository.saveContact(contact1)

        assertEquals(contact1, contactsRepository.getContactById(contact1.id))
    }

    @Test
    @kotlinx.serialization.ImplicitReflectionSerializer
    fun getContactByIdContactCorrectly(){

        contactsRepository.saveContact(contact1)

        assertEquals(contact1, contactsRepository.getContactById(contact1.id))
    }

    @Test(expected = ContactNotExistsException::class)
    @kotlinx.serialization.ImplicitReflectionSerializer
    fun getContactWhichDoesNotExist(){

        contactsRepository.saveContact(contact1)

        contactsRepository.getContactById(5)
    }

    @Test
    @kotlinx.serialization.ImplicitReflectionSerializer
    fun getAllReturnsContactList(){

        contactsRepository.saveContact(contact1)
        contactsRepository.saveContact(contact2)

        assertEquals(contact1, contactsRepository.getAll().first())
        assertEquals(contact2, contactsRepository.getAll()[1])
    }

    @Test
    @kotlinx.serialization.ImplicitReflectionSerializer
    fun deleteAllContactsCorrectly(){

        contactsRepository.saveContact(contact1)
        contactsRepository.saveContact(contact2)

        contactsRepository.deleteAll()

        assertEquals(mutableListOf<Contact>(), contactsRepository.getAll())
    }

    @Test(expected = NullContactException::class)
    @kotlinx.serialization.ImplicitReflectionSerializer
    fun saveNullContactThrowsNullContactException(){

        contactsRepository.saveContact(contactNull)
    }

    @Test(expected = NullContactException::class)
    @kotlinx.serialization.ImplicitReflectionSerializer
    fun getNullContactByIdThrowsNullContactException(){

        contactsRepository.getContactById(null)
    }


}
