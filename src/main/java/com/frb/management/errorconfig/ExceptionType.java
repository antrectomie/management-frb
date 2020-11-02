package com.frb.management.errorconfig;

public enum ExceptionType {
    PLAYER_TYPE(1, "PLAYER EXCEPTION"),
    SPORT_CLUB_TYPE(2, "SPORT_CLUB_EXCEPTION"),
    LEAGUE_TYPE(3,"LEAGUE_EXCEPTION");
    int code;
    String message;

    ExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
