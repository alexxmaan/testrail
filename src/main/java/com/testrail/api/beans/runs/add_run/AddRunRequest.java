package com.testrail.api.beans.runs.add_run;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddRunRequest {

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

    private AddRunRequest(Builder builder) {
        setSuiteId(builder.suiteId);
        setName(builder.name);
        setDescription(builder.description);
        setMilestoneId(builder.milestoneId);
        setAssignedtoId(builder.assignedtoId);
        setIncludeAll(builder.includeAll);
        setCaseIds(builder.caseIds);
    }

    public static Builder newBuilder() {
        return new Builder();
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

    public static final class Builder {
        private Integer suiteId;
        private String name;
        private String description;
        private Integer milestoneId;
        private Integer assignedtoId;
        private Boolean includeAll;
        private List<Integer> caseIds;

        private Builder() {
        }

        public Builder withSuiteId(Integer val) {
            suiteId = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withMilestoneId(Integer val) {
            milestoneId = val;
            return this;
        }

        public Builder withAssignedtoId(Integer val) {
            assignedtoId = val;
            return this;
        }

        public Builder withIncludeAll(Boolean val) {
            includeAll = val;
            return this;
        }

        public Builder withCaseIds(List<Integer> val) {
            caseIds = val;
            return this;
        }

        public AddRunRequest build() {
            return new AddRunRequest(this);
        }
    }
}
