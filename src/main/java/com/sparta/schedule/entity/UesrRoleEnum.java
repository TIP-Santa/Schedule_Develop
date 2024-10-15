package com.sparta.schedule.entity;

public enum UesrRoleEnum {
    USER(Authority.USER),
    ADMIN(Authority.ADMIN);

    private final String authority;

    UesrRoleEnum(String authority) {
        this.authority = authority;
    }
    public String getAuthority() {
        return authority;

    }
    public static class Authority{
        public static final String USER = "USER";
        public static final String ADMIN = "ADMIN";
    }
}