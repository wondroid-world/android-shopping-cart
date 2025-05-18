package woowacourse.shopping.presentation.product

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import woowacourse.shopping.R
import woowacourse.shopping.databinding.ActivityProductBinding
import woowacourse.shopping.domain.Product
import woowacourse.shopping.presentation.cart.CartActivity
import woowacourse.shopping.presentation.productdetail.ProductDetailActivity

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    private val productAdapter: ProductAdapter by lazy { ProductAdapter(::navigateToProductDetail) }
    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initDataBinding()
        bindData()
    }

    private fun initDataBinding() {
        binding.onClick = ::navigateToCart
        binding.rvProducts.adapter = productAdapter
    }

    private fun bindData() {
        productViewModel.fetchData()
        productViewModel.products.observe(this) { products ->
            productAdapter.setData(products)
        }
    }

    private fun navigateToCart() {
        startActivity(CartActivity.newIntent(context = this))
    }

    private fun navigateToProductDetail(product: Product) {
        startActivity(ProductDetailActivity.newIntent(context = this, product = product))
    }
}
