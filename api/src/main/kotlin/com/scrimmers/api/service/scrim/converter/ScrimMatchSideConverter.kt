package com.scrimmers.api.service.scrim.converter

import com.scrimmers.api.dto.scrim.match.side.CreateScrimMatchSideRequestDto
import com.scrimmers.api.dto.scrim.match.side.ScrimMatchSideResponseDto
import com.scrimmers.api.service.team.converter.TeamConverter
import com.scrimmers.domain.entity.team.scrim.match.ScrimMatchWinnerSide
import com.scrimmers.domain.entity.team.scrim.match.side.ScrimMatchSide
import com.scrimmers.domain.entity.team.scrim.match.side.ScrimMatchSideType
import io.hypersistence.tsid.TSID
import org.springframework.stereotype.Component

@Component
class ScrimMatchSideConverter(
    private val teamConverter: TeamConverter,
) {

    fun convertBlueTeam(request: CreateScrimMatchSideRequestDto): ScrimMatchSide {
        return ScrimMatchSide(
            id = TSID.fast().toString(),
            side = ScrimMatchSideType.BLUE,
            killScore = request.killScore,
            totalGold = request.totalGold
        )
    }

    fun convertRedTeam(request: CreateScrimMatchSideRequestDto): ScrimMatchSide {
        return ScrimMatchSide(
            id = TSID.fast().toString(),
            side = ScrimMatchSideType.RED,
            killScore = request.killScore,
            totalGold = request.totalGold
        )
    }

    fun convert(entity: ScrimMatchSide, winnerSide: ScrimMatchWinnerSide): ScrimMatchSideResponseDto {
        return ScrimMatchSideResponseDto(
            id = entity.id,
            team = teamConverter.convert(entity.team!!),
            side = entity.side,
            killScore = entity.killScore,
            totalGold = entity.totalGold,
            isWinSide = entity.side.name.equals(winnerSide.name),
            createdAt = entity.createdAt!!.toInstant().toEpochMilli(),
            updatedAt = entity.updatedAt!!.toInstant().toEpochMilli()
        )
    }
}