package com.unijena.nlp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unijena.nlp.client.SpacyRest;
import com.unijena.nlp.model.spacy.SpacyResponseModel;
import com.unijena.nlp.utility.RequestValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/spacy")
@Api(value = "Spacy controller", description = "Spacy controller")
public class SpacyController {

    SpacyRest service;
    ObjectMapper objectMapper;

    public SpacyController(SpacyRest service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @ApiOperation(value = "View a list of annotations of Spacy", response = SpacyResponseModel.class)
    @GetMapping("/{term}")
    ResponseEntity<List<SpacyResponseModel>> getAnnotation(@PathVariable String term) throws JsonProcessingException {
        RequestValidation.checkRequestLimit();
        RequestValidation.checkTermLength(term);
        String annotations = this.service.getAnnotation(term);
        List<SpacyResponseModel> response = objectMapper.readValue(annotations, new TypeReference<List<SpacyResponseModel>>() {});
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
