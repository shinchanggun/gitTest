package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	// 게시글 입력
	@Override
	public void write(BoardVO boardVO) {
		sqlSession.insert("boardMapper.insert", boardVO);
		
	}

	// 게시판 조회
	@Override
	public List<BoardVO> list() {
		return sqlSession.selectList("boardMapper.list");
	}

	// 게시물 조회
	@Override
	public BoardVO read(int bno) {
		return sqlSession.selectOne("boardMapper.read", bno);
	}

	// 게시물 수정
	@Override
	public void update(BoardVO boardVO) {
		sqlSession.update("boardMapper.update", boardVO);
		
	}

	// 게시물 삭제
	@Override
	public void delete(int bno) {
		sqlSession.delete("boardMapper.delete",bno);
		
	}

}
