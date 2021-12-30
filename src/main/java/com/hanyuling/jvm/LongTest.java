package com.hanyuling.jvm;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LongTest {
    public static void main(String[] args) {
        long sum = Long.valueOf(0);
        long start = System.currentTimeMillis();
        for (long i = Long.valueOf(0); i < Integer.MAX_VALUE; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(end-start);

        System.out.println(StringUtils.isBlank(null));
        long time = System.currentTimeMillis();
        String tt = String.valueOf(time);
        System.out.println(time);
        System.out.println(LocalDateTime.ofEpochSecond(Long.valueOf(tt)/1000,0, ZoneOffset.ofHours(8)));
    }



}
