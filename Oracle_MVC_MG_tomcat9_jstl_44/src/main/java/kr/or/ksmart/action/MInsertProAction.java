package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MInsertProAction implements MActionInterFace {
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("4-1 execute MInsertProAction.java");
		String ora_id = request.getParameter("ora_id");
		String ora_pw = request.getParameter("ora_pw");
		String ora_level = request.getParameter("ora_level");
		String ora_name = request.getParameter("ora_name");
		String ora_email = request.getParameter("ora_email");
		System.out.println(ora_id + "<-- ora_id execute MInsertProAction.java");
		System.out.println(ora_pw + "<-- ora_pw execute MInsertProAction.java");
		System.out.println(ora_level + "<-- ora_level execute MInsertProAction.java");
		System.out.println(ora_name + "<-- ora_name execute MInsertProAction.java");
		System.out.println(ora_email + "<-- ora_email execute MInsertProAction.java");
		Member m = new Member();	
		m.setOra_id(ora_id);
		m.setOra_pw(ora_pw);
		m.setOra_level(ora_level);
		m.setOra_name(ora_name);
		m.setOra_email(ora_email);
		System.out.println(m + "<- m execute MInsertProAction.java");
		Mdao mdao = new Mdao();
		mdao.mInsert(m);
		
		MActionForward mf = new MActionForward();
		mf.setRedirect(true);
		mf.setPath(request.getContextPath()+"/Mlist/m_list.ksmart_m");
		
		return mf;
	}

}

//1단계 진행: get방식 또는 post방식으로 입력자료가 입력되면 잘 받아서 콘솔창에 확인한다
//2단계 진행 : DTO (예 : Member) 객체 생성 후 set메서드 들 호출해서 객체 내 셋팅
//3단계 진행 : DAO 객체 생성 후 메서드 호출 (입력처리)
//4단계 : 만약 메서드 호출 후 리턴이 있다면 리턴값을 받는다.
//5단계 : request 또는 session 객체내 셋팅 (view에 전달 하기 포함)
//6단계 진행 : MActionForward 객체 내 포워드 또는 리다이렉트 결정 및 경로 셋팅
//7단계 진행 : MActionForward 객체 주소값을 메서드 호출 한 곳(컨트롤러) 으로 리턴
