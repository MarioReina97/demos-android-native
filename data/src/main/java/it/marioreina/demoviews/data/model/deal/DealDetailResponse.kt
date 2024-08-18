package it.marioreina.demoviews.data.model.deal

import java.io.Serializable

data class DealDetailResponse(
    val cheaperStores: List<CheaperStoreResponse>?,
    val cheapestPrice: CheapestPriceResponse?,
    val gameInfo: GameInfoResponse?
): Serializable

data class CheaperStoreResponse(
    val dealID: String?,
    val retailPrice: String?,
    val salePrice: String?,
    val storeID: String?
): Serializable

data class CheapestPriceResponse(
    val date: Long?,
    val price: String?
): Serializable

data class GameInfoResponse(
    val gameID: String?,
    val metacriticLink: String?,
    val metacriticScore: String?,
    val name: String?,
    val publisher: String?,
    val releaseDate: Long?,
    val retailPrice: String?,
    val salePrice: String?,
    val steamAppID: String?,
    val steamRatingCount: String?,
    val steamRatingPercent: String?,
    val steamRatingText: String?,
    val steamworks: String?,
    val storeID: String?,
    val thumb: String?
): Serializable