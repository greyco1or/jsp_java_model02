package kr.or.ksmart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.action.MInsertProAction;
import kr.or.ksmart.action.MListProAction;
import kr.or.ksmart.forward.MActionForward;

public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MController() {
        super();
    }
    protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("2 doPro MController.java");
    	String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println(RequestURI + "<-- RequestURI MController.java");
		System.out.println(contextPath + "<-- contextPath MController.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() MController.java");
		System.out.println(command + "<-- command MController.java");
		System.out.println("----------MController.java----------------");
		System.out.println();
		MActionForward forward = null;
		MActionInterFace action = null;
		if(command.equals("/Min/m_insert_form.ksmart_m")) {
			System.out.println("3-1 /Min/m_insert_form.ksmart_m 조건문 실행");
			forward = new MActionForward();
			forward.setRedirect(false); 	//isRedirect 전역변수 초기값이 false이기 때문에 의미없는 코드
			forward.setPath("/minsert/m_insert_form.jsp");
			System.out.println(forward + "<- forward 객체참조변수");
		}else if(command.equals("/Min/m_insert_pro.ksmart_m")) {
			System.out.println("3-2 /Min/m_insert_pro.ksmart_m 조건문 실행");
			action = new MInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Mlist/m_list.ksmart_m")) {
			System.out.println("3-3 /Mlist/m_list.ksmart_m 조건문 실행");
			action = new MListProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//--- 만약에 forward 객체참조변수 담겨있는 값이 null이 아니면
		//--- 포워드 할 것인가? 리다이렉트 할것인가?
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp 이동경로]  MController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}		
		
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1-1 doGet MController.java");
		doPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1-2 doPost MController.java");
		request.setCharacterEncoding("euc-kr");
		doPro(request,response);
	}

}
