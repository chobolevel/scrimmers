package com.scrimmers.domain.exception

enum class ErrorCode(val desc: String) {
    UNKNOWN_ERROR("알 수 없는 에러입니다."),
    PARAMETER_INVALID("잘못된 파라미터입니다."),

    // AUTH
    BAD_CREDENTIALS("사용자 인증에 실패하였습니다."),
    UNAUTHORIZED("인증되지 않은 사용자입니다."),
    FORBIDDEN("엑세스 권한 없음"),

    // JWT
    EXPIRED_TOKEN("만료된 토큰입니다."),
    INVALID_TOKEN("유효하지 않은 토큰입니다."),

    // USER
    USER_IS_NOT_FOUND("회원을 찾을 수 없습니다."),
    USER_EMAIL_IS_INCORRECT_FORMAT("이메일 형식이 올바르지 않습니다."),
    USER_EMAIL_IS_ALREADY_EXISTS("이미 존재하는 이메일입니다."),
    USER_NICKNAME_IS_INCORRECT_FORMAT("닉네임 형식이 올바르지 않습니다.(한글 2~20자)"),
    USER_NICKNAME_IS_ALREADY_EXISTS("이미 존재하는 닉네임입니다."),
    USER_PHONE_IS_INCORRECT_FORMAT("전화번호 형식이 올바르지 않습니다.(하이픈 제외)"),
    USER_PHONE_IS_ALREADY_EXISTS("이미 존재하는 전화번호입니다."),
    USER_CURRENT_PASSWORD_NOT_MATCHED("기존 비밀번호가 일치하지 않습니다."),

    // USER IMAGE
    USER_IMAGE_IS_NOT_FOUND("회원 이미지를 찾을 수 없습니다."),

    // USER SUMMONER
    USER_SUMMONER_IS_NOT_FOUND("회원 소환사 정보를 찾을 수 없습니다."),
    ONLY_ACCESS_FOR_USER_SUMMONER_OWNER("회원 소환사 정보를 등록한 회원만 접근할 수 있습니다."),
    USER_SUMMONER_IS_ALREADY_EXISTS("이미 다른 회원이 등록한 소환사 정보입니다."),

    // TEAM
    TEAM_IS_NOT_FOUND("팁을 찾을 수 없습니다."),
    NO_ACCESS_EXCEPT_FOR_OWNER("팁장 외 접근 불가"),
    TEAM_MAX_HEAD_COUNT_IS_OVER("팀 최대 인원이 찼습니다."),

    // TEAM IMAGE
    TEAM_IMAGE_IS_NOT_FOUND("팀 이미지를 찾을 수 없습니다."),

    // TEAM JOIN REQUEST
    NO_ACCESS_EXCEPT_FOR_REQUESTER("요청자 외 접근 불가"),
    TEAM_JOIN_REQUEST_IS_NOT_FOUND("팀 합류 요청을 찾을 수 없습니다."),
    TEAM_JOIN_REQUEST_IS_ALREADY_PROCESSED("이미 처리된 팀 합류 요청입니다."),

    // TEAM LEAVE REQUEST
    TEAM_LEAVE_REQUEST_IS_ONLY_FOR_TEAM_MEMBER("팀 탈퇴 요청은 팀원만 가능합니다."),
    TEAM_LEAVE_REQUEST_IS_NOT_FOUND("팀 탈퇴 요청을 찾을 수 없습니다."),
    TEAM_LEAVE_REQUEST_IS_ALREADY_PROCESSED("이미 처리된 팀 탈퇴 요청입니다."),

    // SCRIM
    SCRIM_IS_NOT_FOUND("스크림 정보를 찾을 수 없습니다."),
    NO_ACCESS_EXCEPT_FOR_FORM_TEAM_AND_TO_TEAM("스크림 요청 및 요청 받은 팀의 스크림 생성만 가능합니다."),

    // SCRIM REQUEST
    SCRIM_REQUEST_IS_NOT_FOUND("스크림 요청을 찾을 수 없습니다."),
    SCRIM_REQUEST_IS_ALREADY_PROCESSED("이미 처리된 스크림 요청입니다."),

    // SCRIM MATCH
    SCRIM_MATCH_IS_NOT_FOUND("스크림 매치 정보를 찾을 수 없습니다."),
    CAN_NOT_OVER_BEST_OF_COUNT("다전제 횟수를 초과하여 매치를 등록할 수 없습니다.")
}
