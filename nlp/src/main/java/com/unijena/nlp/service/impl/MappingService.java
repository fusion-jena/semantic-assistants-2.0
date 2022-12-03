package com.unijena.nlp.service.impl;
import gate.Annotation;
import gate.AnnotationSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MappingService {
    public List<Annotation> mapGateAnnie(AnnotationSet annotations) {
        String[] values = {"Person","Date","Organization","Location"};
        return mapGate(annotations, values);
    }
    public List<Annotation> mapGateOT(AnnotationSet annotations) {
        String[] values = {"Organism"};
        return mapGate(annotations, values);
    }
   public List<Annotation> mapGateBT(AnnotationSet annotations) {
        String[] values = {"Process","Material","Quality","Environment"};
        return mapGate(annotations, values);
    }
    public List<Annotation> mapGate(AnnotationSet annotations, String[] values) {
        List<Annotation> finalAnnotations = new ArrayList<>();
        for (Annotation annotation : annotations) {
            if (Arrays.stream(values).anyMatch(annotation.getType()::equals)) {
                finalAnnotations.add(annotation);
            }
        }
        return finalAnnotations;
    }
}