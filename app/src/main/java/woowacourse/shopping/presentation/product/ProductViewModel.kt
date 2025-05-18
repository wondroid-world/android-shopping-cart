package woowacourse.shopping.presentation.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import woowacourse.shopping.data.ProductRepository
import woowacourse.shopping.data.ProductRepositoryImpl
import woowacourse.shopping.domain.Product

class ProductViewModel(
    private val productRepository: ProductRepository = ProductRepositoryImpl(),
) : ViewModel() {
    private val _products: MutableLiveData<List<Product>> = MutableLiveData(emptyList())
    val products: LiveData<List<Product>> get() = _products

    fun fetchData() {
        val newProducts = productRepository.getProducts(LIMIT_COUNT)
        _products.value = (_products.value ?: emptyList()).plus(newProducts)
    }

    companion object {
        private const val LIMIT_COUNT = 20
    }
}
