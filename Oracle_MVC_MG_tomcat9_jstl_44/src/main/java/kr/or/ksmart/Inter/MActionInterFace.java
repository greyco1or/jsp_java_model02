package kr.or.ksmart.Inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ksmart.forward.MActionForward;

public interface MActionInterFace {
	public MActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;

}
