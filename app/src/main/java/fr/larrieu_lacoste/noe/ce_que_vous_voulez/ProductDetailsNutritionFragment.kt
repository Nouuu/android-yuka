package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product

class ProductDetailsNutritionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.product_details_nutrition_fragment,
            container,
            false
        );
    }

    var product: Product? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieveProduct()
        fillNutritionFactsItems()
    }

    private fun retrieveProduct() {
        val detailsFragment: ProductDetailsFragment =
            requireParentFragment().requireParentFragment() as ProductDetailsFragment
        product = ProductDetailsFragmentArgs.fromBundle(detailsFragment.requireArguments()).product
    }

    private fun fillNutritionFactsItems() {
        var manager = childFragmentManager
        var fragment = NutritionFactsItemFragment()
        ActivityUtil.addFragmentToActivity(manager, fragment, R.id.nutrition_facts_container)
    }

}