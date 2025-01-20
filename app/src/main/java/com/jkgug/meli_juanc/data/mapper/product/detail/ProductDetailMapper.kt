package com.jkgug.meli_juanc.data.mapper.product.detail

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.remote.dto.items.ItemDetailsDtoOut
import com.jkgug.meli_juanc.domain.ProductDetails
import com.jkgug.meli_juanc.domain.ProductDetailsAttribute
import com.jkgug.meli_juanc.domain.ProductPrice

class ProductDetailMapper : Mapper<ItemDetailsDtoOut, ProductDetails> {

    override fun mapFrom(from: ItemDetailsDtoOut): ProductDetails = ProductDetails(
        id = from.id,
        title = from.title,
        thumbnail = from.thumbnailId,
        price = ProductPrice(price = from.price, originalPrice = from.originalPrice),
        freeShipping = from.shipping.freeShipping,
        listAttributes = from.attributes?.let {
            it.map { ProductDetailsAttribute(name = it.name, value = it.valueName ?: "") }
        } ?: run { emptyList() },
        listVariations = from.variations?.let { variations ->
            if (variations.isNotEmpty()) {
                variations[0].attributeCombinations.map {
                    ProductDetailsAttribute(name = it.name, value = it.valueName)
                }
            } else {
                emptyList()
            }
        } ?: run { emptyList() },
        listSaleTerms = from.saleTerms.map {
            ProductDetailsAttribute(name = it.name, value = it.valueName)
        },
        listPictures = from.pictures.map { it.url }
    )

}