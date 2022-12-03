package com.unijena.nlp.client;

import com.unijena.nlp.model.bern.BernRequestModel;
import com.unijena.nlp.model.bern.BernResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "bern", url = "https://bern.korea.ac.kr/plain")
public interface BernRest {
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    BernResponseModel getAnnotation(BernRequestModel text);
}
