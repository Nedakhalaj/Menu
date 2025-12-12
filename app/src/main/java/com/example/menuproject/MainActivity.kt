package com.example.menuproject
import android.widget.ArrayAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menuproject.R


data class MenuItem(val image:Int, val name: String, val description: String)
class MainActivity : AppCompatActivity() {

    private lateinit var buttonOne : Button
    private lateinit var buttonTwo : Button
    private lateinit var buttonThree : Button

    private lateinit var listView : ListView
    private lateinit var itemImage : ImageView
    private lateinit var itemText : TextView

    val starter = listOf(
        MenuItem(R.drawable.milksoup1,"soup","A warm soup with milk base"),
        MenuItem(R.drawable.salad2, "salad", "A mixed salad with chicken"),
        MenuItem(R.drawable.sambose3,"sambose","A vegetarian light sandwich")
    )
    val mainCourse = listOf(
        MenuItem(R.drawable.zereshkpolo4, "chicken","chicken with rice and barberry"),
        MenuItem(R.drawable.kababkoobide5, "kebab","kebab with saffron rice"),
        MenuItem(R.drawable.ghormesabzi6, "stew","vegetable stew with lamb ")
    )
    val dessert = listOf(
        MenuItem(R.drawable.fallode7, "fallode","An icy sweet string"),
        MenuItem(R.drawable.firini8, "firini","A sweet pudding"),
        MenuItem(R.drawable.sholezard9, "shole zard","A sweet soft pudding with rice and saffron")
    )

    val menu = arrayOf("Starter","MainCourse", "Dessert")

     private var currentList = starter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        buttonOne = findViewById(R.id.button_one)
        buttonTwo = findViewById(R.id.button_two)
        buttonThree = findViewById(R.id.button_three)
        listView = findViewById(R.id.list_view)
        itemText = findViewById(R.id.item_text)
        itemImage = findViewById(R.id.item_image)


        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, menu)

        buttonOne.setOnClickListener {
            val adapter = MenuAdapter(this,starter)
            listView.adapter = adapter}

        buttonTwo.setOnClickListener {
            val adapter = MenuAdapter(this,mainCourse)
            listView.adapter = adapter
        }
        buttonThree.setOnClickListener {
            val adapter = MenuAdapter(this, dessert)
            listView.adapter = adapter
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            val item = currentList[position]
            itemImage.setImageResource(item.image)
            itemText.text = item.description
            true
        }


    }
}