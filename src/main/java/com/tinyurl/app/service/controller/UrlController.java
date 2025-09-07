package com.tinyurl.app.service.controller;

import com.tinyurl.app.service.model.Url;
import com.tinyurl.app.service.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urls")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping
    public ResponseEntity<Url> createUrl(@RequestBody Url url) {
        return ResponseEntity.ok(urlService.createUrl(url));
    }

    @GetMapping
    public ResponseEntity<List<Url>> getAllUrls() {
        return ResponseEntity.ok(urlService.getAllUrls());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Url> getUrlById(@PathVariable Long id) {
        return urlService.getUrlById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/short/{shortUrl}")
    public ResponseEntity<Url> getUrlByShortUrl(@PathVariable String shortUrl) {
        return urlService.getUrlByShortUrl(shortUrl)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Url> updateUrl(@PathVariable Long id, @RequestBody Url urlDetails) {
        return ResponseEntity.ok(urlService.updateUrl(id, urlDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUrl(@PathVariable Long id) {
        urlService.deleteUrl(id);
        return ResponseEntity.noContent().build();
    }
}
