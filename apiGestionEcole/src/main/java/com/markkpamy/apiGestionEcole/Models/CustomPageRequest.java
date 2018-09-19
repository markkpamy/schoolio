package com.markkpamy.apiGestionEcole.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

public class CustomPageRequest implements Serializable {
    private int page;
    private int size;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Filter> filters ;
    private Sort.Direction sortDirection;
    private String sortField;

    public CustomPageRequest(int page, int size, List<Filter> filters, Sort.Direction sortDirection, String sortField) {
        this.page = page;
        this.size = size;
        this.filters = filters;
        this.sortDirection = sortDirection;
        this.sortField = sortField;
    }

    public CustomPageRequest() {
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
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
