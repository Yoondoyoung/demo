package com.skeleton.demo.calendar.dto;

import com.skeleton.demo.calendar.vo.CalendarVO;
import lombok.Data;


public class CalendarDTO {

    @Data
    public static class addCalendar{
        private String startDate;
        private String endDate;
        private String title;
        private String detail;
        private String userId;

        public CalendarVO addCalendarConvert(){
            return new CalendarVO(
                    this.getStartDate(),
                    this.getEndDate(),
                    this.getTitle(),
                    this.getDetail(),
                    this.getUserId()
            );
        }
    }
}
