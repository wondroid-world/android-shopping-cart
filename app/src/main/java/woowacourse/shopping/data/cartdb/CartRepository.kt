package woowacourse.shopping.data.cartdb

import woowacourse.shopping.domain.Product

interface CartRepository {
    fun addProduct(product: Product)
}
