package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.net.Uri

data class Product(
    val name: String,
    val brand: String,
    val barCode: String,
    val nutriscore: Uri,
    val imgUrl: Uri,
    val quantity: String,
    val countries: List<String>,
    val ingredients: List<String>,
    val allergens: List<String>,
    val additives: List<String>
)
