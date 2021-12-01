package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_details.nutrional_values

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.R
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product

class ProductDetailsNutritionalValuesAdapter(
    private val product: Product,
) : RecyclerView.Adapter<ProductDetailsNutrionalValuesRecyclerItem>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductDetailsNutrionalValuesRecyclerItem {
        return ProductDetailsNutrionalValuesRecyclerItem(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product_details_nutritional_values_recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(cell: ProductDetailsNutrionalValuesRecyclerItem, position: Int) {
        when (position) {
            1 -> ProductDetailsNutrionalValuesRecyclerItem.bindItem(
                cell,
                cell.itemView.resources.getString(R.string.calories_word),
                product.nutritionFacts.calories
            )
            2 -> ProductDetailsNutrionalValuesRecyclerItem.bindItem(
                cell,
                cell.itemView.resources.getString(R.string.fat),
                product.nutritionFacts.fat
            )
            3 -> ProductDetailsNutrionalValuesRecyclerItem.bindItem(
                cell,
                cell.itemView.resources.getString(R.string.satured_fat),
                product.nutritionFacts.saturatedFattyAcids
            )
            4 -> ProductDetailsNutrionalValuesRecyclerItem.bindItem(
                cell,
                cell.itemView.resources.getString(R.string.glucids),
                product.nutritionFacts.glucids
            )
            5 -> ProductDetailsNutrionalValuesRecyclerItem.bindItem(
                cell,
                cell.itemView.resources.getString(R.string.sugar),
                product.nutritionFacts.sugar
            )
            6 -> ProductDetailsNutrionalValuesRecyclerItem.bindItem(
                cell,
                cell.itemView.resources.getString(R.string.dietaryFiber),
                product.nutritionFacts.dietaryFiber
            )
            7 -> ProductDetailsNutrionalValuesRecyclerItem.bindItem(
                cell,
                cell.itemView.resources.getString(R.string.proteins),
                product.nutritionFacts.proteins
            )
            8 -> ProductDetailsNutrionalValuesRecyclerItem.bindItem(
                cell,
                cell.itemView.resources.getString(R.string.salt),
                product.nutritionFacts.salt
            )
            9 -> ProductDetailsNutrionalValuesRecyclerItem.bindItem(
                cell,
                cell.itemView.resources.getString(R.string.sodium),
                product.nutritionFacts.sodium
            )
        }

    }

    override fun getItemCount(): Int {
        return 9
    }

}