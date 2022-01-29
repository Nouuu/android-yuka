package fr.larrieu_lacoste.noe.ce_que_vous_voulez

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_list.ProductListFragmentDirections
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.features.product_list.ProductListUtil

class MainActivity : AppCompatActivity() {

    private lateinit var mainToolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
    }

    private fun initToolbar() {
        mainToolBar = findViewById(R.id.main_toolbar)
        setSupportActionBar(mainToolBar)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null) {
            Toast.makeText(
                this,
                data.getStringExtra("SCAN_RESULT_FORMAT")
                        + "\n" +
                        data.getStringExtra("SCAN_RESULT"),
                Toast.LENGTH_LONG
            ).show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.toolbar_barcode_scanner -> {
            val intent = Intent()
            intent.action = "com.google.zxing.client.android.SCAN"
            intent.putExtra("SCAN_FORMATS", "EAN_13")
//            startActivityForResult(intent,100)
            getResult.launch(intent)
            true
        }
        else -> {
            onBackPressed()
            super.onOptionsItemSelected(item)
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
                    val navController = findNavController(R.id.container)
                    if (navController.currentDestination?.id == R.id.productDetailsFragment) {
                        navController.popBackStack()
                    }
                    navController.navigate(
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

    override fun onBackPressed() {
        val fragmentManager: FragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStackImmediate()
        } else {
            super.onBackPressed()
        }
    }

    fun showUpButton() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun hideUpButton() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }
}