package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.food_list.*
import kotlinx.android.synthetic.main.food_view.view.*
import kotlinx.android.synthetic.main.list_item_cell.view.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_list)
        setHeaderGradiantColor()
        // fillFoodView()
        // toastAndSnackbar()

        val products = mutableListOf<Product>()

        food_list_recycler.run {
            adapter = ListAdapter(products)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
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

class ListAdapter(val products: List<Product>) : RecyclerView.Adapter<ListProductCell>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListProductCell {
        return ListProductCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(cell: ListProductCell, position: Int) {
        ListProductCell.bindProduct(cell, products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

}

class ListProductCell(v: View) : RecyclerView.ViewHolder(v) {

    val img: ImageView = v.food_img
    val name: TextView = v.food_name
    val brand: TextView = v.food_brand
    val nutriscore: ImageView = v.food_nutriscore
    val bar_code: TextView = v.food_bar_code
    val quantity: TextView = v.food_quantity
    val sell_in: TextView = v.food_sell_in
    val ingredients: TextView = v.food_ingredients
    val allergic: TextView = v.food_allergic
    val additifs: TextView = v.food_additifs

    companion object {
        fun setTextBold(text: String, sep: String): SpannableStringBuilder {
            val str = SpannableStringBuilder(text)
            str.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(sep) + sep.length, 0)
            return str;
        }

        fun bindProduct(cell: ListProductCell, product: Product) {
            cell.img.setImageURI(product.imgUrl)
            cell.name.text = product.name
            cell.brand.text = product.brand
            cell.nutriscore.setImageURI(product.nutriscore)
            cell.bar_code.text = product.barCode
            cell.quantity.text = product.quantity
            cell.sell_in.text = product.countries.joinToString(", ")
            cell.ingredients.text = product.ingredients.joinToString(", ")
            cell.allergic.text = product.allergens.joinToString(", ")
            cell.additifs.text = product.additives.joinToString(", ")
        }
    }

}