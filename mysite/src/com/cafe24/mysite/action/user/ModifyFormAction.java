package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.UserDao;
import com.cafe24.mysite.vo.UserVo;

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		
		UserVo authUser = new UserDao().getName();

		
		
	/*인증 처리*/
		
//		HttpSession session = request.getSession(true);
//		session.setAttribute("authUser", authUser);
//		
//		System.out.println("asdfasdF : " +  authUser);
		
		WebUtil.forward( request, response, "/WEB-INF/views/user/modifyform.jsp" );
	}

}
