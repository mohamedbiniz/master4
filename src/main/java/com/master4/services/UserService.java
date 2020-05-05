package com.master4.services;

import com.master4.entities.Article;
import com.master4.entities.Role;
import com.master4.entities.Tag;
import com.master4.entities.User;
import com.master4.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Page<User> getAllUsers(Optional<Integer> pageNo, Integer pageSize, String sortBy);
    public List<User> getAllUsers();
    public User findById(long id) throws ResourceNotFoundException;
    public  void save(User user);
    public void deleteById(long id);
    public List<Article> getArticlesOfUser(Long id);
    public boolean isExist(String email , String password);
    public List<String>  getRolesOfUserByEmail(String email);
    public User findByEmail(String Email) throws ResourceNotFoundException;
    public boolean isUserArticle(long iduser , long idArticle);

}
