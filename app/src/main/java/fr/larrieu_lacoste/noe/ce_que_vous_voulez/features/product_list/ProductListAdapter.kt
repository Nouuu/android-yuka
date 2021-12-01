package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.R
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product

class ProductListAdapter(
    private val products: List<Product>,
    private val listener: OnProductClickListener
) : RecyclerView.Adapter<ProductListCell>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListCell {
        return ProductListCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product_list_cell, parent, false)
        )
    }

    override fun onBindViewHolder(cell: ProductListCell, position: Int) {
        ProductListCell.bindProduct(cell, products[position])
        cell.card.setOnClickListener {
            listener.onProductClicked(products[position])
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

}