package com.frb.management.service;

import com.frb.management.model.News;
import com.frb.management.repository.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getNews(){
        return newsRepository.findAll();
    }


    public News save(News news) {
        return newsRepository.save(news);
    }

    public void savePicture(MultipartFile multipartFile){
        Path picturePath = Paths.get("C:/frb/upload/news/pictures/");
        try {
            Files.createDirectories(picturePath);
            Files.copy(multipartFile.getInputStream(),
                    picturePath.resolve((multipartFile.getOriginalFilename())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
