package com.terabits.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.event.PublicInvocationEvent;

import com.terabits.meta.po.TestPO;

public interface TestMapper {	
	/*
	 * map
	 * {
	 * 		tableName:string
	 * 		name:string
	 * 		password:string
	 *      sex:string
	 *      age:int
	 * }
	 */
	public int insertTestPO2(Map<String, Object> map);
	/*
	 * Aim:put map as parameter
	 * map{
	 * 		tableName:string
	 * 		column:string
	 * 		value:string
	 * }
	 */
	public List<Map<String, Object>> select(Map<String, Object> map);
	/*
	 * Aim:put List as parameter
	 */
	public List<Map<String, Object>> selectByList(List<String> strings);
	/*
	 * Aim:put string and list into a Map
	 * map{
	 * 		tableName:String
	 * 		date:List<String>
	 * }
	 */
	public List<Map<String, Object>> selectByMap(Map<String, Object> map);
}
