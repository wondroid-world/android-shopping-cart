package woowacourse.shopping.domain

import java.io.Serializable

data class Product(
    val id: Long,
    val name: Name,
    val price: Price,
    val imageUrl: String,
) : Serializable
