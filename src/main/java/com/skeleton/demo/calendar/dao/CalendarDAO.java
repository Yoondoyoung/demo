package com.skeleton.demo.calendar.dao;

import com.skeleton.demo.calendar.vo.CalendarVO;

import java.util.List;

public interface CalendarDAO {
    public void addCalendar(CalendarVO calendarVO) throws Exception;

    public CalendarVO getCalendar(String userId) throws Exception;

    public List<CalendarVO> getCalendarList(String userId) throws Exception;
}
