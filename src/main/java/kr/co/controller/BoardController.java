package kr.co.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.BoardService;
import kr.co.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	//@Inject
	@Autowired
	BoardService service;

	// 게시판 글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() {
		logger.info("wirteVIew");
	}

	// 게시판 글 작성
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) {
		logger.info("write");
		service.write(boardVO);
		return "redirect:/";
	}

	// 게시판 목록 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		logger.info("list");

		model.addAttribute("list", service.list());

		return "board/list";
	}

	// 게시물 목록 조회
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(BoardVO boardVO, Model model) {
		logger.info("read");

		model.addAttribute("read", service.read(boardVO.getBno()));

		return "board/readView";
	}

	// 게시물 수정뷰
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String update(BoardVO boardVO, Model model) {
		logger.info("updateView");

		model.addAttribute("update", service.read(boardVO.getBno()));

		return "board/updateView";
	}

	// 게시물 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO) {
		logger.info("update");
		service.update(boardVO);
		return "redirect:/board/list";
	}

	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(BoardVO boardVO) {
		logger.info("delete");

		service.delete(boardVO.getBno());

		return "redirect:/board/list";
	}
}