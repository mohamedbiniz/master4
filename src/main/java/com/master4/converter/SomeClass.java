package com.master4.converter;

import com.master4.entities.User;

import java.beans.PropertyEditorSupport;

public class SomeClass extends PropertyEditorSupport {

    public Object getValue() {
        return new User();
    }
}
