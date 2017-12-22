package com.terabits.dao;

import java.util.List;
import java.util.Map;

import com.terabits.meta.po.TestPO;

public interface TestDAO {
	public int insertTestPO2(Map<String, Object> map);
	public List<Map<String, Object>> select(Map<String, Object> map);
	public List<Map<String, Object>> selectByList(List<String> strings);
	public List<Map<String, Object>> selectByMap(Map<String, Object> map);
}
