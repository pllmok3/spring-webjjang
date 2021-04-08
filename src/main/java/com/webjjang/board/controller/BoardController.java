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
	
	//게시판 리스트
	@GetMapping("/list.do")
	public String list(Model model,PageObject pageObject) {
		System.out.println("BoardController.list.pageObject : "+pageObject);
		
		model.addAttribute("list",service.list(pageObject));
		model.addAttribute("pageObject",pageObject);
		
		return MODULE_NAME + "/list";
	}
	
	//게시판 글쓰기
	@GetMapping("/write.do")
	public String writeForm() {
		System.out.println("BoardController.writeForm()");
		
		return MODULE_NAME + "/write";
	}
	
	
	//게시판 글쓰기 처리 - 제목, 내용, 작성자, 비밀번호
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		System.out.println("BoardController.write()");
		
		service.write(vo);
		
		return "redirect:list.do";
	}
	
	//게시판 글보기
	@GetMapping("/view.do")
	public String view(Model model,PageObject pageObject, int no , int inc) {
		
		model.addAttribute("vo",service.view(no, inc));
	
		//model.addAttribute("pageObject",pageObject);   <--이걸로 처리 안하고 jsp에서 param 이용할 예정!
		
		return MODULE_NAME + "/view";
	}
	
	//게시판 글수정 폼
	@GetMapping("/update.do")
	public String updateForm(Model model, int no, int inc) {
		System.out.println("BoardController.updateForm()");
		
		model.addAttribute("vo",service.view(no, inc));
		
		return MODULE_NAME + "/update";
	}
	
	
	//게시판 글수정 처리 - 제목, 내용, 작성자, 글번호(확인용), 비밀번호 :확인용
	@PostMapping("/update.do")
	public String update(BoardVO vo,PageObject pageObject) throws Exception{
		System.out.println("BoardController.update() ");
		
		service.update(vo);
		
		// 검색어의 한글 처리  -->검색어가 null 이면 null이 아닌 ""으로 만들어 준다.
		if(pageObject.getWord() == null) pageObject.setWord("");
		
		
		//화면 jsp보이지 않고 바로글보기 이동
		return "redirect:view.do?no=" + vo.getNo() + "&inc=0"
				+ "&page=" + pageObject.getPage()
				+ "&perPageNum=" + pageObject.getPerPageNum()
				+ "&key=" + pageObject.getKey()
				+ "&word=" + URLEncoder.encode(pageObject.getWord(), "utf-8") ;
	}
	
	

	
	//게시판 글삭제 처리 - 글번호 , 비밀번호 : 확인용
	@GetMapping("/delete.do")
	public String delete(int no) {
		System.out.println("BoardController.delete()");
		
		service.delete(no);
		
		return "redirect:list.do?page=1&perPageNum=10";
	}
	
	
	//로그인 화면
	@GetMapping("/login.do")
	public String loginForm(HttpSession session) {
		session.invalidate();
		return MODULE_NAME + "/login";
	}
	
	//로그인 맞는지 확인한후 게시판 리스트로 보냄
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
	
	//회원가입 화면
	@GetMapping("/gaip.do")
	public String gaipForm() {
		
		return MODULE_NAME + "/gaip";
	}
	
	//회원가입 하기
	@PostMapping("/gaip.do")
	public String gaip(memberVO vo) {
		System.out.println("BoardController.gaip()");
		
		service.gaip(vo);
		
		return "redirect:login.do";
	} 
	
}
