package com.skeleton.demo.calendar.service;

import com.skeleton.demo.calendar.vo.CalendarVO;

import java.util.List;

public interface CalendarService {

    public void addCalendar(CalendarVO calendarVO) throws Exception;

    public CalendarVO getCalendar(String Calendar) throws Exception;

    public List<CalendarVO> getCalendarList(String userId) throws Exception;

}
