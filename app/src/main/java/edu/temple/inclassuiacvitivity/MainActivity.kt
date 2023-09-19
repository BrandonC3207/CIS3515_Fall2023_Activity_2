package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* Step 1: Populate this array */
        val numberArray = arrayOfNulls<Number>(20)
        for (i in numberArray.indices) {
            numberArray[i] = 5 * (i+1)
        }

        /* Step 2: Create adapter to display items from array in Spinner */
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, numberArray)

        // Step 3: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p0?.run {
                    val num = getItemAtPosition(p2)
                    displayTextView.textSize = num.toString().toFloat()
                }

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }
}