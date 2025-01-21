package com.jkgug.meli_juanc.di.mapper

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.mapper.product.ProductMapper
import com.jkgug.meli_juanc.data.mapper.product.detail.ProductDetailMapper
import com.jkgug.meli_juanc.data.remote.dto.items.ItemDetailsDtoOut
import com.jkgug.meli_juanc.data.remote.dto.search.Result
import com.jkgug.meli_juanc.domain.Product
import com.jkgug.meli_juanc.domain.ProductDetails
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val KEY_PRODUCT_MAPPER = "PRODUCT_MAPPER"
const val KEY_PRODUCT_DETAILS_MAPPER = "PRODUCT_DETAILS_MAPPER"

class MapperModule {

    companion object {

        val mapperModule = module {

            single<Mapper<Result, Product>>(
                named(KEY_PRODUCT_MAPPER)
            ) { ProductMapper() }

            single<Mapper<ItemDetailsDtoOut, ProductDetails>>(
                named(KEY_PRODUCT_DETAILS_MAPPER)
            ) { ProductDetailMapper() }

        }

    }
}