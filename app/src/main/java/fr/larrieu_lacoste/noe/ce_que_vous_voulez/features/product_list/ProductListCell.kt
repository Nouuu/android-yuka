package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_list

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.R
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.util.ImgUtil
import kotlinx.android.synthetic.main.product_list_cell.view.*

class ProductListCell(private val v: View) : RecyclerView.ViewHolder(v) {

    val card: CardView = v.card_cell
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
            return str
        }

        fun bindProduct(cell: ProductListCell, product: Product, parent: Fragment) {
//            cell.img.setImageURI(product.imgUrl)
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
            loadPlaceholderImg(product, cell, parent)
        }

        private fun loadPlaceholderImg(
            product: Product,
            cell: ProductListCell,
            parent: Fragment
        ) {
            ImgUtil.loadImgWithGlade(product.imgUrl, cell.img, parent)
        }
    }
}