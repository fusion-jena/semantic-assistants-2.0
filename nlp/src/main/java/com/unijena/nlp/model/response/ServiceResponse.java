package com.unijena.nlp.model.response;
import java.util.List;

public class ServiceResponse {
    private String serviceType;
    private List<ResponseAnnotation> annotations;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public List<ResponseAnnotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<ResponseAnnotation> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return "ServiceResponse{" +
                "serviceType='" + serviceType + '\'' +
                ", annotations=" + annotations +
                '}';
    }
}
