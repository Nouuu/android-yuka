package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_list

import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product

interface OnProductClickListener {
    fun onProductClicked(product: Product)
}