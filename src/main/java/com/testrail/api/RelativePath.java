package com.testrail.api;

public class RelativePath {

    private String resource;

    public RelativePath(String format, Object... args) {
        this.resource = String.format(format, args);
    }

    public static RelativePath addResultForCasePath(Integer runId, Integer caseId) {
        return new RelativePath(Params.ADD_RESULT_FOR_CASE + "/%d/%d", runId, caseId);
    }

    public static RelativePath addResultsForCasesPath(Integer runId) {
        return new RelativePath(Params.ADD_RESULTS_FOR_CASES + "/%d", runId);
    }

    public static RelativePath addRunPath(Integer projectId) {
        return new RelativePath(Params.ADD_RUN + "/%d", projectId);
    }

    @Override
    public String toString() {
        return resource;
    }
}
