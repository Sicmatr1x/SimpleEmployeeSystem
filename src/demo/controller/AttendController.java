package demo.controller;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.beans.Attend;
import demo.service.AttendService;
import demo.service.DateFactory;

@Controller
public class AttendController {

	@Resource(name = "attendService")
	private AttendService attendService;

	/**
	 * http://localhost:8080/SimpleEmployeeSystem/getAttendList
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAttendList")
	public String getAttendList(HttpServletRequest request) {
		List<Attend> list = attendService.getAllAttend();
		request.getSession().setAttribute("list", list);
		return "AttendList";
	}

	/**
	 * http://localhost:8080/SimpleEmployeeSystem/addAttend?id=?&empid=?&attendDate=?&overtime=?&dayoff=?
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addAttend", method = RequestMethod.GET)
	public ModelAndView addAttend(HttpServletRequest request) {
		Attend attend = new Attend();
		attend.setId(Integer.valueOf(request.getParameter("id")));
		attend.setEmpid(Integer.valueOf(request.getParameter("empid")));
		try {
			attend.setAttendDate(DateFactory.getDate(request.getParameter("attendDate")));
			List<Attend> list = attendService.getAttendByEmpId(attend.getEmpid());
			for(Attend t : list){
				if(t.getAttendDate().equals(attend.getAttendDate())){ // 若要添加的日期已存在
					return new ModelAndView("redirect:/getAttendList");
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		attend.setOvertime(Integer.valueOf(request.getParameter("overtime")));
		attend.setDayoff(Integer.valueOf(request.getParameter("dayoff")));
		this.attendService.addAttend(attend);
		return new ModelAndView("redirect:/getAttendList");
	}
	
	/**
	 * http://localhost:8080/SimpleEmployeeSystem/addAttendBySQL
	 * 使用这条URL来返回调试用的批量添加attend记录的页面AddAttendBySQL.jsp
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addAttendBySQL", method = RequestMethod.GET)
	public String addAttendBySQL(HttpServletRequest request) {
		return "AddAttendBySQL";
	}
	
	/**
	 * http://localhost:8080/SimpleEmployeeSystem/addAttendBySQLAdd
	 * AddAttendBySQL.jsp页面上使用POST方法返回sql语句来批量添加attend记录POST到这里
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addAttendBySQLAdd", method = RequestMethod.POST)
	public ModelAndView addAttendBySQLAdd(HttpServletRequest request) {	
		String sql = request.getParameter("sql");
		System.out.println("sql=" + sql);
		try {
			this.attendService.addAttendBySQL(sql);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/getAttendList");
	}

	/**
	 * http://localhost:8080/SimpleEmployeeSystem/editAttend
	 * 
	 * @param attend
	 * @return
	 */
	@RequestMapping("/editAttend")
	public ModelAndView editAttendList(HttpServletRequest request) {
		Attend attend = new Attend();
		attend.setId(Integer.valueOf(request.getParameter("id")));
		attend.setEmpid(Integer.valueOf(request.getParameter("empid")));
//		try {
//			attend.setAttendDate(DateFactory.getDate(request.getParameter("attendDate")));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		attend.setOvertime(Integer.valueOf(request.getParameter("overtime")));
		attend.setDayoff(Integer.valueOf(request.getParameter("dayoff")));
		this.attendService.editAttend(attend);
		return new ModelAndView("redirect:/getAttendList");
	}
	
	/**
	 * http://localhost:8080/SimpleEmployeeSystem/deleteAttend
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteAttend")
	public ModelAndView testedit(int id){
		this.attendService.deleteAttend(id);
		return new ModelAndView("redirect:/getAttendList");
	}
}
