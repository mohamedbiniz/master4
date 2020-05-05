package com.master4.repositories;

import com.master4.entities.Article;
import com.master4.entities.Role;
import com.master4.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAll(Pageable pageable);
    @Query("select a from  Article a where a.user.id=:id")
    public List<Article> getArticlesById(@Param("id") long id);
    // get the roles of a user

    // get the user by his email end password
    @Query("select u from User u where u.password =:password and u.email =:email")
    public User getUserByEmaiAndPassword(@Param("email") String email, @Param("password") String Password);
    @Query ("select u from User u where u.email=:email")
    public User getUserByEmail(@Param("email") String email);

}
