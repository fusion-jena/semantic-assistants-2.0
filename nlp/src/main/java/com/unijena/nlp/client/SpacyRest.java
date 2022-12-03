package com.unijena.nlp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "spacy", url = "http://127.0.0.1:5000")
public interface SpacyRest {
    @RequestMapping(method = RequestMethod.GET, value = "/spacy?text={text}", consumes = "application/json")
    String getAnnotation(@PathVariable("text") String text);
}
