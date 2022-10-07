package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.ksmart.dto.Member;

public class Mdao {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Member m = null;
	public Mdao() {
		System.out.println("5 Mdao 생성자 메서드 실행");
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init Mdao() ");
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			System.out.println(ds + "<-- ds Mdao() ");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	//04 전체회원조회 메서드 선언
	public ArrayList<Member> mAllSelect() throws ClassNotFoundException, SQLException{
		System.out.println("4 mAllSelect Mdao.java");
		//jdbc 1~7단계
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mAllSelect Mdao.java");
		pstmt = conn.prepareStatement("select * from ORACLE_MEMBER");
		System.out.println(pstmt + "<-- pstmt");
		rs = pstmt.executeQuery();
		System.out.println(rs + "<-- rs mAllSelect Mdao.java");
		//System.out.println(rs.next() + "<-- rs.next() mAllSelect Mdao.java");
		ArrayList<Member> alm = new ArrayList<Member>();
		//System.out.println(alm + "<- alm mAllSelect Mdao.java");
		while(rs.next()) {
			//System.out.println("반복 횟수?");
			m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
			System.out.println(m + "<- m mAllSelect Mdao.java");
			alm.add(m);
			System.out.println(alm + "<- alm mAllSelect Mdao.java");
		}
		rs.close();
		pstmt.close();
		conn.close();
		return alm;
	}
	//1-2 mInsert(매개변수1개) : 입력처리 메서드 선언
	public void mInsert(Member m) throws ClassNotFoundException, SQLException {
		System.out.println("1-2 mInsert(매개변수1개) Mdao.java");
		//jdbc 1~2단계 : driver loading and DB 연결
		conn=ds.getConnection();
		System.out.println(conn + "<-- conn mInsert Mdao.java");

		pstmt = conn.prepareStatement(
				"insert into oracle_member values(?,?,?,?,?)");
		System.out.println(pstmt + "<-- pstmt 1 mInsert Mdao.java");
		System.out.println(pstmt.getClass() + "<-- pstmt.getClass() 1");
//insert into tb_member values('id001','pw001','관리자','홍01','email01');
		pstmt.setString(1, m.getOra_id());
		pstmt.setString(2, m.getOra_pw());
		pstmt.setString(3, m.getOra_level());
		pstmt.setString(4, m.getOra_name());
		pstmt.setString(5, m.getOra_email());
		System.out.println(pstmt + "<-- pstmt 2 mInsert Mdao.java");
		//jdbc 4단계 : 쿼리 실행
		int result = pstmt.executeUpdate();
		System.out.println(result + "<-- result mInsert Mdao.java");
		//jdbc 5단계 : 쿼리 실행 결과 사용(생략)
		//jdbc 6~7단계 : 객체 종료
		pstmt.close();
		conn.close();
	}

}
