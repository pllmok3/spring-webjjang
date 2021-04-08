package com.webjjang.board.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.board.service.BoardService;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.board.vo.memberVO;

import net.webjjang.util.PageObject;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	private final String MODULE_NAME = "board";
	
	//�Խ��� ����Ʈ
	@GetMapping("/list.do")
	public String list(Model model,PageObject pageObject) {
		System.out.println("BoardController.list.pageObject : "+pageObject);
		
		model.addAttribute("list",service.list(pageObject));
		model.addAttribute("pageObject",pageObject);
		
		return MODULE_NAME + "/list";
	}
	
	//�Խ��� �۾���
	@GetMapping("/write.do")
	public String writeForm() {
		System.out.println("BoardController.writeForm()");
		
		return MODULE_NAME + "/write";
	}
	
	
	//�Խ��� �۾��� ó�� - ����, ����, �ۼ���, ��й�ȣ
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		System.out.println("BoardController.write()");
		
		service.write(vo);
		
		return "redirect:list.do";
	}
	
	//�Խ��� �ۺ���
	@GetMapping("/view.do")
	public String view(Model model,PageObject pageObject, int no , int inc) {
		
		model.addAttribute("vo",service.view(no, inc));
	
		//model.addAttribute("pageObject",pageObject);   <--�̰ɷ� ó�� ���ϰ� jsp���� param �̿��� ����!
		
		return MODULE_NAME + "/view";
	}
	
	//�Խ��� �ۼ��� ��
	@GetMapping("/update.do")
	public String updateForm(Model model, int no, int inc) {
		System.out.println("BoardController.updateForm()");
		
		model.addAttribute("vo",service.view(no, inc));
		
		return MODULE_NAME + "/update";
	}
	
	
	//�Խ��� �ۼ��� ó�� - ����, ����, �ۼ���, �۹�ȣ(Ȯ�ο�), ��й�ȣ :Ȯ�ο�
	@PostMapping("/update.do")
	public String update(BoardVO vo,PageObject pageObject) throws Exception{
		System.out.println("BoardController.update() ");
		
		service.update(vo);
		
		// �˻����� �ѱ� ó��  -->�˻�� null �̸� null�� �ƴ� ""���� ����� �ش�.
		if(pageObject.getWord() == null) pageObject.setWord("");
		
		
		//ȭ�� jsp������ �ʰ� �ٷαۺ��� �̵�
		return "redirect:view.do?no=" + vo.getNo() + "&inc=0"
				+ "&page=" + pageObject.getPage()
				+ "&perPageNum=" + pageObject.getPerPageNum()
				+ "&key=" + pageObject.getKey()
				+ "&word=" + URLEncoder.encode(pageObject.getWord(), "utf-8") ;
	}
	
	

	
	//�Խ��� �ۻ��� ó�� - �۹�ȣ , ��й�ȣ : Ȯ�ο�
	@GetMapping("/delete.do")
	public String delete(int no) {
		System.out.println("BoardController.delete()");
		
		service.delete(no);
		
		return "redirect:list.do?page=1&perPageNum=10";
	}
	
	
	//�α��� ȭ��
	@GetMapping("/login.do")
	public String loginForm(HttpSession session) {
		session.invalidate();
		return MODULE_NAME + "/login";
	}
	
	//�α��� �´��� Ȯ������ �Խ��� ����Ʈ�� ����
	@PostMapping("/login.do")
	public String loginCheck(memberVO vo,HttpSession session,String userId) {
		System.out.println("BoardController.loginCheck()");
		int check = service.loginCheck(vo);
			
		if(check ==1 ) {
			session.setAttribute("userId", userId);
			
			return "redirect:list.do";
		}
		
		return "redirect:login.do";
	}
	
	//ȸ������ ȭ��
	@GetMapping("/gaip.do")
	public String gaipForm() {
		
		return MODULE_NAME + "/gaip";
	}
	
	//ȸ������ �ϱ�
	@PostMapping("/gaip.do")
	public String gaip(memberVO vo) {
		System.out.println("BoardController.gaip()");
		
		service.gaip(vo);
		
		return "redirect:login.do";
	} 
	
}
