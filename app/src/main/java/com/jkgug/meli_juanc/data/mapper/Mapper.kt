package com.jkgug.meli_juanc.data.mapper

/**
 * Interface for [Mapper]
 *
 * @param F type of input
 * @param T type of output
 *
 */
interface Mapper<F, T> {

    fun mapFrom(from: F): T

}