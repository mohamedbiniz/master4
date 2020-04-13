package com.master4.converter;

import com.master4.entities.Tag;
import com.master4.services.TagService;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import java.util.Collection;

public class TagFormatter extends CustomCollectionEditor {


    private final TagService tagService;

    public TagFormatter(Class<? extends Collection> collectionType, TagService tagService ) {
        super(collectionType);
        this.tagService =tagService;
    }

    @Override
    protected Object convertElement(Object element) {
        if(!element.equals(null)) {
            Tag tag = new Tag(Long.parseLong(String.valueOf(element)));
            return tag;
        }else{
            return null;
        }
    }


}