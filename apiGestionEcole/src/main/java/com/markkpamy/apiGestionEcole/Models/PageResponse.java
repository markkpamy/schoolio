package com.markkpamy.apiGestionEcole.Models;

import java.util.List;

public class PageResponse<T> extends PaginatedResponse {

    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
