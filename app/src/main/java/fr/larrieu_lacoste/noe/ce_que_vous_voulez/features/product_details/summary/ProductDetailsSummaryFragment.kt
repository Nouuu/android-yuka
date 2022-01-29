package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.summary

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.R
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.ProductDetailsFragment
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.ProductDetailsFragmentArgs
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.util.ImgUtil
import kotlinx.android.synthetic.main.product_details_summary_fragment.*
import kotlinx.android.synthetic.main.product_details_summary_fragment.food_additifs
import kotlinx.android.synthetic.main.product_details_summary_fragment.food_allergic
import kotlinx.android.synthetic.main.product_details_summary_fragment.food_bar_code
import kotlinx.android.synthetic.main.product_details_summary_fragment.food_brand
import kotlinx.android.synthetic.main.product_details_summary_fragment.food_ingredients
import kotlinx.android.synthetic.main.product_details_summary_fragment.food_name
import kotlinx.android.synthetic.main.product_details_summary_fragment.food_quantity
import kotlinx.android.synthetic.main.product_details_summary_fragment.food_sell_in
import kotlinx.android.synthetic.main.product_view_deprecated.food_nutriscore

class ProductDetailsSummaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.product_details_summary_fragment,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieveProduct()
    }

    private fun retrieveProduct() {
        val detailsFragment: ProductDetailsFragment =
            requireParentFragment().requireParentFragment() as ProductDetailsFragment
        val product: Product =
            ProductDetailsFragmentArgs.fromBundle(detailsFragment.requireArguments()).product
        fillProductDetails(product)
        fillPlaceholder(product)
        setNutriscoreImg(product)

    }

    private fun fillProductDetails(product: Product) {
        food_name.text = product.name
        food_brand.text = product.brand
        food_bar_code.text = setTextBold(getString(R.string.bar_code, product.barCode), ":")
        food_quantity.text = setTextBold(getString(R.string.quantity, product.quantity), ":")
        food_sell_in.text =
            setTextBold(getString(R.string.sell_in, product.countries.joinToString(", ")), ":")
        food_ingredients.text =
            setTextBold(
                getString(R.string.ingredients, product.ingredients.joinToString(", ")),
                ":"
            )
        food_allergic.text =
            setTextBold(getString(R.string.allergic, product.allergens.joinToString(", ")), ":")
        food_additifs.text =
            setTextBold(getString(R.string.additifs, product.additives.joinToString(", ")), ":")

    }

    private fun fillPlaceholder(product: Product) {
        ImgUtil.loadImgWithGlade(product.imgUrl, placeholder, this)
    }

    private fun setNutriscoreImg(product: Product) {
        food_nutriscore.setImageResource(
            when (product.nutriscore) {
                'A' -> R.drawable.nutriscore_a
                'B' -> R.drawable.nutriscore_b
                'C' -> R.drawable.nutriscore_c
                'D' -> R.drawable.nutriscore_d
                'E' -> R.drawable.nutriscore_e
                else -> R.drawable.nutriscore_e
            }
        )
    }

    private fun setTextBold(text: String, sep: String): SpannableStringBuilder {
        val str = SpannableStringBuilder(text)
        str.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(sep) + sep.length, 0)
        return str
    }
}