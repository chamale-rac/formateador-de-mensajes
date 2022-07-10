package com.chama.salud2

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_MESSAGE = "com.chama.salud2.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        val fromText = findViewById<EditText>(R.id.editTextTextPersonName)
        val fromMessage = fromText.text.toString()

        val toText = findViewById<EditText>(R.id.editTextTextPersonNameDestinario)
        val toMessage = toText.text.toString()

        val messageText = findViewById<EditText>(R.id.editTextTextMultiLine2)
        val messageMessage = messageText.text.toString()

        val mailText = "Estimad@ " + toMessage + ",\n\n" + messageMessage + "\n\nAtte.,\n" + fromMessage
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, mailText)
        }
        startActivity(intent)
    }
}