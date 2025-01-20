package com.jkgug.meli_juanc.data.mapper.product

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.remote.dto.search.Result
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.domain.ProductInstallments
import com.jkgug.meli_juanc.domain.ProductPrice

class ProductMapper : Mapper<Result, Product> {

    override fun mapFrom(from: Result): Product = Product(
        id = from.id,
        title = from.title,
        thumbnail = from.thumbnail,
        price = ProductPrice(price = from.price, originalPrice = from.originalPrice),
        installments = from.installments?.let {
            ProductInstallments(
                quantity = it.quantity,
                rate = it.rate,
                amount = it.amount
            )
        } ?: run { null },
        freeShipping = from.shipping.freeShipping
    )

}