package com.testrail.data.provider;

import java.util.List;

import static java.util.Arrays.asList;

public class TestProjectDataProvider {
    public final static int PROJECT_ID = 1;
    public final static int DEFAULT_MILESTONE_ID = 1;
    public final static String CUSTOM_RESULT_MILESTONE_SYSTEM_NAME = "milestone_tested_id";

    public static List<Integer> getCaseIds() {
        return asList(1, 2);
    }
}
