package com.testrail.api.add_results_for_cases;

import com.testrail.api.beans.results.TestStatus;
import com.testrail.api.beans.results.add_result_for_case.AddResultForCaseResponse;
import com.testrail.api.beans.results.add_results_for_cases.AddResultsForCasesRequest;
import com.testrail.api.beans.runs.add_run.AddRunRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.List;

import static com.testrail.api.TestRailApi.addResultsForCases;
import static com.testrail.api.TestRailApi.addRun;
import static com.testrail.api.beans.results.TestStatus.BLOCKED;
import static com.testrail.api.beans.results.TestStatus.FAILED;
import static com.testrail.api.beans.results.TestStatus.PASSED;
import static com.testrail.api.beans.results.TestStatus.RETEST;
import static com.testrail.api.beans.results.add_result_for_case.AddResultForCaseRequest.newBuilder;
import static com.testrail.data.provider.TestProjectDataProvider.PROJECT_ID;
import static com.testrail.data.provider.TestProjectDataProvider.getCaseIds;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

@Title("add_results_for_cases")
@Description("Добавление результатов тест рана с несколькими кейсами")
@RunWith(Parameterized.class)
public class AddResultsForCasesStatusTest {
    private static final List<Integer> cases = getCaseIds();

    private Integer runId;

    @Parameterized.Parameter
    public TestStatus status;

    @Parameterized.Parameters(name = "status {0}")
    public static Object[] testStatuses() {
        return new Object[][]{{PASSED}, {BLOCKED}, {FAILED}, {RETEST}};
    }

    @Before
    public void addNewRun() {
        assumeThat(cases, hasSize(greaterThan(1)));
        runId = addRun(PROJECT_ID, AddRunRequest.newBuilder().build()).getId();
    }

    @Test
    @Description("Смена статуса кейсов при добавлении результата тест рана")
    public void testChangeStatus() {
        List<AddResultForCaseResponse> results =
                addResultsForCases(runId, AddResultsForCasesRequest.newBuilder().withResults(
                        asList(
                                newBuilder().withStatusId(PASSED).withCaseId(cases.get(0)).build(),
                                newBuilder().withStatusId(status).withCaseId(cases.get(1)).build()
                        )
                ).build());

        assertThat(results.stream().map(r -> r.getStatusId()).collect(toList()), hasItems(PASSED, status));
    }
}
