package com.tech.biz.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tech.biz.dao.CrewsBoardDAO;
import com.tech.biz.domain.CrewsBoardDTO;
import com.tech.biz.domain.FileUtils;
import com.tech.biz.domain.SearchCondition;

@Service
public class CrewsBoardServiceImpl implements CrewsBoardService {
	@Autowired
	CrewsBoardDAO crewsboardDAO;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	//1게시글 목록
	@Override
	public List<CrewsBoardDTO> getList() throws Exception {
		return crewsboardDAO.selectAll();
	}
	
	//2게시글 읽기
	@Override
	public CrewsBoardDTO read(Integer crew_post_no) throws Exception{
		CrewsBoardDTO crewsboardDTO = crewsboardDAO.select(crew_post_no);
		
		//7게시글 조회수 증가
		crewsboardDAO.increaseCnt(crew_post_no);
		return  crewsboardDTO;
	}
	
	//3게시글 쓰기
	@Override
	public void write(CrewsBoardDTO crewboardDTO, MultipartHttpServletRequest mpRequest) throws Exception{
		crewsboardDAO.insert(crewboardDTO);
		
		
		//3-1첨부파일 업로드
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(crewboardDTO, mpRequest); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			crewsboardDAO.insertFile(list.get(i));
		}
	}
	
	//3-2.첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(Integer crew_post_no) throws Exception {
		return crewsboardDAO.selectFileList(crew_post_no);
	}
	
	//3-3.참부파일 다운
	@Override
	public Map<String, Object> selectFileInfo(Integer crew_file_no) throws Exception {
		return crewsboardDAO.selectFileInfo(crew_file_no);
	}
	
	//4게시글 수정
	@Override
	public void modify(CrewsBoardDTO crewboardDTO, MultipartHttpServletRequest mpRequest, String[] files, String[] fileNames) throws Exception{
		crewsboardDAO.update(crewboardDTO);
		
		//4-1첨부파일 업로드
		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(crewboardDTO, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for(int i = 0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				crewsboardDAO.insertFile(tempMap);
			}else {
				crewsboardDAO.updateFile(tempMap);
			}
		}
	}
	
	//5게시글 삭제
	@Override
	public int remove(Integer crew_post_no, String crew_writer) throws Exception {
	    return crewsboardDAO.delete(crew_post_no, crew_writer);
	}
	
	//6전체 게시글 개수
	@Override
	public int getCount() throws Exception {
        return crewsboardDAO.count();
    }
	
	
	//8게시글 추천수 증가
	@Override
	public int increaseRecommend(Integer crew_post_no) throws Exception {
        return crewsboardDAO.increaseRecommend(crew_post_no);
    }
	
	//8-1게시글 추천수 취소
	@Override
	public int decreaseRecommend(Integer crew_post_no) throws Exception {
        return crewsboardDAO.decreaseRecommend(crew_post_no);
    }
	
	//8-2게시글 추천수 개수
	@Override
	public int recommendCnt(Integer crew_post_no) throws Exception {
        return crewsboardDAO.recommendCnt(crew_post_no);
    }
	
	//9게시글 페이징
	@Override
	public List<CrewsBoardDTO> getPage(Map map) throws Exception {
        return crewsboardDAO.selectPage(map);
    }
	
	//10게시글 검색
	@Override
	public List<CrewsBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception{
		return crewsboardDAO.searchSelectPage(sc);
	}
	
	//11게시글 검색 개수 확인
	@Override
	public int getSearchResultCount(SearchCondition sc) throws Exception{
		return crewsboardDAO.searchResultCnt(sc);
	}
}	
