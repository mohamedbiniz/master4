package com.master4.repositories;

import com.master4.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>  {


    Page<Article> findAll(Pageable pageable); // revoie limiter les element par page


    @Query("select a from Article a left join fetch a.tagList where a.id=:id")
    Article findByIdWithTags(@Param("id") long id);





}
