package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_list

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.MainActivity
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.R
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.model.Product
import kotlinx.android.synthetic.main.product_list_recycler.*

class ProductListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.product_list_recycler, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val actionbar = (activity as AppCompatActivity).supportActionBar
        actionbar?.title = getString(R.string.my_products)

        setProductListAdapter()
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).hideUpButton()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setProductListAdapter() {

        product_list_recycler.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ProductListAdapter(
                ProductListUtil.getProductList(resources),
                object : OnProductClickListener {
                    override fun onProductClicked(product: Product) {
                        findNavController().navigate(
                            ProductListFragmentDirections.actionProductListFragmentToProductViewFragment(
                                product
                            )
                        )
                    }

                },
                this.findFragment()
            )
        }
    }
}