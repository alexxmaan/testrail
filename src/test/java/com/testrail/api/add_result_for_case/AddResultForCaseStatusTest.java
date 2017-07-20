package com.testrail.api.add_result_for_case;

import com.testrail.api.beans.results.TestStatus;
import com.testrail.api.beans.runs.add_run.AddRunRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static com.testrail.api.TestRailApi.addResultForCase;
import static com.testrail.api.TestRailApi.addRun;
import static com.testrail.api.beans.results.TestStatus.BLOCKED;
import static com.testrail.api.beans.results.TestStatus.FAILED;
import static com.testrail.api.beans.results.TestStatus.PASSED;
import static com.testrail.api.beans.results.TestStatus.RETEST;
import static com.testrail.api.beans.results.add_result_for_case.AddResultForCaseRequest.newBuilder;
import static com.testrail.data.provider.TestProjectDataProvider.PROJECT_ID;
import static com.testrail.data.provider.TestProjectDataProvider.getCaseIds;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Title("add_result_for_case")
@Description("Добавление результата тест рана для кейса - смена статуса")
@RunWith(Parameterized.class)
public class AddResultForCaseStatusTest {

    private Integer runId;
    private final Integer caseId = getCaseIds().get(0);

    @Parameterized.Parameter
    public TestStatus status;

    @Parameterized.Parameters(name = "status {0}")
    public static Object[] testStatuses() {
        return new Object[][]{{PASSED}, {BLOCKED}, {FAILED}, {RETEST}};
    }

    @Before
    public void addNewRun() {
        runId = addRun(PROJECT_ID, AddRunRequest.newBuilder().build()).getId();
    }

    @Test
    @Description("Добавление результата со сменой статуса")
    public void testChangeStatus() {
        assertThat(addResultForCase(runId, caseId, newBuilder().withStatusId(status).build()).getStatusId(), is(status));
    }
}
