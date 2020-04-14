package com.master4.services;

import com.master4.entities.Article;
import com.master4.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ArticleService {


    public Page<Article> getAllArticles(Optional<Integer> pageNo, Integer pageSize, String sortBy);

    Article findById(long id) throws ResourceNotFoundException;

    void save(Article article);

    void deleteById(long id);

    Article findByIdWithTags(@Param("id") long id);


}
