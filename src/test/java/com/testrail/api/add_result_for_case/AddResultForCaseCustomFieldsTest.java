package com.testrail.api.add_result_for_case;

import com.google.gson.JsonObject;
import com.testrail.api.beans.runs.add_run.AddRunRequest;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static com.testrail.api.RelativePath.addResultForCasePath;
import static com.testrail.api.TestRailApi.addRun;
import static com.testrail.api.TestRailApiClientFactory.defaultClient;
import static com.testrail.api.beans.results.TestStatus.PASSED;
import static com.testrail.api.beans.results.add_result_for_case.AddResultForCaseRequest.newBuilder;
import static com.testrail.data.provider.TestProjectDataProvider.CUSTOM_RESULT_MILESTONE_SYSTEM_NAME;
import static com.testrail.data.provider.TestProjectDataProvider.DEFAULT_MILESTONE_ID;
import static com.testrail.data.provider.TestProjectDataProvider.PROJECT_ID;
import static com.testrail.data.provider.TestProjectDataProvider.getCaseIds;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Title("add_result_for_case")
@Description("Добавление результата тест рана для кейса с кастомными полями")
public class AddResultForCaseCustomFieldsTest {

    private Integer runId;
    private final Integer caseId = getCaseIds().get(0);

    @Before
    public void addNewRun() {
        runId = addRun(PROJECT_ID, AddRunRequest.newBuilder().build()).getId();
    }

    @Test
    @Title("custom_milestone")
    @Description("Добавление результата с кастомным полем типа milestone")
    public void testMilestoneField() {
        final String systemName = CUSTOM_RESULT_MILESTONE_SYSTEM_NAME;
        final Integer id = DEFAULT_MILESTONE_ID;

        assertThat(
                defaultClient()
                        .sendPost(
                                addResultForCasePath(runId, caseId),
                                newBuilder().withStatusId(PASSED).toJsonWithCustom(systemName, id),
                                JsonObject.class)
                        .get("custom_" + systemName)
                        .getAsInt(),
                is(id)
        );
    }
}
