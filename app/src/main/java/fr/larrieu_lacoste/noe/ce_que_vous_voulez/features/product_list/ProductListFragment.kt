package fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_list

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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
        setProductListAdapter()
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
            this.findFragment())
        }

        products_start_scan.setOnClickListener {
            val intent = Intent()
            intent.action = "com.google.zxing.client.android.SCAN"
            intent.putExtra("SCAN_FORMATS", "EAN_13")
//            startActivityForResult(intent,100)
            getResult.launch(intent)
        }
    }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
//                val format = it.data?.getStringExtra("SCAN_RESULT_FORMAT")
                val res = it.data?.getStringExtra("SCAN_RESULT")

                if (res != null) {
                    val product = ProductListUtil.addProduct(res, resources)
                    findNavController().navigate(
                        ProductListFragmentDirections.actionProductListFragmentToProductViewFragment(
                            product
                        )
                    )
                }
//                val action = EmptyFragmentDirections.actionEmptyFragmentToProductsFragment(res!!)
//                myView.findNavController().navigate(action)
            }

            if (it.resultCode == Activity.RESULT_CANCELED) {
                Log.e("EmptyFragment", "Scan cancelled !")
            }
        }
}