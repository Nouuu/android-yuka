package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.nutrional_values

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.NutritionFactsItem
import kotlinx.android.synthetic.main.product_details_nutritional_values_recycler_item.view.*

class ProductDetailsNutrionalValuesRecyclerItem(v: View) : RecyclerView.ViewHolder(v) {

    val nutritionalValueName: TextView = v.nutrional_value_name
    val nutritionalValue100g: TextView = v.nutrional_value_100g
    val nutritionalValuePart: TextView = v.nutrional_value_part

    companion object {

        fun bindItem(
            cell: ProductDetailsNutrionalValuesRecyclerItem,
            name: String,
            nutritionFactsItem: NutritionFactsItem
        ) {
            println(name)
            cell.nutritionalValueName.text = name
            cell.nutritionalValue100g.text = nutritionFactsItem.g100quantity.toString()
            cell.nutritionalValuePart.text = nutritionFactsItem.pQuantity.toString()
        }
    }
}