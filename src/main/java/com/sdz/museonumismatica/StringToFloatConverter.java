package com.sdz.museonumismatica;

import org.springframework.core.convert.converter.Converter;

public class StringToFloatConverter implements Converter<String, Float> {

    @Override
    public Float convert(String from){
        return Float.valueOf(from);
    }
}
