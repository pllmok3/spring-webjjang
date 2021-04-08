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
	
	//�˻� �Խ��� ����Ʈ
	public List<BoardVO> list(PageObject pageObject){
		
		pageObject.setTotalRow(mapper.getCount(pageObject));
		return mapper.list(pageObject);
	}
	
	//�Խ��� �۾���
	public Integer write(BoardVO vo) {
		System.out.println("BoardService.write()");
		
		return mapper.write(vo);
		
	}
	
	//�˻� �Խ��� �ۺ���
	public BoardVO view(int no, int inc) {
		System.out.println("BoardService.view()");
		
		if(inc == 1) {mapper.increase(no);}
		
		return mapper.view(no);
		
	}
	
	//�˻� �Խ��� �ۼ���
	public void update(BoardVO vo) throws Exception{
		mapper.update(vo);
	}
	
	
	//�Խ��� �� ����
	public Integer delete(int no) {
		System.out.println("BoardService.delete()");
		
		return mapper.delete(no);
	}
	
	
	//ȸ�� ���
	public Integer gaip(memberVO vo) {
		System.out.println("BoardService.gaip()");
		
		return mapper.gaip(vo);
		
	}

	public int loginCheck(memberVO vo) {
		System.out.println("BoardService.loginCheck()");
		return mapper.loginCheck(vo);
	}
	
	
	
}
