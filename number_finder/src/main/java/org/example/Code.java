package org.example;

public enum Code {
    OK("00.Result.OK"),
    NOT_FOUND("01.Result.NotFound"),
    ERROR("02.Result.Error");
    private final String type;

    Code(final String type) {
        this.type = type;
    }
    public static Code valueOf(final Integer position){
        return position>0?OK:position<0?NOT_FOUND:ERROR;
    }
    public String asString(){
        return this.type;
    }
}
