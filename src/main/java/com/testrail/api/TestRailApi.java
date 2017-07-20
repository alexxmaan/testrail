package com.testrail.api;

import com.testrail.api.beans.results.add_result_for_case.AddResultForCaseRequest;
import com.testrail.api.beans.results.add_result_for_case.AddResultForCaseResponse;
import com.testrail.api.beans.results.add_results_for_cases.AddResultsForCasesRequest;
import com.testrail.api.beans.runs.add_run.AddRunRequest;
import com.testrail.api.beans.runs.add_run.AddRunResponse;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

public class TestRailApi {

    @Step("Execute add_result_for_case for run {0} and case {1}")
    public static AddResultForCaseResponse addResultForCase(Integer runId, Integer caseId, AddResultForCaseRequest result) {
        return TestRailApiClientFactory.defaultClient().sendPost(RelativePath.addResultForCasePath(runId, caseId), result, AddResultForCaseResponse.class);
    }

    @Step("Execute add_results_for_cases for run {0}")
    public static List<AddResultForCaseResponse> addResultsForCases(Integer runId, AddResultsForCasesRequest results) {
        return Arrays.asList(TestRailApiClientFactory.defaultClient().sendPost(RelativePath.addResultsForCasesPath(runId), results, AddResultForCaseResponse[].class));
    }

    @Step("Execute add_run for project {0}")
    public static AddRunResponse addRun(Integer projectId, AddRunRequest run) {
        return TestRailApiClientFactory.defaultClient().sendPost(RelativePath.addRunPath(projectId), run, AddRunResponse.class);
    }
}
