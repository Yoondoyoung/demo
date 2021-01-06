package com.skeleton.demo.calendar.service.impl;

import com.skeleton.demo.calendar.dao.CalendarDAO;
import com.skeleton.demo.calendar.service.CalendarService;
import com.skeleton.demo.calendar.vo.CalendarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    @Qualifier("calendarDAOImpl")
    CalendarDAO calendarDAO;

    @Override
    public void addCalendar(CalendarVO calendarVO) throws Exception {
        calendarDAO.addCalendar(calendarVO);
    }

    @Override
    public CalendarVO getCalendar(String Calendar) throws Exception {

        return calendarDAO.getCalendar(Calendar);
    }

    @Override
    public List<CalendarVO> getCalendarList(String userId) throws Exception {

        return calendarDAO.getCalendarList(userId);
    }
}
