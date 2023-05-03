import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.bitfit.R

class NewActivity : AppCompatActivity() {
    private lateinit var foodInputEditText: EditText
    private lateinit var caloriesInputEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        foodInputEditText = findViewById(R.id.FoodInput)
        caloriesInputEditText = findViewById(R.id.CaloriesInput)

        val submitButton = findViewById<Button>(R.id.button2)
        submitButton.setOnClickListener {
            val food = foodInputEditText.text.toString()
            val calorie = caloriesInputEditText.text.toString()


            val intent = Intent()
            intent.putExtra("FOOD", food)
            intent.putExtra("CALORIE", calorie)
            setResult(RESULT_OK, intent)
            finish()

        }
    }
}
