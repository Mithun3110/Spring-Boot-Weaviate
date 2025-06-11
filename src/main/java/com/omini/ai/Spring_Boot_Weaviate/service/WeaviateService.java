package com.omini.ai.Spring_Boot_Weaviate.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omini.ai.Spring_Boot_Weaviate.model.WeaviateObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeaviateService {

    private static final String WEAVIATE_URL = "http://localhost:8080/v1/objects";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ResponseEntity<String> createObject(WeaviateObject obj) {
        try {
            // Build the full payload as a Map
            Map<String, Object> payload = new HashMap<>();
            payload.put("id", obj.getId());
            payload.put("class", obj.getClassName());
            payload.put("properties", obj.getProperties());

            // Convert the payload Map to JSON string
            String json = objectMapper.writeValueAsString(payload);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> request = new HttpEntity<>(json, headers);
            return restTemplate.exchange(WEAVIATE_URL, HttpMethod.POST, request, String.class);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to serialize request: " + e.getMessage());
        }
    }

    public ResponseEntity<String> getObject(String id) {
        return restTemplate.getForEntity(WEAVIATE_URL + "/" + id, String.class);
    }
}
