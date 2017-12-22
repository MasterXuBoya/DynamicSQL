package com.terabits.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.terabits.dao.TestDAO;
import com.terabits.meta.po.AdminPO;
import com.terabits.meta.po.TestPO;
import com.terabits.utils.JWT;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Controller
public class TestController {

	@Autowired
	private TestDAO testDAO;
	/*
	 * JWT仅仅是消息认证算法
	 * JWT的token由三部分组成，
	 * 		{"typ":"JWT","alg":"HS256"}          Base64()加密
	 * 		{"exp":1513426032241,"payload":"\"Hello World\""} Base64加密
	 * 		将上面两个部分，加盐secret，进行HMAC SHA256加密，得到第三个部分
	 * 		将以上三个部分用"."连接起来
	 */		
	@RequestMapping(value="/Jwt")
	public void Jwt() throws Exception{
		TestPO testPO=new TestPO();
		testPO.setName("MasterXuBo");
		testPO.setPassword("124");
		testPO.setSex("boy");
		testPO.setAge(18);
		System.out.println(testPO);
		String token = JWT.sign("Hello World", 48 * 1800L * 1000L);   
		System.out.println(token);
		
		String[] strings=token.split("\\.");
		for(String string:strings)
			System.out.println(string);
		String result = JWT.unsign(token, String.class);
		System.out.println(result);
		
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			System.out.println("************************************************");
			System.out.println("jdk decode:" + new String(decoder.decodeBuffer(strings[0])));
			System.out.println("jdk decode:" + new String(decoder.decodeBuffer(strings[1])));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value="/insert")
	public void insertTestPO( @RequestParam(value="name",required=false) String name,
							  @RequestParam(value="password",required=false) String password,
							  @RequestParam(value="sex",required=false) String sex,
							  @RequestParam(value="age",required=false) String age) throws Exception{
		
		//******************************************************************************
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("name", name);
		map.put("password", password);
		map.put("sex", sex);
		map.put("age", age);
		map.put("tableName", "t_charge_test");
		map.put("column","name");
		map.put("value", "master");
		System.out.println(map);
		testDAO.insertTestPO2(map);
	}
	
	//*****************************************************************************
	@RequestMapping(value="/select")
	public void selectTestPO() throws Exception{
		doWork();
	}
	public void doWork(){
		/*Map<String,Object> map=new HashMap<String, Object>();
		map.put("tableName", "t_charge_test");
		map.put("column","password");
		map.put("value", "123");
		System.out.println(map);
		List<Map<String, Object>> sList=testDAO.select(map);
		for(Map<String, Object> sMap:sList){
			System.out.println(sMap);
		}*/
		
		/*List<String> strings=new ArrayList<String>();
		strings.add("xu");
		strings.add("master");
		List<Map<String, Object>> sList=testDAO.selectByList(strings);
		for(Map<String, Object> sMap:sList){
			System.out.println(sMap);
		}*/
		List<String> strings=new ArrayList<String>();
		strings.add("xu");
		strings.add("master");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("tableName", "t_charge_test");
		map.put("date", strings);
		List<Map<String, Object>> sList=testDAO.selectByMap(map);
		for(Map<String, Object> sMap:sList)
			System.out.println(sMap);
		
	}
}
