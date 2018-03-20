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

public class ReplyActionForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		

		
		Long groupNo = Long.parseLong(request.getParameter("groupNo"));
		Long orderNo = Long.parseLong(request.getParameter("orderNo"));
		Long depth = Long.parseLong(request.getParameter("depth"));
		Long user_no = Long.parseLong(request.getParameter("user_no"));
		
		
		
		request.setAttribute("groupNo", groupNo);
		request.setAttribute("orderNo", orderNo);
		request.setAttribute("depth", depth);
		request.setAttribute("user_no", user_no);
		System.out.println("replyforomaction : gr , or , de : " + groupNo + orderNo + depth + user_no);
				
		
		WebUtil.forward( request, response, "/WEB-INF/views/board/replyform.jsp" );
	}

}
