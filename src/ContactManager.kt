class ContactManager {
    private val contacts = mutableListOf<Contact>()

    private val phoneRegex = Regex("""^\+998\d{9}$""")

    fun addContact(name: String, phone: String) {
        if (!phone.matches(phoneRegex)) {
            throw Exception("Invalid phone format! Must be +998?????????")
        }
        if (name.isBlank()) {
            throw Exception("Name cannot be empty!")
        }
        contacts.add(Contact(name, phone))
        println("✅ Contact added successfully!")
    }

    fun editContact(index: Int, newName: String, newPhone: String) {
        if (index !in contacts.indices) {
            throw Exception("Contact not found at index ${index + 1}")
        }
        if (!newPhone.matches(phoneRegex)) {
            throw Exception("Invalid phone format!")
        }
        contacts[index].name = newName
        contacts[index].phoneNumber = newPhone
        println("📝 Contact updated successfully!")
    }

    fun deleteContact(index: Int) {
        if (index in contacts.indices) {
            contacts.removeAt(index)
            println("🗑️ Contact deleted!")
        } else {
            throw Exception("Contact not found!")
        }
    }

    fun deleteAll() {
        if (contacts.isEmpty()) {
            println("📭 List is already empty.")
        } else {
            contacts.clear()
            println("🧨 All contacts wiped out!")
        }
    }

    fun viewContacts() {
        if (contacts.isEmpty()) {
            println("📭 Your contact list is empty.")
        } else {
            println("\n📖 --- CONTACT LIST ---")
            contacts.forEachIndexed { index, contact ->
                println("${index + 1}. $contact")
            }
            println("-----------------------")
        }
    }

    fun getCount(): Int = contacts.size
}