package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product
import kotlinx.android.synthetic.main.product_list_recycler.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_list_recycler)
        setHeaderGradiantColor()

        val products = mutableListOf<Product>()
        products.add(
            Product(
                "new product",
                "haricot",
                "0666666",
                Uri.parse("android.resource://" + this.packageName + "/" + R.drawable.nutriscore_a),
                'E',
                Uri.parse("android.resource://" + this.packageName + "/" + R.drawable.placeholder),
                142,
                "12",
                listOf("Japon", "France"),
                listOf("Jambon", "Fromage"),
                listOf("Metal", "Cacahouette"),
                listOf("E214", "E220"),
                true
            )
        )
        products.add(
            Product(
                "new product",
                "haricot",
                "0666666",
                Uri.parse("android.resource://" + this.packageName + "/" + R.drawable.nutriscore_a),
                'E',
                Uri.parse("android.resource://" + this.packageName + "/" + R.drawable.placeholder),
                142,
                "12",
                listOf("Japon", "France"),
                listOf("Jambon", "Fromage"),
                listOf("Metal", "Cacahouette"),
                listOf("E214", "E220"),
                true
            )
        )

        setProductListAdapter(products)
    }

    private fun setProductListAdapter(products: MutableList<Product>) {
        product_list_recycler.run {
            layoutManager =
                LinearLayoutManager(this@MainActivity)
            adapter = ProductListAdapter(products)
        }
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