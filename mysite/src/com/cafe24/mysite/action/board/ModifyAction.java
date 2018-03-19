package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
//		String no = request.getParameter("no");

		Long no = Long.parseLong(request.getParameter("no"));

		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		System.out.println( " 수정 할 번호는 ? " + no);
	
		BoardVo vo = new BoardVo();

		vo.setNo(no);
		
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDao dao = new BoardDao();
		
		dao.update(vo);
		
		
		WebUtil.redirect( request, response, "/mysite/board" );
//		WebUtil.forward( request, response, "/WEB-INF/views/board/modify.jsp" );
		
		
	}

}
