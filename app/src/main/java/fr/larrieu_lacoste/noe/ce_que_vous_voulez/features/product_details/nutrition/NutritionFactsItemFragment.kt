package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.R
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.NutritionFactsItem
import kotlinx.android.synthetic.main.nutrition_facts_item_fragment.*

class NutritionFactsItemFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.nutrition_facts_item_fragment,
            container,
            false
        );
    }

    var text: String = "noname"
    var colorRes: Int = R.color.nutrient_level_high

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nutritional_text_info.text = text
        nutritional_color.setColorFilter(resources.getColor(colorRes))

    }

    fun fillNutritionFact(
        itemName: String,
        nutritionFactsItem: NutritionFactsItem,
        @ColorRes color: Int
    ) {
        val builder: StringBuilder = StringBuilder()
        builder.append(nutritionFactsItem.g100quantity)
        builder.append(" ")
        builder.append(nutritionFactsItem.unit)
        builder.append(" ")
        builder.append(itemName)
        text = builder.toString()
        colorRes = color
    }
}