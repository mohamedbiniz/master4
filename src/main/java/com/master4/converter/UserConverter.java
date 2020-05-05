package com.master4.converter;

import com.master4.entities.Tag;
import com.master4.entities.User;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class UserConverter implements Converter<String, User> {
    @Override
    public User convert(String source) {
        if (source.isEmpty()) return null;
        else {
            return new User(Long.parseLong(source));
        }

    }
}
