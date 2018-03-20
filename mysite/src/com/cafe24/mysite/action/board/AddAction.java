package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String user_no = request.getParameter("no");
		System.out.println("nonono : " + user_no);
		Long user_no1 = Long.parseLong(user_no);
		
		System.out.println("nonono : " + user_no1);
		
		BoardVo vo = new BoardVo();
		
		Long textno = vo.getNo();
		
		System.out.println("text no : " + textno);
		
		BoardDao dao = new BoardDao();
		
	
		Long group_no = (long) dao.maxGroupNo();
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setGroup_no(++group_no);
		vo.setDepth((long) 1);
		vo.setOrder_no((long) 1);
		vo.setHit((long) 1);
		vo.setUser_no(user_no1);
		
	
		dao.insert(vo);
		
		
		WebUtil.redirect( request, response, "/mysite/board" );
//		WebUtil.forward( request, response, "/WEB-INF/views/user/joinsuccess.jsp" );
		
	}

}
