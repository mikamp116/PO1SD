package com.sdz.museonumismatica;

import com.sdz.museonumismatica.utility.SetToStringConverter;
import com.sdz.museonumismatica.utility.StringToFloatConverter;
import com.sdz.museonumismatica.utility.StringToSetConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new StringToFloatConverter());
        registry.addConverter(new StringToSetConverter());
        registry.addConverter(new SetToStringConverter());
    }
}
