package com.cafe24.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		
		String pg1 = request.getParameter("pg");
//		
		if(pg1 == null) {
			pg1 = "1";
		}
		
		int pg = Integer.parseInt(pg1); //limit pg , 5 
		


				
		BoardDao dao = new BoardDao();
		
		List<BoardVo> list = dao.getList(pg);
//		List<BoardVo> list = dao.getList();
		
		int totalA = dao.getTotalA(); // 게시글 총 갯수 
		
		
		int totalP = (totalA+2) /3; //총페이지
//
		int startPage = (pg-1)/3*3+1; //시작번호
		int endPage = startPage + 2; //끝번호 
//		
		if(totalP < endPage) endPage = totalP;
		
		
		request.setAttribute( "list", list );
		request.setAttribute("pg", pg);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalP", totalP);
		
		WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
		

	}

}
