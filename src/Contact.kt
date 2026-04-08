data class Contact(
    var name: String,
    var phoneNumber: String) {
    override fun toString(): String {
        return "👤 Name: $name | 📞 Phone: $phoneNumber"
    }
}