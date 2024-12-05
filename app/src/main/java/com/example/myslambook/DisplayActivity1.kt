import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook.databinding.ActivityDisplay1Binding

class DisplayActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityDisplay1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplay1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvFullName.text = intent.getStringExtra("FULL_NAME") ?: "No Name"
        binding.tvNickname.text = intent.getStringExtra("NICKNAME") ?: "No Nickname"
        binding.tvBirthday.text = intent.getStringExtra("BIRTHDAY") ?: "No Birthday"
        binding.tvStatus.text = intent.getStringExtra("STATUS") ?: "No Status"
        binding.tvZodiacSign.text = intent.getStringExtra("ZODIAC_SIGN") ?: "No Zodiac Sign"
        binding.tvAddress.text = intent.getStringExtra("ADDRESS") ?: "No Address"
        binding.tvContactNo.text = intent.getStringExtra("CONTACT_NO") ?: "No Contact No"
        binding.tvGender.text = intent.getStringExtra("GENDER") ?: "No Gender"
    }
}
