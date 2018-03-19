package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String user_no = request.getParameter("user_no");
		
		String no = request.getParameter("no");
		
		System.out.println("user_no1111 : " + user_no);
		
		System.out.println("no1111 : " + no);
		
		Long user_no1 = Long.parseLong(user_no);
		Long no1 = Long.parseLong(no);
		
		

		BoardVo vo = new BoardVo();
	
		vo.setNo(no1);
		
		vo.setUser_no(user_no1);
	

		BoardDao dao = new BoardDao();
		dao.delete( vo );

		WebUtil.redirect( request, response, "/mysite/board" );
		
	}

}
