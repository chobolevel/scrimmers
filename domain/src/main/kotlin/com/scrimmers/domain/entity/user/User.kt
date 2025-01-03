package com.scrimmers.domain.entity.user

import com.scrimmers.domain.entity.BaseEntity
import com.scrimmers.domain.entity.team.Team
import com.scrimmers.domain.entity.user.image.UserImage
import com.scrimmers.domain.entity.user.summoner.UserSummoner
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.Where
import org.hibernate.envers.Audited
import java.time.LocalDate

@Entity
@Table(name = "users")
@Audited
class User(
    @Id
    @Column(nullable = false, updatable = false)
    var id: String,
    @Column(nullable = false)
    var email: String,
    @Column(nullable = true)
    var password: String? = null,
    @Column(nullable = true)
    var socialId: String? = null,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var loginType: UserLoginType,
    @Column(nullable = false)
    var nickname: String,
    @Column(nullable = false)
    var birth: LocalDate,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var gender: UserGenderType,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var role: UserRoleType
) : BaseEntity() {

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team: Team? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    var mainPosition: UserPositionType = UserPositionType.NONE

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    var subPosition: UserPositionType = UserPositionType.NONE

    @Column(nullable = false)
    var resigned: Boolean = false

    @OneToOne(mappedBy = "user", cascade = [(CascadeType.ALL)], orphanRemoval = true)
    var userImage: UserImage? = null

    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], orphanRemoval = true)
    @Where(clause = "deleted = false")
    var summoners = mutableListOf<UserSummoner>()

    fun setBy(team: Team) {
        if (this.team != team) {
            this.team = team
        }
    }

    fun leaveTeam() {
        this.team = null
    }

    fun resign() {
        this.resigned = true
    }
}

enum class UserLoginType {
    GENERAL,
    KAKAO,
    NAVER,
    GOOGLE;

    // equal to java static method
    companion object {
        fun find(value: String): UserLoginType? {
            return values().find { it.name == value }
        }
    }
}

enum class UserGenderType {
    MALE,
    FEMALE
}

enum class UserPositionType {
    NONE,
    TOP,
    JUNGLE,
    MID,
    BOTTOM,
    SUPPORT
}

enum class UserRoleType {
    ROLE_USER,
    ROLE_ADMIN
}

enum class UserOrderType {
    CREATED_AT_ASC,
    CREATED_AT_DESC,
}

enum class UserUpdateMask {
    NICKNAME,
    BIRTH,
    GENDER,
    MAIN_POSITION,
    SUB_POSITION
}
