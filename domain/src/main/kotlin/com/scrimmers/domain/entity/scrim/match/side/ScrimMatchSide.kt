package com.scrimmers.domain.entity.scrim.match.side

import com.scrimmers.domain.entity.BaseEntity
import com.scrimmers.domain.entity.scrim.match.ScrimMatch
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.envers.Audited

@Entity
@Table(name = "scrim_match_sides")
@Audited
class ScrimMatchSide(
    @Id
    @Column(nullable = false, updatable = false)
    var id: String,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var teamType: ScrimMatchSideTeamType,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var side: ScrimMatchSideType,
    @Column(nullable = false)
    var killScore: Int,
    @Column(nullable = false)
    var totalGold: Int,
) : BaseEntity() {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "scrim_match_id")
    var scrimMatch: ScrimMatch? = null

    @Column(nullable = false)
    var deleted: Boolean = false

    fun setBy(scrimMatch: ScrimMatch) {
        if (this.scrimMatch != scrimMatch) {
            this.scrimMatch = scrimMatch
            scrimMatch.addScrimMatchSide(this)
        }
    }

    fun delete() {
        this.deleted = true
    }
}

enum class ScrimMatchSideTeamType {
    HOME,
    AWAY
}

enum class ScrimMatchSideType {
    BLUE,
    RED
}

enum class ScrimMatchSideUpdateMask {
    KILL_SCORE,
    TOTAL_GOLD
}
