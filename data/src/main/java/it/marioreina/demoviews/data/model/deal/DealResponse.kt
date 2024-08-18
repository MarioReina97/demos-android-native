package it.marioreina.demoviews.data.model.deal

import java.io.Serializable

data class DealResponse(
    val dealID: String?,
    val dealRating: String?,
    val gameID: String?,
    val internalName: String?,
    val isOnSale: String?,
    val lastChange: Long?,
    val metacriticLink: String?,
    val metacriticScore: String?,
    val normalPrice: String?,
    val releaseDate: Long?,
    val salePrice: String?,
    val savings: String?,
    val steamAppID: String?,
    val steamRatingCount: String?,
    val steamRatingPercent: String?,
    val steamRatingText: String?,
    val storeID: String?,
    val thumb: String?,
    val title: String?
): Serializable