package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

// 모델 계층에 붙이는 @Component의 자손 어노테이션이다.
@Service
public class MemberDao {
	Logger logger = LoggerFactory.getLogger(MemberDao.class);
	@Autowired(required = false)
	private SqlSessionTemplate sqlSessionTemplate = null;

	public int memberinsert(Map<String, Object> pMap) {
		logger.info("memberinsert 호출 성공 ==> "+pMap);
		int result = 0;
		try {
			sqlSessionTemplate.selectOne("pro_boardinsert", pMap);
			if(pMap.get("result")!=null) {
				result = Integer.parseInt(pMap.get("result").toString());
			}
			// insert here
			logger.info("result : "+result);
		} catch (DataAccessException e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}

}
