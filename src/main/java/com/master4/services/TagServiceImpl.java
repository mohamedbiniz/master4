package com.master4.services;


import com.master4.entities.Tag;
import com.master4.exceptions.ResourceNotFoundException;
import com.master4.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagRepository tagRepository;

    @Override
    @Transactional
    public Page<Tag>  getAllTags(Optional<Integer> pageNo, Integer pageSize, String sortBy)
    {
        if(pageNo.isPresent()){
            Pageable paging = PageRequest.of(pageNo.get(), pageSize, Sort.by(sortBy));
            return tagRepository.findAll(paging);
        }else{
            Pageable paging = PageRequest.of(0, pageSize, Sort.by(sortBy));
            return tagRepository.findAll(paging);
        }
    }

    @Override
    @Transactional
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    @Transactional
    public Tag findById(long id) throws ResourceNotFoundException {
        return tagRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(Tag tag) {
         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
         tag.setCreated(timestamp);
         tagRepository.save(tag);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        tagRepository.deleteById(id);
    }
}
