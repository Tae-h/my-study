package com.tae.mystudy;

public class SubStringExample {


    public static void main(String[] args) {
        String projectName = "[퍼블리싱/3개월]퍼블리싱 등록";

        //String b = projectName.substring(0, projectName.indexOf("\\]"));

        System.out.println(projectName.split("\\]")[0] + "]");

    }
}
