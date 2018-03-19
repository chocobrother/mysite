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

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Long no = Long.parseLong(request.getParameter("no"));
		
		System.out.println(" view no : " + no);
		
		BoardVo vo = new BoardVo();
		
		vo.setNo(no);

		BoardDao dao = new BoardDao();
		
		
		
		List<BoardVo> list = dao.viewList(vo);
		
		
		System.out.println("update before :  " + vo.getHit());
		
		dao.hitUpdate(vo);
		
		System.out.println("update Atfeer : " + vo.getHit());
		
		
		
		request.setAttribute( "list", list );
		
		WebUtil.forward(request, response, "/WEB-INF/views/board/view.jsp");
		
		
	}

}
