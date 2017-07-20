package com.testrail.api.beans.results.add_results_for_cases;

import com.testrail.api.beans.results.add_result_for_case.AddResultForCaseRequest;

import java.util.List;

public class AddResultsForCasesRequest {
    private List<AddResultForCaseRequest> results;

    private AddResultsForCasesRequest(Builder builder) {
        setResults(builder.results);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public List<AddResultForCaseRequest> getResults() {
        return results;
    }

    public void setResults(List<AddResultForCaseRequest> results) {
        this.results = results;
    }

    public static final class Builder {
        private List<AddResultForCaseRequest> results;

        private Builder() {
        }

        public Builder withResults(List<AddResultForCaseRequest> val) {
            results = val;
            return this;
        }

        public AddResultsForCasesRequest build() {
            return new AddResultsForCasesRequest(this);
        }
    }
}
