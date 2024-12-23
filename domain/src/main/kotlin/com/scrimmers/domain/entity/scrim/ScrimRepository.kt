package com.scrimmers.domain.entity.scrim

import org.springframework.data.jpa.repository.JpaRepository

interface ScrimRepository : JpaRepository<Scrim, String> {

    fun findByIdAndDeletedFalse(id: String): Scrim?
}
