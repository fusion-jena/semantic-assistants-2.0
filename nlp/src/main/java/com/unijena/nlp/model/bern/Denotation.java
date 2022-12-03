package com.unijena.nlp.model.bern;

import java.util.List;

public class Denotation {
    private List<String> id;
    private String obj;
    private Span span;

    public List<String> getId() {
        return id;
    }

    public void setId(List<String> id) {
        this.id = id;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public Span getSpan() {
        return span;
    }

    public void setSpan(Span span) {
        this.span = span;
    }
}
