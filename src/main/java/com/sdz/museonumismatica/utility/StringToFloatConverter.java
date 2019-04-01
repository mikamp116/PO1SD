package com.sdz.museonumismatica.utility;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

public class StringToFloatConverter implements Converter<String, Float> {

    @Override
    public Float convert(String source){
        if (source!=null && !source.isEmpty())
            try{
                return Float.valueOf(source);
            } catch (NumberFormatException e) {
                return (float) -1;
            }
        else return (float) 0;
    }
}
