package com.testrail.api.beans.runs.add_run;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddRunResponse {
    private Integer id;

    @SerializedName("suite_id")
    private Integer suiteId;

    private String name;
    private String description;

    @SerializedName("milestone_id")
    private Integer milestoneId;

    @SerializedName("assignedto_id")
    private Integer assignedtoId;

    @SerializedName("include_all")
    private Boolean includeAll;

    @SerializedName("case_ids")
    private List<Integer> caseIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuiteId() {
        return suiteId;
    }

    public void setSuiteId(Integer suiteId) {
        this.suiteId = suiteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Integer milestoneId) {
        this.milestoneId = milestoneId;
    }

    public Integer getAssignedtoId() {
        return assignedtoId;
    }

    public void setAssignedtoId(Integer assignedtoId) {
        this.assignedtoId = assignedtoId;
    }

    public Boolean getIncludeAll() {
        return includeAll;
    }

    public void setIncludeAll(Boolean includeAll) {
        this.includeAll = includeAll;
    }

    public List<Integer> getCaseIds() {
        return caseIds;
    }

    public void setCaseIds(List<Integer> caseIds) {
        this.caseIds = caseIds;
    }
}
