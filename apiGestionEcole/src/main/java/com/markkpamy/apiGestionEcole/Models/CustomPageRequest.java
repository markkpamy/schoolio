package com.markkpamy.apiGestionEcole.Models;

import java.util.List;

public class CustomPageRequest {
    private int page;
    private int size;
    private List<Filter> filters;

    public CustomPageRequest() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

}
