package woowacourse.shopping.data

import woowacourse.shopping.domain.Product

interface ProductRepository {
    fun getProducts(): List<Product>

    fun getCartProducts(): List<Product>

    fun deleteProduct(productId: Long)
}
