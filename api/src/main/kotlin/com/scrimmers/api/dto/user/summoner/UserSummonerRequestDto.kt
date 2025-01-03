package com.scrimmers.api.dto.user.summoner

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.scrimmers.domain.entity.user.summoner.SummonerRank
import com.scrimmers.domain.entity.user.summoner.UserSummonerUpdateMask
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateUserSummonerRequestDto(
    @field:NotEmpty(message = "소환사 아이디는 필수 값입니다.")
    val summonerId: String,
    @field:NotEmpty(message = "소환사명은 필수 값입니다.")
    val summonerName: String,
    @field:NotEmpty(message = "소환사명 태그는 필수 값입니다.")
    val summonerTag: String,
    @field:NotNull(message = "소환사 레벨은 필수 값입니다.")
    val summonerLevel: Int,
    @field:NotNull(message = "소환사 아이콘 경로는 필수 값입니다.")
    val summonerIconId: Int,
    val summonerSoloRank: SummonerRank?,
    val summonerFlexRank: SummonerRank?,
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UpdateUserSummonerRequestDto(
    val summonerName: String?,
    val summonerTag: String?,
    val summonerLevel: Int?,
    val summonerIconId: Int?,
    val summonerSoloRank: SummonerRank?,
    val summonerFlexRank: SummonerRank?,
    @field:Size(min = 1, message = "update_mask는 필수 값입니다.")
    val updateMask: List<UserSummonerUpdateMask>
)
