package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	// 글쓰기 동작
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registGET() throws Exception{
		return "/board/regist";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
		logger.info("포스트");
		
		// 입력정보를 전달받아서 DB에 정보를 저장 => 서비스동작을 호출
		
		logger.info(vo+"");
		
		service.regist(vo);
		
		logger.info("글쓰기 완료!");
		
		rttr.addFlashAttribute("result", "success");
		
		//return "/board/success"; ==> 양식 다시 제출... 디비에 쌓임 
		return "redirect:/board/listAll";
	}
	
	//리스트 페이지 (get)
	@RequestMapping( value = "/listAll", method=RequestMethod.GET)
	public void listAll(Model model, @ModelAttribute("result") String result) throws Exception {
		logger.info("C : listAllGET() 호출");
		logger.info("C : 전달정보 " + result);
		
		// 서비스를 통해서 DB에 있는 모든 글정보 가져오기
		model.addAttribute("boardList", service.listALL());
	}
	
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void readGET(@RequestParam("bno") int bno, Model model) throws Exception {
		// Model : 컨트롤러가 뷰에 정보를 전달하는 객체 (Map 형태로 저장)
		
		// * 전달되는 데이터 받을 때
		// @ModelAttribute : 컨트롤러가 뷰에 정보를 전달하기위해서 사용하는 객체
		// => DTO/VO로 자주 씀
		
		//@RequestParam : request.getParameter()의 기능
		// => 자동으로 형변환 가능(문자열, 숫자, 날짜 캐스팅 가능)
		
		logger.info("C : readGET() 방식");
		
		// 전달정보 bno 저장
		logger.info(""+bno);
		
//		BoardVO vo = service.read(bno);
//		
//		logger.info(""+vo);
		
		// 서비스에 글본문 내용을 가져오는 메서드
		model.addAttribute("boardVO", service.read(bno));
	}
	
	//글 정보 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void updateGET(@RequestParam("bno") int bno, Model model) throws Exception {
		logger.info("C : modifyGET 방식");
		
		//전달받은 정보 (글번호)
		logger.info("C : 글번호 => " + bno);

		model.addAttribute("uvo", service.read(bno));

		//페이지 이동(/board/modify.jsp))
		logger.info("C : 정보 저장후 페이지 이동 /board/modify.jsp");
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String updatePOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
		logger.info("C : 정보 수정처리 updatePOST() 호출");
		
		service.modify(vo);
		
		rttr.addFlashAttribute("msg","success");
		
		return "redirect:/board/read?bno="+vo.getBno();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String deletePOST(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		logger.info("C : view 페이지에서 deletePOST");
		
		service.remove(bno);
		
		rttr.addFlashAttribute("result","삭제완료!");
		
		return "redirect:/board/listAll";
	}
}
