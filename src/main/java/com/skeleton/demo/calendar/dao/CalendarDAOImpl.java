package com.skeleton.demo.calendar.dao;

import com.skeleton.demo.calendar.vo.CalendarVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("calendarDAOImpl")
public class CalendarDAOImpl implements CalendarDAO{

    @Autowired
    SqlSession sqlSession;

    @Override
    public void addCalendar(CalendarVO calendarVO) throws Exception {
        sqlSession.insert("CalendarMapper.addCalendar",calendarVO);
    }

    @Override
    public CalendarVO getCalendar(String userId) throws Exception {

        return sqlSession.selectOne("CalendarMapper.getCalendar",userId);
    }

    @Override
    public List<CalendarVO> getCalendarList(String userId) throws Exception {
        return sqlSession.selectList("CalendarMapper.getCalendarList",userId);
    }
}
