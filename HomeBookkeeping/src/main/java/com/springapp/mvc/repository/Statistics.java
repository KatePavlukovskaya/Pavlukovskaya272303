package com.springapp.mvc.repository;

import org.springframework.stereotype.Component;

/**
 * Created by itechno on 22.05.2015.
 */
@Component

public class Statistics {
    private String nameCategory;
    private float january;
    private float february;
    private float march;
    private float april;
    private float may;
    private float june;
    private float july;
    private float august;
    private float september;
    private float october;
    private float november;
    private float december;
    private float year;


    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public float getJanuary() {
        return january;
    }

    public void setJanuary(float january) {
        this.january = january;
    }

    public float getFebruary() {
        return february;
    }

    public void setFebruary(float february) {
        this.february = february;
    }

    public float getMarch() {
        return march;
    }

    public void setMarch(float march) {
        this.march = march;
    }

    public float getApril() {
        return april;
    }

    public void setApril(float april) {
        this.april = april;
    }

    public float getMay() {
        return may;
    }

    public void setMay(float may) {
        this.may = may;
    }

    public float getJune() {
        return june;
    }

    public void setJune(float june) {
        this.june = june;
    }

    public float getJuly() {
        return july;
    }

    public void setJuly(float july) {
        this.july = july;
    }

    public float getAugust() {
        return august;
    }

    public void setAugust(float august) {
        this.august = august;
    }

    public float getSeptember() {
        return september;
    }

    public void setSeptember(float september) {
        this.september = september;
    }

    public float getOctober() {
        return october;
    }

    public void setOctober(float october) {
        this.october = october;
    }

    public float getNovember() {
        return november;
    }

    public void setNovember(float november) {
        this.november = november;
    }

    public float getDecember() {
        return december;
    }

    public void setDecember(float december) {
        this.december = december;
    }


    public void setSum(int i, int sum){
        if(i==0)
        {
            this.setJanuary(sum);
        }
        if(i==1)
        {
            this.setFebruary(sum);
        }
        if(i==2)
        {
            this.setMarch(sum);
        }
        if(i==3)
        {
            this.setApril(sum);
        }
        if(i==4)
        {
            this.setMay(sum);
        }
        if(i==5)
        {
            this.setJune(sum);
        }
        if(i==6)
        {
            this.setJuly(sum);
        }
        if(i==7)
        {
            this.setAugust(sum);
        }
        if(i==8)
        {
            this.setSeptember(sum);
        }
        if(i==9)
        {
            this.setOctober(sum);
        }
        if(i==10)
        {
            this.setNovember(sum);
        }
        if(i==11)
        {
            this.setDecember(sum);
        }
    }

    public float getYear() {
        this.year = getApril()+getAugust()+getDecember()+getFebruary()+getJanuary()+getJuly()+getJune()+getMarch()+getSeptember()+
                +getNovember()+getOctober()+getMay();
        return year;
    }

    public void setYear(float year) {
        this.year = year;
    }
}
