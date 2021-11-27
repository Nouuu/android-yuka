package fr.larrieu_lacoste.noe.ce_que_vous_voulez.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NutritionFacts(
    val calories: NutritionFactsItem,
    val fat: NutritionFactsItem,
    val saturatedFattyAcids: NutritionFactsItem,
    val glucids: NutritionFactsItem,
    val sugar: NutritionFactsItem,
    val dietaryFiber: NutritionFactsItem,
    val proteins: NutritionFactsItem,
    val salt: NutritionFactsItem,
    val sodium: NutritionFactsItem
) : Parcelable