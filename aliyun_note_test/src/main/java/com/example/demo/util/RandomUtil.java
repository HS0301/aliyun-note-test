package com.example.demo.util;/**
 * @description:
 * @author: ManolinCoder
 * @time: 2022/9/28
 */

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 *@Auther 月鸟石 2022/9/28 10:49:39
 *联系方式(QQ)：3054578922
 *周三 
 *欢迎回家，主人
 */
public class RandomUtil {

    private static  final Random random = new Random();
    private static final DecimalFormat fourdf = new DecimalFormat("0000");
    private static final DecimalFormat sixdf = new DecimalFormat("000000");

    public static String getFourBitRandom(){
        return fourdf.format(random.nextInt(1000));
    }

    public static String getSixBitRandom(){
        return fourdf.format(random.nextInt(1000000));
    }

    public static void main(String[] args) {
        String str = getSixBitRandom();
        System.out.println(str);
    }
}

/**
 *一切顺心
 */