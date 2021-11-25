package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product
import kotlinx.android.synthetic.main.product_list_recycler.*

class ProductListFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_list_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setProductListAdapter()
    }

    private fun setProductListAdapter() {
        product_list_recycler.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ProductListAdapter(getProductList(), object : OnProductClickListener {
                override fun onProductClicked(product: Product) {
                    findNavController().navigate(
                        ProductListFragmentDirections.actionProductListFragmentToProductViewFragment(
                            product
                        )
                    )
                }

            })
        }
    }


    private fun getProductList(): MutableList<Product> {

        val products = mutableListOf<Product>()
        products.add(
            Product(
                "Petits pois carottes",
                "Cassegrain",
                "3083680085304",
                Uri.parse("android.resource://" + resources.getResourcePackageName(R.drawable.abc_vector_test) + "/" + R.drawable.nutriscore_a),
                'A',
                Uri.parse("android.resource://" + resources.getResourcePackageName(R.drawable.placeholder) + "/" + R.drawable.placeholder),
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
                true
            )
        )

        products.add(
            Product(
                "new product",
                "haricot",
                "0666666",
                Uri.parse("android.resource://" + resources.getResourcePackageName(R.drawable.nutriscore_a) + "/" + R.drawable.nutriscore_e),
                'E',
                Uri.parse("android.resource://" + resources.getResourcePackageName(R.drawable.placeholder) + "/" + R.drawable.placeholder),
                142,
                "12",
                listOf("Japon", "France"),
                listOf("Jambon", "Fromage"),
                listOf("Metal", "Cacahouette"),
                listOf("E214", "E220"),
                false
            )
        )

        return products
    }
}