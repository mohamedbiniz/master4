package com.master4.converter;

import com.master4.entities.Tag;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class TagConverter implements Converter<List<String>, Object> {

    @Override
    public List<Tag> convert(List<String> source) {
       List<Tag> listTag=new ArrayList<>();
       if(source.isEmpty()) {
           return null;
       }else{
            source.forEach(e->listTag.add(new Tag(Long.parseLong(e))));
            return listTag;
       }
    }
}
