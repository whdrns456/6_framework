package com.kh.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.membership.MemberImpl;

import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.service.MemberServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 전달된 데이터 => 아이디, 비밀번호
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		
		Member m = new Member();
		m.setUserId(id);
		m.setUserPwd(pwd);
		
		Member loginUser = new MemberServiceImpl().loginMember(m);
		
		// 로그인 성공 = > 로그인 성공했습니다. 메세지를 띄우기 
		// 				=> session 영역에 로그인 정보 저장 
		//  		=> url 재요청(/mybatis)
		// 로그인 실패 시 => 에러페이지 응답 
		//			=> request 영역에 에러메세지 저장 
			
		HttpSession session = request.getSession();
		
		
		if(loginUser != null) {
			session.setAttribute("alertMsg", "로그인 성공했습니다");
			session.setAttribute("loginUser", loginUser );
		
			response.sendRedirect(request.getContextPath());
			
		}else {
			request.setAttribute("errorMsg", "로그인 성공했습니다");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

}
