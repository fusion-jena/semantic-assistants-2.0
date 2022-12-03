package com.unijena.nlp.model.bern;

public class BernRequestModel {
    private String sample_text;

    public BernRequestModel(String sample_text) {
        this.sample_text = sample_text;
    }

    public String getSample_text() {
        return sample_text;
    }

    public void setSample_text(String sample_text) {
        this.sample_text = sample_text;
    }
}
