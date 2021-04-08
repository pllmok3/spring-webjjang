package com.webjjang.board.mapper;

import java.util.List;

import com.webjjang.board.vo.BoardVO;
import com.webjjang.board.vo.memberVO;

import net.webjjang.util.PageObject;

public interface BoardMapper {
	
	
	//�Խ��� ����Ʈ
	public List<BoardVO> list(PageObject pageObject);
	public Integer getCount(PageObject pageObject);
	//�Խ��� �ۺ���
	public BoardVO view(int no);
	public void increase(int no);  //��ȸ�� 1����
	//�Խ��� �۾���
	public Integer write(BoardVO vo);
	//�Խ��� �ۼ���
	public Integer update(BoardVO vo);
	//�Խ��� �ۻ���
	public Integer delete(int no);
	
	
	//ȸ�� ��� ��Ű��
	public Integer gaip(memberVO vo);
	//ȸ�� ���� ��������
	public int loginCheck(memberVO vo);
	
}
