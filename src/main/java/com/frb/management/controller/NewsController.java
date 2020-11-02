package com.frb.management.controller;

import com.frb.management.model.News;
import com.frb.management.repository.NewsRepository;
import com.frb.management.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<News>> getNews() {
        List<News> all = newsService.getNews();
        return new ResponseEntity<List<News>>(all,  HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<News> create(@RequestBody News news){
        News saved = newsService.save(news);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
}
