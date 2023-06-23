package com.example.implicitintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat


class MainActivity : AppCompatActivity() {

    private val LOG_TAG: String = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun openWebsite(view: View) {
        val web = findViewById<EditText>(R.id.website)
        val webText = web.text.toString()

        val webpage = Uri.parse(webText)

        val intent = Intent(Intent.ACTION_VIEW, webpage)

        Log.d("ImplicitIntents", "Can't handle this!gwregeqgefgeageage");


        if (intent.resolveActivity(packageManager) != null) {
            print("website")
            startActivity(intent);

        }
        else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    fun openMap(view: View) {
        val map = findViewById<EditText>(R.id.map)
        val mapText = map.text.toString()

        val addressUri = Uri.parse("geo:0,0?q=$mapText")

        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);

        }
        else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }


    }
    fun shareText(view: View) {
        val share = findViewById<EditText>(R.id.share)
        val shareText = share.text.toString()

        val mimeType = "text/plain"

//        ShareCompat.IntentBuilder
//            .from(this)
//            .setType(mimeType)
//            .setChooserTitle("Share this text with: ")
//            .setText(shareText)
//            .startChooser();

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = mimeType
        intent.putExtra(Intent.EXTRA_TEXT, shareText)

        val chooserTitle = "Share this text with: "
        val chooser = Intent.createChooser(intent, chooserTitle)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(chooser)
        } else {
            Log.d("ImplicitIntents", "No app available to handle this intent")
        }


    }

}
