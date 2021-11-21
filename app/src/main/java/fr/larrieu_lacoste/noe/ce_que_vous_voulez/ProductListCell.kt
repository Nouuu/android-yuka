package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product
import kotlinx.android.synthetic.main.product_list_cell.view.*

class ProductListCell(private val v: View) : RecyclerView.ViewHolder(v) {

    val img: ImageView = v.placeholder
    val name: TextView = v.food_name
    val brand: TextView = v.food_brand
    val bookmarked: ImageView = v.food_bookmarked
    val nutriscore: TextView = v.food_nutriscore
    val calories: TextView = v.food_calories

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
            cell.bookmarked.setColorFilter(
                if (product.bookmarked)
                    cell.v.context.resources.getColor(R.color.icon_selected)
                else
                    cell.v.context.resources.getColor(R.color.icon_default)
            )
            cell.nutriscore.text =
                cell.v.context.resources.getString(R.string.nutriscore, product.nutriscore)
            cell.calories.text =
                cell.v.context.getString(R.string.calories, product.calories.toString())
        }
    }
}