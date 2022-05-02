package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Board;
import com.example.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList= boardService.getBoardList(board);
				
				model.addAttribute("boardList", boardList);
				return "getBoardList";
	} //End of getBoardList() 
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	} //End of insertBoardView() : 글 등록 화면으로 이동하는 메소드(Get방식)
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	} //End of insertBoard() : POST방식으로 '/insertBoard'요청이 들어왔을 때 실행되어 실제로 글 등록을 처리하는 메소드
	
	@GetMapping("/getBoard")
	 public String getBoard(Board board, Model model) { //getBoard() 메소드는 BoardService 컴포넌트의 getBoard()메소드를 호출하여 검색한 Board 엔티티를
		 model.addAttribute("board", boardService.getBoard(board));  //Model에 "board"라는 이름으로 저장. 
		 return "getBoard"; //그리고 "getBoard"문자열을 리턴하여 글 상세화면(getBoard.jsp)로 이동하도록 처리.
	 } //End of getBoard()
	
	@RequestMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
		}
	
	@GetMapping("/hello") //브라우저로부터 GET방식의 '/hello' 요청이 들어오면 hello() 메소드가 실행되도록 GetMapping("/hello") 설정 추가.
	public void hello(Model model) { //hello()메소드는 매개변수로 받은 Model객체에 문자열로 간단한 환영메세지를 저장. 
		model.addAttribute("greeting","Hello, Moonstar ! this is thymeleaf");
	}
}
