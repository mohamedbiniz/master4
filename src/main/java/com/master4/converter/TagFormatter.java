package com.master4.converter;

import com.master4.entities.Tag;
import com.master4.services.TagService;
import lombok.SneakyThrows;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import java.util.Collection;

public class TagFormatter extends CustomCollectionEditor {




    public TagFormatter(Class<? extends Collection> collectionType ) {
        super(collectionType);
    }

    @SneakyThrows
    @Override
    protected Object convertElement(Object element) {
        if(!element.equals(null)) {
            Tag tag =  new Tag(Long.parseLong(String.valueOf(element)));
            return tag;
        }else{
            return null;
        }
    }


}