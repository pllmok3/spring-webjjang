package com.webjjang.board.mapper;

import java.util.List;

import com.webjjang.board.vo.BoardVO;
import com.webjjang.board.vo.memberVO;

import net.webjjang.util.PageObject;

public interface BoardMapper {
	
	
	//게시판 리스트
	public List<BoardVO> list(PageObject pageObject);
	public Integer getCount(PageObject pageObject);
	//게시판 글보기
	public BoardVO view(int no);
	public void increase(int no);  //조회수 1증가
	//게시판 글쓰기
	public Integer write(BoardVO vo);
	//게시판 글수정
	public Integer update(BoardVO vo);
	//게시판 글삭제
	public Integer delete(int no);
	
	
	//회원 등록 시키기
	public Integer gaip(memberVO vo);
	//회원 정보 가져오기
	public int loginCheck(memberVO vo);
	
}
