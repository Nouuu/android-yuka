package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.os.Bundle
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

/*
    private fun fillFoodView() {
        findViewById<TextView>(R.id.food_name).setText(
            getString(
                R.string.food_name,
                "Petits pois carottes"
            )
        )
        findViewById<TextView>(R.id.food_brand).setText(
            getString(
                R.string.food_brand,
                "Cassegrain"
            )
        )
        findViewById<TextView>(R.id.food_bar_code).setText(
            setTextBold(getString(R.string.bar_code, "3083680085304"), ":")
        )
        findViewById<TextView>(R.id.food_quantity).setText(
            setTextBold(
                getString(
                    R.string.quantity,
                    "400 g (280 g net égoutté)"
                ), ":"
            )
        )
        findViewById<TextView>(R.id.food_sell_in).setText(
            setTextBold(
                getString(
                    R.string.sell_in,
                    "France, Japon, Suisse"
                ), ":"
            )
        )
        findViewById<TextView>(R.id.food_ingredients).setText(
            setTextBold(
                getString(
                    R.string.ingredients,
                    "Petits pois 66%, eau, garniture 2,8% (salade, oignon grelot), sucre, sel, arôme naturel"
                ), ":"
            )
        )
        findViewById<TextView>(R.id.food_allergic).setText(
            setTextBold(
                getString(
                    R.string.allergic,
                    "Aucune"
                ), ":"
            )
        )
        findViewById<TextView>(R.id.food_additifs).setText(
            setTextBold(
                getString(
                    R.string.additifs,
                    "Aucun"
                ), ":"
            )
        )
    }
*/

/*
    private fun toastAndSnackbar() {
        val toast = Toast.makeText(
            this,
            resources.getString(R.string.hello_world),
            Toast.LENGTH_LONG
        )

        Log.i("Info/Log", "Coucou les log c'est mouaaaa !")

        Snackbar.make(
            findViewById(android.R.id.content),
            "Coucou snackbar",
            Snackbar.LENGTH_INDEFINITE
        )
            .apply {
                setAction("Action", object : View.OnClickListener {
                    override fun onClick(p0: View?) {
                        toast.show()
                    }
                })
            }
            .show()
    }
*/
}