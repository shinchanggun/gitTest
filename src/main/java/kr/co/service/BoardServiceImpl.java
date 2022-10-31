package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.BoardDAO;
import kr.co.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) {
		dao.write(boardVO);
		
	}

	@Override
	public List<BoardVO> list() {
		return dao.list();
	}

	@Override
	public BoardVO read(int bno) {
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO boardVO) {
		dao.update(boardVO);
		
	}

	@Override
	public void delete(int bno) {
		dao.delete(bno);
		
	}

}
