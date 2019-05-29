package com.bigdata.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        Date date = null;
        try {
            if (StringUtils.isEmpty(s)) {
                throw new NullPointerException("请输入要转换的日期");
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            date = format.parse(s);
        } catch (ParseException e) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                date = format.parse(s);
            } catch (ParseException e1) {
                throw new NullPointerException("请输入正确的日期格式");
            }
        }
        return date;
    }
}
