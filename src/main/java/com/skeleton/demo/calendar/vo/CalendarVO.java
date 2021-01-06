package com.skeleton.demo.calendar.vo;

public class CalendarVO {


    private String startDate;
    private String endDate;
    private String title;
    private String detail;
    private String userId;  //join

    public CalendarVO(String startDate, String endDate, String title, String detail, String userId){
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.userId = userId;
        this.detail = detail;
    }
}
