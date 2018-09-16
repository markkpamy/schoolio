package com.markkpamy.apiGestionEcole.Models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.List;

public class CustomPageRequest implements Serializable {
    private int page;
    private int size;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Filter> filters ;


    public CustomPageRequest() {
    }

    public CustomPageRequest(int page, int size, List<Filter> filters) {
        this.page = page;
        this.size = size;
        this.filters = filters;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
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



}
