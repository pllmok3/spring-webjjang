package com.webjjang.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.webjjang.board.mapper.BoardMapper;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.board.vo.memberVO;

import net.webjjang.util.PageObject;

@Service
public class BoardService {
	
	@Inject
	private BoardMapper mapper;
	
	//검색 게시판 리스트
	public List<BoardVO> list(PageObject pageObject){
		
		pageObject.setTotalRow(mapper.getCount(pageObject));
		return mapper.list(pageObject);
	}
	
	//게시판 글쓰기
	public Integer write(BoardVO vo) {
		System.out.println("BoardService.write()");
		
		return mapper.write(vo);
		
	}
	
	//검색 게시판 글보기
	public BoardVO view(int no, int inc) {
		System.out.println("BoardService.view()");
		
		if(inc == 1) {mapper.increase(no);}
		
		return mapper.view(no);
		
	}
	
	//검색 게시판 글수정
	public void update(BoardVO vo) throws Exception{
		mapper.update(vo);
	}
	
	
	//게시판 글 삭제
	public Integer delete(int no) {
		System.out.println("BoardService.delete()");
		
		return mapper.delete(no);
	}
	
	
	//회원 등록
	public Integer gaip(memberVO vo) {
		System.out.println("BoardService.gaip()");
		
		return mapper.gaip(vo);
		
	}

	public int loginCheck(memberVO vo) {
		System.out.println("BoardService.loginCheck()");
		return mapper.loginCheck(vo);
	}
	
	
	
}
