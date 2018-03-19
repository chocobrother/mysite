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

		
		String pg1 = request.getParameter("pg");
		
		if(pg1 == null) {
			pg1 = "1";
		}
		
		int pg = Integer.parseInt(pg1);
		

		System.out.println("pg : " + pg);
				
		BoardDao dao = new BoardDao();
		
		List<BoardVo> list = dao.getList(pg);
		
		
		int totalA = dao.getTotalA();
		
		System.out.println("total count + :" + totalA);
		
		int totalP = (totalA+2) /3;

		int startPage = (pg-1)/3*3+1;
		int endPage = startPage + 2;
		
		if(totalP < endPage) endPage = totalP;
		
		
		request.setAttribute( "list", list );
		request.setAttribute("pg", pg);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalP", totalP);
		
		WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
		

	}

}
