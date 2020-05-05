package com.master4.services;

import com.master4.entities.Article;
import com.master4.entities.Role;
import com.master4.entities.Tag;
import com.master4.entities.User;
import com.master4.exceptions.ResourceNotFoundException;
import com.master4.repositories.ArticleRepository;
import com.master4.repositories.RoleRepository;
import com.master4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    @Transactional
    public Page<User> getAllUsers(Optional<Integer> pageNo, Integer pageSize, String sortBy) {
        if(pageNo.isPresent()){
            Pageable paging = PageRequest.of(pageNo.get(), pageSize, Sort.by(sortBy));
            return userRepository.findAll(paging);
        }else{
            Pageable paging = PageRequest.of(0, pageSize, Sort.by(sortBy));
            return userRepository.findAll(paging);
        }
    }
    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User findById(long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(User user){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //user.setCreated(timestamp);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Article> getArticlesOfUser(Long id) {
        return userRepository.getArticlesById(id);
    }

    @Override
    public boolean isExist(String email, String password) {
         return userRepository.getUserByEmaiAndPassword(email,password) != null;
    }

    @Override
    public List<String> getRolesOfUserByEmail(String email) {
        List<String> liste = new ArrayList<>();
        for (Role r : roleRepository.getRolesByEmail(email)){
            liste.add(r.getName());
        }
        return liste;
    }

    @Override
    public User findByEmail(String Email) throws ResourceNotFoundException {
        return userRepository.getUserByEmail(Email);
    }

    @Override
    public boolean isUserArticle(long iduser, long idArticle) {
        return articleRepository.getArticleByUser(iduser,idArticle) !=null;
    }


}
