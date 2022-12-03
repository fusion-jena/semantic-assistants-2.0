package com.unijena.nlp.service.impl;

import com.unijena.nlp.config.LoadPackages;
import com.unijena.nlp.service.GateService;
import gate.*;
import gate.util.GateException;
import gate.util.persistence.PersistenceManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Set;

@Service
public class GateServiceImpl implements GateService {

    LoadPackages loadPackages;

    public GateServiceImpl(LoadPackages loadPackages) {
        this.loadPackages = loadPackages;
    }

    public Document getDocument(String key, CorpusController application) throws GateException{
        Document doc = Factory.newDocument(key);
        Corpus corpus = Factory.newCorpus("GateService");
        corpus.add(doc);
        application.setCorpus(corpus);
        application.execute();
        return doc;
    }
    public AnnotationSet getAnnieAnnotations(String key) throws IOException, GateException {
        return this.getDocument(key, loadPackages.loadAnnie()).getAnnotations();
    }

    public AnnotationSet getBioDivTaggerAnnotations(String key) throws IOException, GateException {
        return this.getDocument(key, loadPackages.loadBioTagger()).getAnnotations("BIODIV");
    }

    public AnnotationSet getOTAnnotations(String key) throws IOException, GateException {
        return this.getDocument(key, loadPackages.loadOT()).getAnnotations();
    }
}
