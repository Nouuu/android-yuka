package fr.larrieu_lacoste.noe.ce_que_vous_voulez.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class NutritionFactsItem(
    val unit: String,
    val pQuantity: Double,
    val g100quantity: Double,
) : Parcelable