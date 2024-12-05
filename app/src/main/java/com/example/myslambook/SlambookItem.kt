import java.io.Serializable

data class SlambookItem(
    val profileImage: Int,
    val name: String,
    // Add other fields as needed
    val nickname: String? = null,
    val birthday: String? = null,
    val status: String? = null,
    val zodiacSign: String? = null
) : Serializable
