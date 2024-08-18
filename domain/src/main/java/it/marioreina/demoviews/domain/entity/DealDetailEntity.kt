package it.marioreina.demoviews.domain.entity

import it.marioreina.demoviews.data.model.deal.CheaperStoreResponse
import it.marioreina.demoviews.data.model.deal.CheapestPriceResponse
import it.marioreina.demoviews.data.model.deal.DealDetailResponse
import it.marioreina.demoviews.data.model.deal.GameInfoResponse
import java.io.Serializable
import java.net.URLDecoder

data class DealDetailEntity(
    val cheaperStores: List<CheaperStoreEntity>?,
    val cheapestPrice: CheapestPriceEntity?,
    val gameInfo: GameInfoEntity?
): Serializable

data class CheaperStoreEntity(
    val dealID: String?,
    val retailPrice: String?,
    val salePrice: String?,
    val storeID: String?
): Serializable

data class CheapestPriceEntity(
    val date: Long?,
    val price: String?
): Serializable

data class GameInfoEntity(
    val gameID: String?,
    val metacriticLink: String?,
    val metacriticScore: String?,
    val name: String?,
    val publisher: String?,
    val releaseDate: Long,
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

fun DealDetailResponse.toEntity(): DealDetailEntity {
    return DealDetailEntity(
        cheaperStores = cheaperStores?.map { it.toEntity() },
        cheapestPrice = cheapestPrice?.toEntity(),
        gameInfo = gameInfo?.toEntity()
    )
}

fun CheaperStoreResponse.toEntity(): CheaperStoreEntity {
    return CheaperStoreEntity(
        dealID = dealID,
        retailPrice = retailPrice,
        salePrice = salePrice,
        storeID = storeID
    )
}

fun GameInfoResponse.toEntity(): GameInfoEntity {
    return GameInfoEntity(
        gameID = gameID,
        metacriticLink = URLDecoder.decode(metacriticLink ?: "", "UTF-8"),
        metacriticScore = metacriticScore,
        name = name,
        publisher = publisher,
        releaseDate = (releaseDate ?: 0) * 1000,
        retailPrice = retailPrice,
        salePrice = salePrice,
        steamAppID = steamAppID,
        steamRatingCount = steamRatingCount,
        steamRatingPercent = steamRatingPercent,
        steamRatingText = steamRatingText,
        steamworks = steamworks,
        storeID = storeID,
        thumb = thumb
    )
}

fun CheapestPriceResponse.toEntity(): CheapestPriceEntity {
    return CheapestPriceEntity(
        date = date, price = price
    )
}