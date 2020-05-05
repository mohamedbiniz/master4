package com.master4.converter;

import com.master4.entities.Tag;
import com.master4.entities.User;
import lombok.SneakyThrows;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;

import java.beans.PropertyEditorSupport;
import java.util.Collection;

public class UserFormatter extends PropertyEditorSupport {




    public UserFormatter(Class<? extends User> collectionType ) {
        super(collectionType);
    }

    @SneakyThrows
    //@Override
    protected Object convertElement(Object element) {
        if(!element.equals(null)) {
            User user =  new User(Long.parseLong(String.valueOf(element)));
            return user;
        }else{
            return null;
        }
    }
}
