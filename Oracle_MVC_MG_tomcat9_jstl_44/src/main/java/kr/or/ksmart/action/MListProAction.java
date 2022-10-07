package kr.or.ksmart.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.Inter.MActionInterFace;
import kr.or.ksmart.dao.Mdao;
import kr.or.ksmart.dto.Member;
import kr.or.ksmart.forward.MActionForward;

public class MListProAction implements MActionInterFace {

	@Override
	public MActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("4-2 execute MListProAction.java");
		Mdao mdao = new Mdao();
		ArrayList<Member> alm = mdao.mAllSelect();
		System.out.println(alm + "<- alm execute MListProAction.java");
		request.setAttribute("alm", alm);
		MActionForward mf = new MActionForward();
		mf.setRedirect(false);
		mf.setPath("/mlist/m_list.jsp");
		return mf;
	}
}
//1단계 : get방식 또는 post방식으로 입력자료가 입력되면 잘 받아서 콘솔창에 확인한다
//2단계 : DTO (예 : Member) 객체 생성 후 set메서드 들 호출해서 객체 내 셋팅
//3단계 진행 : DAO 객체 생성 후 메서드 호출 (전체회원조회 처리)
//4단계 진행 : 만약 메서드 호출 후 리턴이 있다면 리턴값을 받는다.
//5단계 진행 : request 또는 session 객체내 셋팅 (view에 전달 하기 포함)
//6단계 진행 : MActionForward 객체 내 포워드 또는 리다이렉트 결정 및 경로 셋팅
//7단계 진행 : MActionForward 객체 주소값을 메서드 호출 한 곳(컨트롤러) 으로 리턴