package com.testrail.api.add_result_for_case;

import com.testrail.api.beans.results.add_result_for_case.AddResultForCaseRequest;
import com.testrail.api.beans.runs.add_run.AddRunRequest;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static com.testrail.api.TestRailApi.addResultForCase;
import static com.testrail.api.TestRailApi.addRun;
import static com.testrail.api.beans.results.add_result_for_case.AddResultForCaseRequest.newBuilder;
import static com.testrail.data.provider.TestProjectDataProvider.PROJECT_ID;
import static com.testrail.data.provider.TestProjectDataProvider.getCaseIds;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Title("add_result_for_case")
@Description("Добавление результата тест рана для кейса")
public class AddResultForCaseTest {

    private final Integer caseId = getCaseIds().get(0);
    private Integer runId;
    private final AddResultForCaseRequest.Builder result = newBuilder().withComment("test");


    @Before
    public void addNewRun() {
        runId = addRun(PROJECT_ID, AddRunRequest.newBuilder().build()).getId();
    }

    @Test
    @Title("version")
    @Description("Добавление результата с версией")
    public void testVersion() {
        final String version = "0.123456";
        assertThat(addResultForCase(runId, caseId, result.withVersion(version).build()).getVersion(), is(version));
    }

    @Test
    @Title("comment")
    @Description("Добавление результата с комментарием")
    public void testComment() {
        final String comment = "test comment";
        assertThat(addResultForCase(runId, caseId, result.withComment(comment).build()).getComment(), is(comment));
    }

    @Test
    @Title("defects")
    @Description("Добавление результата с дефектами")
    public void testDefects() {
        final String defects = "BUG-1,BUG-2";
        assertThat(addResultForCase(runId, caseId, result.withDefects(defects).build()).getDefects(), is(defects));
    }

    @Test
    @Title("elapsed")
    @Description("Добавление результата с затраченным временем")
    public void testElapsed() {
        final String time = "1m";
        assertThat(addResultForCase(runId, caseId, result.withElapsed(time).build()).getElapsed(), is(time));
    }
}
