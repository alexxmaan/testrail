package com.testrail.api;

public enum Params {

    ADD_RUN,
    ADD_RESULT_FOR_CASE,
    ADD_RESULTS_FOR_CASES;

    private final String value;

    Params() {
        this.value = name().toLowerCase();
    }

    Params(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
