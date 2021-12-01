package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.nutrional_values

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.R
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.ProductDetailsFragment
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.ProductDetailsFragmentArgs
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product
import kotlinx.android.synthetic.main.product_details_nutritional_values_fragment.*

class ProductDetailsNutritionnalValuesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.product_details_nutritional_values_fragment,
            container,
            false
        );
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailsFragment: ProductDetailsFragment =
            requireParentFragment().requireParentFragment() as ProductDetailsFragment
        val product: Product =
            ProductDetailsFragmentArgs.fromBundle(detailsFragment.requireArguments()).product
        println(product)
    }

}