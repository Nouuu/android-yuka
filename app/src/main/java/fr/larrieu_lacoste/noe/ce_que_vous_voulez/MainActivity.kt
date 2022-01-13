package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeaderGradiantColor()
    }

    private fun setHeaderGradiantColor() {
        supportActionBar?.setBackgroundDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.toolbar_gradiant
            )
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null) {
            Toast.makeText(this,
                data.getStringExtra("SCAN_RESULT_FORMAT")
                        +"\n"+
                        data.getStringExtra("SCAN_RESULT"),
                Toast.LENGTH_LONG).show()

        }
    }

}