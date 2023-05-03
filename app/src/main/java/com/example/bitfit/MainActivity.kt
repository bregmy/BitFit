import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit.FoodAdapter
import com.example.bitfit.ItemClass
import com.example.bitfit.R

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: FoodAdapter
    private val foodList = ArrayList<ItemClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = FoodAdapter(foodList)
        recyclerView.adapter = userAdapter

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            val food = data.getStringExtra("FOOD")
            val calorie = data.getStringExtra("CALORIE")

            val newItem = ItemClass(food!!, calorie!!)
            foodList.add(newItem)
            userAdapter.notifyDataSetChanged()
        }
    }
}
