package com.tae.mystudy;

import java.util.Arrays;

public class SubStringExample {


    public static void main(String[] args) {
        //String projectName = "[퍼블리싱/3개월]삼성생명 프로젝트 구축";
        String projectName = "test 대기업 웹기획 및 디자인, OO쇼핑몰 웹 개발,OO증권 안드로이드 앱개발";

        //String b = projectName.substring(0, projectName.indexOf("\\]"));
        System.out.println("pre: " + projectName);

        System.out.println(projectName.contains("]"));

        if ( projectName.contains("]") ) {
        }
        String first = projectName.split("\\]")[0] + "]";
        String second = projectName.split("\\]")[1];




        System.out.println(first);
        System.out.println(second);

        String[] strArr = second.split(" ");


        for ( int i = 0; i < strArr.length; i++  ) {
            if ( i == 0 ) {
                if ("삼성생명".equals(strArr[i])) {
                    strArr[0] = "대기업";
                };
            }
        }
        System.out.println(Arrays.toString(strArr));
        String test = String.join(" ", strArr);

        System.out.println(test);
        System.out.println(first + String.join(" ", strArr));
    }
}
