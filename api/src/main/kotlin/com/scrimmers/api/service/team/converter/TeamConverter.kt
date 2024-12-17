package com.scrimmers.api.service.team.converter

import com.scrimmers.api.dto.team.CreateTeamRequestDto
import com.scrimmers.api.dto.team.TeamResponseDto
import com.scrimmers.api.service.user.converter.UserConverter
import com.scrimmers.domain.entity.team.Team
import io.hypersistence.tsid.TSID
import org.springframework.stereotype.Component

@Component
class TeamConverter(
    private val userConverter: UserConverter
) {

    fun convert(request: CreateTeamRequestDto): Team {
        return Team(
            id = TSID.fast().toString(),
            name = request.name,
            description = request.description,
        )
    }

    fun convert(entity: Team): TeamResponseDto {
        return TeamResponseDto(
            id = entity.id,
            owner = userConverter.convert(entity.owner!!),
            name = entity.name,
            description = entity.description,
            createdAt = entity.createdAt!!.toInstant().toEpochMilli(),
            updatedAt = entity.updatedAt!!.toInstant().toEpochMilli(),
        )
    }
}
