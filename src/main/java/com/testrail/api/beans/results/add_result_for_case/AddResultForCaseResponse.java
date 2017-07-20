package com.testrail.api.beans.results.add_result_for_case;

import com.google.gson.annotations.SerializedName;
import com.testrail.api.beans.results.TestStatus;

public class AddResultForCaseResponse {

    @SerializedName("test_id")
    private Integer caseId;

    @SerializedName("status_id")
    private TestStatus statusId;

    private String comment;
    private String version;
    private String defects;
    private String elapsed;

    @SerializedName("assignedto_id")
    private Integer assignedtoId;

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

    public String getElapsed() {
        return elapsed;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }
}
