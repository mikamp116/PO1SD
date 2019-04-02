package com.sdz.museonumismatica.utility;

import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class StringToSetConverter implements Converter<String, Set> {

    @Override
    public TreeSet<String> convert(String source){
        if (source!=null && !source.isEmpty()) {
            return new TreeSet<>(Arrays.asList(source.split(", ")));
        }
        else return null;
    }
}
