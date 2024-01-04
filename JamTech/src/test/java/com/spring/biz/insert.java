package com.spring.biz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tech.biz.dao.CrewsBoardDAO;
import com.tech.biz.domain.CrewsBoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class insert {

	@Autowired
	CrewsBoardDAO crewsboardDAO;
	
	@Test
	public void insertTestData() throws Exception{
		//boardDao.deleteAll();
		for(int i = 1; i<200; i++) {
			CrewsBoardDTO crewsboardDTO = new CrewsBoardDTO(67+i, "난최강이다" + i, "jam", "no content", null, null, i, i, "화성", "연차", "개월", "미완료", i, i);
			crewsboardDAO.insert(crewsboardDTO);
		}
	}

}
