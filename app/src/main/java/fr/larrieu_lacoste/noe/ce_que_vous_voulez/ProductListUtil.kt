package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.content.res.Resources
import android.net.Uri
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.NutritionFacts
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.NutritionFactsItem
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product

class ProductListUtil {
    companion object {
        fun getProductList(resources: Resources): MutableList<Product> {

            val products = mutableListOf<Product>()
            products.add(
                Product(
                    "Petits pois carottes",
                    "Cassegrain",
                    "3083680085304",
                    Uri.parse("android.resource://" + resources.getResourcePackageName(R.drawable.abc_vector_test) + "/" + R.drawable.nutriscore_a),
                    'A',
                    "https://images.unsplash.com/photo-1482049016688-2d3e1b311543?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=joseph-gonzalez-fdlZBWIP0aM-unsplash.jpg",
                    142,
                    "400 g (280 g net égoutté)",
                    listOf("Japon", "France", "Suisse"),
                    listOf(
                        "Petits pois 66%",
                        "eau",
                        "garniture 2,8% (salade, oignon grelot)",
                        "sucre",
                        "sel",
                        "arôme naturel"
                    ),
                    listOf("Aucun"),
                    listOf("Aucun"),
                    true,
                    NutritionFacts(
                        calories = NutritionFactsItem("kj", 293.0, 88.0),
                        fat = NutritionFactsItem("g", 4.0, 0.8),
                        saturatedFattyAcids = NutritionFactsItem("g", 0.4, 0.1),
                        glucids = NutritionFactsItem("g", 45.0, 8.4),
                        sugar = NutritionFactsItem("g", 22.0, 5.2),
                        dietaryFiber = NutritionFactsItem("g", 22.0, 5.2),
                        proteins = NutritionFactsItem("g", 19.8, 4.8),
                        salt = NutritionFactsItem("g", 3.0, 0.75),
                        sodium = NutritionFactsItem("g", 1.18, 0.295),
                    )
                )
            )

            products.add(
                Product(
                    "new product",
                    "haricot",
                    "0666666",
                    Uri.parse("android.resource://" + resources.getResourcePackageName(R.drawable.nutriscore_a) + "/" + R.drawable.nutriscore_e),
                    'E',
                    "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
                    142,
                    "12",
                    listOf("Japon", "France"),
                    listOf("Jambon", "Fromage"),
                    listOf("Metal", "Cacahouette"),
                    listOf("E214", "E220"),
                    false,
                    NutritionFacts(
                        calories = NutritionFactsItem("kj", 300.0, 90.0),
                        fat = NutritionFactsItem("g", 6.0, 0.86),
                        saturatedFattyAcids = NutritionFactsItem("g", 0.3, 0.08),
                        glucids = NutritionFactsItem("g", 50.0, 12.2),
                        sugar = NutritionFactsItem("g", 6.0, 1.8),
                        dietaryFiber = NutritionFactsItem("g", 60.0, 15.2),
                        proteins = NutritionFactsItem("g", 20.8, 5.2),
                        salt = NutritionFactsItem("g", 3.6, 0.78),
                        sodium = NutritionFactsItem("g", 1.18, 0.295),
                    )
                )
            )

            return products
        }
    }
}