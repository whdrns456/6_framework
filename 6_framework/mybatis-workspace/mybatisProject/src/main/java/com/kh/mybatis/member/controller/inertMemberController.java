package com.kh.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.service.MemberServiceImpl;

/**
 * Servlet implementation class inertMemberController
 */
@WebServlet("/insert.me")
public class inertMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inertMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			
			String userId = request.getParameter("userId");
			String userPwd = request.getParameter("userPwd");
			String userName = request.getParameter("userName");
			String email = request.getParameter("email");
			String birthday = request.getParameter("birthday");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			Member m = new Member();
			
			m.setUserId(userId);
			m.setUserPwd(userPwd);
			m.setUserName(userName);
			m.setEmail(email);
			m.setBirthday(birthday);
			m.setGender(gender);
			m.setPhone(phone);
			m.setAddress(address);
			
			int result = new MemberServiceImpl().insertMember(m);
			
			if(result > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "추가 성공");
				
				 response.sendRedirect(request.getContextPath());
			}else {
				 request.setAttribute("errorMsg", "회원 가입 실패");
				 request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);  
			}
			
			
		
	}

}
