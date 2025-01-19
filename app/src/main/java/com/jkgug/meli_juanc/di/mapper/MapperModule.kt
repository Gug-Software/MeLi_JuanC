package com.jkgug.meli_juanc.di.mapper

import com.jkgug.meli_juanc.data.mapper.Mapper
import com.jkgug.meli_juanc.data.mapper.product.ProductMapper
import com.jkgug.meli_juanc.data.remote.dto.search.Result
import com.jkgug.meli_juanc.domain.Product
import org.koin.dsl.module

class MapperModule {

    companion object {

        val mapperModule = module {

            single<Mapper<Result, Product>> { ProductMapper() }

        }

    }
}