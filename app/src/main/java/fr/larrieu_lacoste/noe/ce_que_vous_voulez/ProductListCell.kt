package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product
import kotlinx.android.synthetic.main.food_view.view.*

class ProductListCell(v: View) : RecyclerView.ViewHolder(v) {

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

        fun bindProduct(cell: ProductListCell, product: Product) {
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