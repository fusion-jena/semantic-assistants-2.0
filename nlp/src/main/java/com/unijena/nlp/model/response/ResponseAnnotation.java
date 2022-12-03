package com.unijena.nlp.model.response;

public class ResponseAnnotation {
    private String type;
    private Long startNode;
    private Long endNode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStartNode() {
        return startNode;
    }

    public void setStartNode(Long startNode) {
        this.startNode = startNode;
    }

    public Long getEndNode() {
        return endNode;
    }

    public void setEndNode(Long endNode) {
        this.endNode = endNode;
    }

    @Override
    public String toString() {
        return "ResponseAnnotation{" +
                "type='" + type + '\'' +
                ", startNode=" + startNode +
                ", endNode=" + endNode +
                '}';
    }
}
