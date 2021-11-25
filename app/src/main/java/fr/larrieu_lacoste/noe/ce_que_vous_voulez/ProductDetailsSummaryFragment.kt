package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product
import kotlinx.android.synthetic.main.product_details_summary_fragment.*

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
        fillProductDetails()
    }

    private fun fillProductDetails() {
        val product: Product =
            ProductDetailsSummaryFragmentArgs.fromBundle(requireArguments()).product
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

    private fun setTextBold(text: String, sep: String): SpannableStringBuilder {
        val str = SpannableStringBuilder(text)
        str.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(sep) + sep.length, 0)
        return str;
    }
}