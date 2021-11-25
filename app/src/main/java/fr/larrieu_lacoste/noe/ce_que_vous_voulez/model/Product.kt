package fr.larrieu_lacoste.noe.ce_que_vous_voulez.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Product(
    val name: String,
    val brand: String,
    val barCode: String,
    val nutriscoreUri: Uri,
    val nutriscore: Char,
    val imgUrl: Uri,
    val calories: Int,
    val quantity: String,
    val countries: List<String>,
    val ingredients: List<String>,
    val allergens: List<String>,
    val additives: List<String>,
    val bookmarked: Boolean
) : Parcelable
