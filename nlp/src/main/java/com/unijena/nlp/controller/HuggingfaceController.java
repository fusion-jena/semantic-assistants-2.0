package com.unijena.nlp.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unijena.nlp.client.HuggingfaceRest;
import com.unijena.nlp.model.huggingface.HuggingFaceResponseModel;
import com.unijena.nlp.utility.RequestValidation;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/huggingface")
public class HuggingfaceController {

    HuggingfaceRest service;
    ObjectMapper objectMapper;

    public HuggingfaceController(HuggingfaceRest service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @ApiOperation(value = "View a list of annotations of Huggingface service", response = HuggingFaceResponseModel.class)
    @GetMapping("/{term}")
    ResponseEntity<List<HuggingFaceResponseModel>> getAnnotation(@PathVariable String term) throws JsonProcessingException {
        RequestValidation.checkRequestLimit();
        RequestValidation.checkTermLength(term);
        String annotations = this.service.getAnnotation(term);
        List<HuggingFaceResponseModel> response = objectMapper.readValue(annotations, new TypeReference<List<HuggingFaceResponseModel>>() {});
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
