package com.sdz.museonumismatica.utility;

import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class StringToSetConverter implements Converter<String, Set> {

    @Override
    public TreeSet convert(String source){
        if (source!=null && !source.isEmpty()) {
            TreeSet set = new TreeSet();
            set.addAll(Arrays.asList(source.split(", ")));
            return set;
        }
        else return null;
    }
}
