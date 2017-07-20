package com.testrail.api.beans.results.add_result_for_case;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.testrail.api.beans.results.TestStatus;

public class AddResultForCaseRequest {

    @SerializedName("case_id")
    private Integer caseId;

    @SerializedName("status_id")
    private TestStatus statusId;

    private String comment;
    private String version;
    private String elapsed;
    private String defects;

    @SerializedName("assignedto_id")
    private Integer assignedtoId;

    private AddResultForCaseRequest(Builder builder) {
        setCaseId(builder.caseId);
        setStatusId(builder.statusId);
        setComment(builder.comment);
        setVersion(builder.version);
        setElapsed(builder.elapsed);
        setDefects(builder.defects);
        setAssignedtoId(builder.assignedtoId);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public TestStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(TestStatus statusId) {
        this.statusId = statusId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getElapsed() {
        return elapsed;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }

    public String getDefects() {
        return defects;
    }

    public void setDefects(String defects) {
        this.defects = defects;
    }

    public Integer getAssignedtoId() {
        return assignedtoId;
    }

    public void setAssignedtoId(Integer assignedtoId) {
        this.assignedtoId = assignedtoId;
    }

    public static final class Builder {
        private Integer caseId;
        private TestStatus statusId;
        private String comment;
        private String version;
        private String elapsed;
        private String defects;
        private Integer assignedtoId;

        private Builder() {
        }

        public Builder withCaseId(Integer val) {
            caseId = val;
            return this;
        }

        public Builder withStatusId(TestStatus val) {
            statusId = val;
            return this;
        }

        public Builder withComment(String val) {
            comment = val;
            return this;
        }

        public Builder withVersion(String val) {
            version = val;
            return this;
        }

        public Builder withElapsed(String val) {
            elapsed = val;
            return this;
        }

        public Builder withDefects(String val) {
            defects = val;
            return this;
        }

        public Builder withAssignedtoId(Integer val) {
            assignedtoId = val;
            return this;
        }

        public JsonObject toJsonWithCustom(String id, Number value) {
            JsonObject obj = new Gson().toJsonTree(build()).getAsJsonObject();
            obj.addProperty("custom_" + id, value);
            return obj;
        }

        public AddResultForCaseRequest build() {
            return new AddResultForCaseRequest(this);
        }
    }
}
