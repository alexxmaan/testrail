package com.testrail.api.beans.results;

import com.google.gson.annotations.SerializedName;

public enum TestStatus {
    @SerializedName("1")
    PASSED,

    @SerializedName("2")
	BLOCKED,

    @SerializedName("3")
	UNTESTED,

    @SerializedName("4")
	RETEST,

    @SerializedName("5")
	FAILED
}
