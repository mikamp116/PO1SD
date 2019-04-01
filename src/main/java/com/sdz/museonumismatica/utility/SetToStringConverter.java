package com.sdz.museonumismatica.utility;

import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetToStringConverter implements Converter<TreeSet<String>, String> {

    @Override
    public String convert(TreeSet source){
        StringBuilder toReturn = new StringBuilder();
        if (source!=null) {
            Iterator it = source.iterator();
            while(it.hasNext()){
                toReturn.append(it.next());
                if(it.hasNext()) toReturn.append(", ");
            }
            return toReturn.toString();
        }
        else return "";
    }
}
