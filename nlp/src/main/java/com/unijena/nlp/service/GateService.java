package com.unijena.nlp.service;

import gate.AnnotationSet;
import gate.CorpusController;
import gate.Document;
import gate.util.GateException;

import java.io.IOException;

public interface GateService {

    AnnotationSet getAnnieAnnotations(String key) throws GateException, IOException;
    AnnotationSet getBioDivTaggerAnnotations(String key) throws GateException, IOException;
    AnnotationSet getOTAnnotations(String key) throws GateException, IOException;
    Document getDocument(String key, CorpusController application) throws GateException, IOException;

}
