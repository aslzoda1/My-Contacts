import java.util.Scanner

fun main() {
    val manager = ContactManager()
    val sc = Scanner(System.`in`)

    println("📱 WELCOME TO MY CONTACT PRO 📱")

    while (true) {
        println("""
            
            🛠️ MENU:
            1. ➕ Add Contact
            2. 🖼️ View All
            3. ✏️ Edit Contact
            4. ❌ Delete Contact
            5. 🧨 Delete All
            0. 🚪 Exit
        """.trimIndent())

        print("\n👉 Select option: ")

        try {
            val choice = sc.next()

            when (choice) {
                "1" -> {
                    print("Enter Name: ")
                    val name = readLine() ?: ""
                    print("Enter Phone (+998 ?????????): ")
                    val phone = sc.next()
                    manager.addContact(name, phone)
                }
                "2" -> manager.viewContacts()
                "3" -> {
                    manager.viewContacts()
                    if (manager.getCount() > 0) {
                        print("Enter ID to edit: ")
                        val id = sc.nextInt() - 1
                        print("New Name: ")
                        val nName = sc.next()
                        print("New Phone (+998XXXXXXXXX): ")
                        val nPhone = sc.next()
                        manager.editContact(id, nName, nPhone)
                    }
                }
                "4" -> {
                    manager.viewContacts()
                    if (manager.getCount() > 0) {
                        print("Enter ID to delete: ")
                        val id = sc.nextInt() - 1
                        manager.deleteContact(id)
                    }
                }
                "5" -> {
                    print("Are you sure? (y/n): ")
                    if (sc.next().lowercase() == "y") manager.deleteAll()
                }
                "0" -> {
                    println("👋 Goodbye!")
                    return
                }
                else -> println("⚠️ Wrong input! Choose between 0-5.")
            }
        } catch (e: Exception) {
             println("\n🚨 ERROR: ${e.message}")
            sc.nextLine()
        }
    }
}