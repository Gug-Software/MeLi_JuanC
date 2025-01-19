package com.jkgug.meli_juanc.data.remote.dto.search


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("accepts_mercadopago")
    val acceptsMercadopago: Boolean,
    @SerializedName("address")
    val address: Address,
    @SerializedName("attributes")
    val attributes: List<Attribute>,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
    @SerializedName("buying_mode")
    val buyingMode: String,
    @SerializedName("catalog_listing")
    val catalogListing: Boolean,
    @SerializedName("catalog_product_id")
    val catalogProductId: String?,
    @SerializedName("category_id")
    val categoryId: String,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("discounts")
    val discounts: Any?,
    @SerializedName("domain_id")
    val domainId: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("installments")
    val installments: Installments?,
    @SerializedName("inventory_id")
    val inventoryId: Any?,
    @SerializedName("listing_type_id")
    val listingTypeId: String,
    @SerializedName("official_store_id")
    val officialStoreId: Any?,
    @SerializedName("order_backend")
    val orderBackend: Int,
    @SerializedName("original_price")
    val originalPrice: Double?,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("promotion_decorations")
    val promotionDecorations: Any?,
    @SerializedName("promotions")
    val promotions: Any?,
    @SerializedName("sale_price")
    val salePrice: SalePrice,
    @SerializedName("sanitized_title")
    val sanitizedTitle: String,
    @SerializedName("seller")
    val seller: Seller,
    @SerializedName("shipping")
    val shipping: Shipping,
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("stop_time")
    val stopTime: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("thumbnail_id")
    val thumbnailId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("use_thumbnail_id")
    val useThumbnailId: Boolean,
    @SerializedName("variation_filters")
    val variationFilters: List<String>?,
    @SerializedName("variation_id")
    val variationId: String?,
    @SerializedName("variations_data")
    val variationsData: VariationsData?,
    @SerializedName("winner_item_id")
    val winnerItemId: Any?
)