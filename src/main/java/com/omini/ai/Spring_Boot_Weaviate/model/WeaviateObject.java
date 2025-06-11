package com.omini.ai.Spring_Boot_Weaviate.model;

import lombok.Data;
import java.util.Map;

@Data
public class WeaviateObject {
    private String id;
    private String className;
    private Map<String, Object> properties;
}
