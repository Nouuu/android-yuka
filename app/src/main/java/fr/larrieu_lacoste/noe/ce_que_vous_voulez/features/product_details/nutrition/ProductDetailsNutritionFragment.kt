package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.R
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.ProductDetailsFragment
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.ProductDetailsFragmentArgs
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.util.ActivityUtil

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
        )
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
        val manager = childFragmentManager

        addCaloriesFragment(manager)
        addFatFragment(manager)
        addSaturedFatAcidsFragment(manager)
        addGlucidsFragment(manager)
        addSugarFragment(manager)
        addDietaryFiberFragment(manager)
        addProteinsFragment(manager)
        addSaltFragment(manager)
        addSodiumFragment(manager)
    }

    private fun addCaloriesFragment(manager: FragmentManager) {

        val fragment = NutritionFactsItemFragment()
        fragment.fillNutritionFact(
            resources.getString(R.string.calories_word),
            product!!.nutritionFacts.calories,
            R.color.nutrient_level_low
        )
        ActivityUtil.addFragmentToActivity(manager, fragment, R.id.nutrition_facts_container)
    }

    private fun addFatFragment(manager: FragmentManager) {

        val fragment = NutritionFactsItemFragment()
        fragment.fillNutritionFact(
            resources.getString(R.string.fat),
            product!!.nutritionFacts.fat,
            R.color.nutrient_level_low
        )
        ActivityUtil.addFragmentToActivity(manager, fragment, R.id.nutrition_facts_container)
    }

    private fun addSaturedFatAcidsFragment(manager: FragmentManager) {

        val fragment = NutritionFactsItemFragment()
        fragment.fillNutritionFact(
            resources.getString(R.string.satured_fat),
            product!!.nutritionFacts.saturatedFattyAcids,
            R.color.nutrient_level_low
        )
        ActivityUtil.addFragmentToActivity(manager, fragment, R.id.nutrition_facts_container)
    }

    private fun addGlucidsFragment(manager: FragmentManager) {

        val fragment = NutritionFactsItemFragment()
        fragment.fillNutritionFact(
            resources.getString(R.string.glucids),
            product!!.nutritionFacts.glucids,
            R.color.nutrient_level_moderate
        )
        ActivityUtil.addFragmentToActivity(manager, fragment, R.id.nutrition_facts_container)
    }

    private fun addSugarFragment(manager: FragmentManager) {

        val fragment = NutritionFactsItemFragment()
        fragment.fillNutritionFact(
            resources.getString(R.string.sugar),
            product!!.nutritionFacts.sugar,
            R.color.nutrient_level_moderate
        )
        ActivityUtil.addFragmentToActivity(manager, fragment, R.id.nutrition_facts_container)
    }

    private fun addDietaryFiberFragment(manager: FragmentManager) {

        val fragment = NutritionFactsItemFragment()
        fragment.fillNutritionFact(
            resources.getString(R.string.dietaryFiber),
            product!!.nutritionFacts.dietaryFiber,
            R.color.nutrient_level_moderate
        )
        ActivityUtil.addFragmentToActivity(manager, fragment, R.id.nutrition_facts_container)
    }

    private fun addProteinsFragment(manager: FragmentManager) {

        val fragment = NutritionFactsItemFragment()
        fragment.fillNutritionFact(
            resources.getString(R.string.proteins),
            product!!.nutritionFacts.proteins,
            R.color.nutrient_level_moderate
        )
        ActivityUtil.addFragmentToActivity(manager, fragment, R.id.nutrition_facts_container)
    }

    private fun addSaltFragment(manager: FragmentManager) {

        val fragment = NutritionFactsItemFragment()
        fragment.fillNutritionFact(
            resources.getString(R.string.salt),
            product!!.nutritionFacts.salt,
            R.color.nutrient_level_high
        )
        ActivityUtil.addFragmentToActivity(manager, fragment, R.id.nutrition_facts_container)
    }

    private fun addSodiumFragment(manager: FragmentManager) {

        val fragment = NutritionFactsItemFragment()
        fragment.fillNutritionFact(
            resources.getString(R.string.sodium),
            product!!.nutritionFacts.sodium,
            R.color.nutrient_level_high
        )
        ActivityUtil.addFragmentToActivity(manager, fragment, R.id.nutrition_facts_container)
    }

}