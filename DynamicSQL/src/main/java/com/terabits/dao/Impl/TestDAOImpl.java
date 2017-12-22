package com.terabits.dao.Impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.terabits.dao.TestDAO;
import com.terabits.mapper.TestMapper;
import com.terabits.meta.po.TestPO;
import com.terabits.utils.DBTools;

@Repository("testDAO")
public class TestDAOImpl implements TestDAO {

	public int insertTestPO2(Map<String, Object> map){
		SqlSession session = DBTools.getSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        int result=0;
        try {
			result=mapper.insertTestPO2(map);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
        return result;
	}
	
	public List<Map<String, Object>> select(Map<String, Object> map){
		SqlSession session = DBTools.getSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        List<Map<String, Object>> sList=null;
        try {
			sList=mapper.select(map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
        return sList;
	}
	
	public List<Map<String, Object>> selectByList(List<String> strings){
		SqlSession session = DBTools.getSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        List<Map<String, Object>> sList=null;
        try {
			sList=mapper.selectByList(strings);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
        return sList;
	}
	
	public List<Map<String, Object>> selectByMap(Map<String, Object> map){
		SqlSession session = DBTools.getSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        List<Map<String, Object>> sList=null;
        try {
			sList=mapper.selectByMap(map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
        return sList;
	}
}
