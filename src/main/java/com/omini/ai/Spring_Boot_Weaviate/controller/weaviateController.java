package com.omini.ai.Spring_Boot_Weaviate.controller;

import com.omini.ai.Spring_Boot_Weaviate.model.WeaviateObject;
import com.omini.ai.Spring_Boot_Weaviate.service.WeaviateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weaviate")
public class WeaviateController {

    @Autowired
    private WeaviateService weaviateService;

    @PostMapping("/add")
    public ResponseEntity<String> addObject(@RequestBody WeaviateObject obj) {
        return weaviateService.createObject(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getObject(@PathVariable String id) {
        return weaviateService.getObject(id);
    }
}
