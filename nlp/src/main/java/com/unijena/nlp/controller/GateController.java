package com.unijena.nlp.controller;
import com.unijena.nlp.model.response.ServiceResponse;
import com.unijena.nlp.service.GateService;
import com.unijena.nlp.service.impl.MappingService;
import com.unijena.nlp.utility.RequestValidation;
import gate.Annotation;
import gate.AnnotationSet;
import gate.util.GateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/gate")
@Api(value = "Gate controller", description = "Gate controller (Annie, BioTagger, OrganismTagger)")
public class GateController {

    GateService service;
    MappingService mappingService;

    public GateController(GateService service, MappingService mappingService) {
        this.service = service;
        this.mappingService = mappingService;
    }

    @ApiOperation(value = "View a list of annotations of Annie", response = AnnotationSet.class)
    @CrossOrigin(origins = "*")
	@GetMapping("/annie/{term}")
    ResponseEntity<List<Annotation>> getAnnieAnnotation(@PathVariable String term) throws IOException, GateException {
        RequestValidation.checkRequestLimit();
        RequestValidation.checkTermLength(term);
        List<Annotation> finalAnnotations = mappingService.mapGateAnnie(this.service.getAnnieAnnotations(term));
        return ResponseEntity.status(HttpStatus.OK).body(finalAnnotations);
    }

    @ApiOperation(value = "View a list of annotations of Bio Tagger", response = AnnotationSet.class)
    @CrossOrigin(origins = "*")
    @GetMapping("/bioTagger/{term}")
    ResponseEntity<List<Annotation>> getBioTaggerAnnotation(@PathVariable String term) throws IOException, GateException {
        RequestValidation.checkRequestLimit();
//        RequestValidation.checkTermLength(term);
        List<Annotation> finalAnnotations = mappingService.mapGateBT(this.service.getBioDivTaggerAnnotations(term));
        return ResponseEntity.status(HttpStatus.OK).body(finalAnnotations);
    }
    @ApiOperation(value = "View a list of annotations of Organism Tagger", response = AnnotationSet.class)
    @CrossOrigin(origins = "*")
    @GetMapping("/organismTagger/{term}")
    ResponseEntity<List<Annotation>> getOTAnnotation(@PathVariable String term) throws IOException, GateException {
        RequestValidation.checkRequestLimit();
      //  RequestValidation.checkTermLength(term);
        List<Annotation> finalAnnotations = mappingService.mapGateOT(this.service.getOTAnnotations(term));
        return ResponseEntity.status(HttpStatus.OK).body(finalAnnotations);
    }
    @ApiOperation(value = "View a list of annotations of Organism Tagger and Bio Tagger", response = AnnotationSet.class)
    @CrossOrigin(origins = "*")
    @GetMapping("/OTPlusBT/{term}")
    ResponseEntity<List<Annotation>> getOTAndBTAnnotation(@PathVariable String term) throws IOException, GateException {
        RequestValidation.checkRequestLimit();
        RequestValidation.checkTermLength(term);
        List<Annotation> OTAnnotations = mappingService.mapGateOT(this.service.getOTAnnotations(term));
        List<Annotation> BTAnnotations = mappingService.mapGateBT(this.service.getBioDivTaggerAnnotations(term));
        return ResponseEntity.status(HttpStatus.OK).body(Stream.concat(OTAnnotations.stream(), BTAnnotations.stream())
                .collect(Collectors.toList()));
    }
}
