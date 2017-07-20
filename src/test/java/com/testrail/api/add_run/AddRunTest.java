package com.testrail.api.add_run;

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static com.testrail.api.TestRailApi.addRun;
import static com.testrail.api.beans.runs.add_run.AddRunRequest.newBuilder;
import static com.testrail.data.provider.TestProjectDataProvider.DEFAULT_MILESTONE_ID;
import static com.testrail.data.provider.TestProjectDataProvider.PROJECT_ID;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Title("add_run")
@Description("Запуск нового тест рана")
public class AddRunTest {

    @Test
    @Title("name")
    @Description("Добавление тест рана с именем")
    public void testRunNameField() {
        assertThat(addRun(PROJECT_ID, newBuilder().withName("test").build()).getName(), is("test"));
    }

    @Test
    @Title("milestone_id")
    @Description("Добавление тест рана с milestone")
    public void testRunMilestoneField() {
        assertThat(
                addRun(PROJECT_ID, newBuilder().withMilestoneId(DEFAULT_MILESTONE_ID).build()).getMilestoneId(),
                is(DEFAULT_MILESTONE_ID)
        );
    }
}
