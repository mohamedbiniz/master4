package com.master4.services;

import com.master4.entities.Tag;
import com.master4.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface TagService {


    public Page<Tag> getAllTags(Optional<Integer> pageNo, Integer pageSize, String sortBy);
    public List<Tag> getAllTags();

    Tag findById(long id) throws ResourceNotFoundException;

    void save(Tag article);

    void deleteById(long id);

}
