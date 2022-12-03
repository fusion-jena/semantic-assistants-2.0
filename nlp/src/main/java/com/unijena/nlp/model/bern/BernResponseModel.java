package com.unijena.nlp.model.bern;

import java.util.List;

public class BernResponseModel {
    private List<Denotation> denotations;

    public List<Denotation> getDenotations() {
        return denotations;
    }

    public void setDenotations(List<Denotation> denotations) {
        this.denotations = denotations;
    }
}
