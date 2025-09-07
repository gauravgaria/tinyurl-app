package com.tinyurl.app.service.service;

import com.tinyurl.app.service.model.Url;
import com.tinyurl.app.service.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public Url createUrl(Url url) {
        return urlRepository.save(url);
    }

    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    public Optional<Url> getUrlById(Long id) {
        return urlRepository.findById(id);
    }

    public Optional<Url> getUrlByShortUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }

    public Url updateUrl(Long id, Url urlDetails) {
        Url url = urlRepository.findById(id).orElseThrow(() -> new RuntimeException("URL not found"));
        url.setShortUrl(urlDetails.getShortUrl());
        url.setOriginalUrl(urlDetails.getOriginalUrl());
        return urlRepository.save(url);
    }

    public void deleteUrl(Long id) {
        urlRepository.deleteById(id);
    }
}
