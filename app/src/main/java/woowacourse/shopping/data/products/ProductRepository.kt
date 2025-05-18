package woowacourse.shopping.data.products

import woowacourse.shopping.domain.Product

interface ProductRepository {
    fun getProducts(): List<Product>

    fun getProducts(limit: Int): List<Product>
}
