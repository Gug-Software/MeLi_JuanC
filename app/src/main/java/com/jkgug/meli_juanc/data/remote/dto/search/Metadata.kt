package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("additional_bank_interest")
    val additionalBankInterest: Boolean,
    @SerializedName("meliplus_installments")
    val meliplusInstallments: Boolean
)