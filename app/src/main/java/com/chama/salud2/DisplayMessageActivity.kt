//REFERENCIAS: https://stackoverflow.com/questions/19253786/how-to-copy-text-to-clip-board-in-android


package com.chama.salud2

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
        val btn_click_me = findViewById(R.id.button2) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(
                "Message",
                message
            )
            clipboard.setPrimaryClip(clip)
            Toast.makeText(applicationContext,"¡Mensaje copiado al portapapeles!",Toast.LENGTH_SHORT).show()
        }
    }
}
