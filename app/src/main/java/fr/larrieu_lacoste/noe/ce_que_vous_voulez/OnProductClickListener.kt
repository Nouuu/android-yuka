package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product

interface OnProductClickListener {
    fun onProductClicked(product: Product)
}