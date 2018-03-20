package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		BoardDao dao = new BoardDao();
		
		Long no = Long.parseLong(request.getParameter("no"));

		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		System.out.println("user_ no : " + request.getParameter("user_no"));
		
		
		Long user_no = Long.parseLong(request.getParameter("user_no"));
		Long groupNo = Long.parseLong(request.getParameter("groupNo"));
//		Long orderNo = Long.parseLong(request.getParameter("orderNo"));
//		Long depth = Long.parseLong(request.getParameter("depth"));
		
		
		
	
		
//        System.out.println(" reply action  : " +  no );
		Long orderNo = (long) dao.maxOrderNo(groupNo);
		
		Long depth = (long)dao.maxdepth(groupNo);
		
		System.out.println("gr , or , de : " + groupNo + orderNo + depth);
		
		
		BoardVo vo = new BoardVo();

		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setGroup_no(groupNo);
		vo.setOrder_no(++orderNo);
		vo.setDepth(++depth);
		vo.setHit((long) 1);
		vo.setUser_no(user_no);
		
		
		
		
//		dao.orderUpdate(vo);
		
		dao.replyInsert(vo);

		WebUtil.redirect( request, response, "/mysite/board" );
//		WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
		
	}

}
