package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.product_details_fragment.*
import java.lang.Exception

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
        );
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(product_details_bottom_nav, navHost.navController)

        /*product_details_bottom_nav.setOnNavigationItemSelectedListener {
            childFragmentManager.beginTransaction()
                .replace(
                    R.id.product_details_nav_host,
                    when (it.itemId) {
                        R.id.tab_fiche -> ProductDetailsSummaryFragment()
                        R.id.tab_nutrition -> ProductDetailsNutritionFragment()
                        R.id.tab_tableau -> ProductDetailsNutritionnalValuesFragment()
                        else -> throw Exception("Non géré")
                    }
                ).commitAllowingStateLoss()

            true
        }*/
    }

}