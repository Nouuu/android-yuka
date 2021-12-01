package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.R
import kotlinx.android.synthetic.main.product_details_fragment.*

class ProductDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.product_details_fragment,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost =
            childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(product_details_bottom_nav, navHost.navController)

/*        val product: Product = ProductDetailsFragmentArgs.fromBundle(requireArguments()).product
        println(product)*/

    }

}