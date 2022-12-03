package com.unijena.nlp.controller;
import com.unijena.nlp.client.BernRest;
import com.unijena.nlp.model.bern.BernRequestModel;
import com.unijena.nlp.model.bern.BernResponseModel;
import com.unijena.nlp.utility.RequestValidation;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bern")
public class BernController {
    BernRest service;

    public BernController(BernRest service) {
        this.service = service;
    }

    @ApiOperation(value = "View a list of annotations of Bern service", response = BernResponseModel.class)
    @GetMapping("/{term}")
    ResponseEntity<BernResponseModel> getAnnotation(@PathVariable String term){
        RequestValidation.checkRequestLimit();
        RequestValidation.checkTermLength(term);
        BernRequestModel text = new BernRequestModel(term);
        BernResponseModel response = service.getAnnotation(text);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
