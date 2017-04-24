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
	 * http://localhost:8080/SimpleAttendSystem/getAttendList
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
	 * http://localhost:8080/SimpleAttendSystem/addAttend
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		attend.setAttendType(Integer.valueOf(request.getParameter("attendType")));
		this.attendService.addAttend(attend);
		return new ModelAndView("redirect:/getAttendList");
	}

	/**
	 * http://localhost:8080/SimpleAttendSystem/editAttend
	 * @param attend
	 * @return
	 */
	@RequestMapping("/editAttend")
	public ModelAndView editAttendList(HttpServletRequest request) {
		Attend attend = new Attend();
		attend.setId(Integer.valueOf(request.getParameter("id")));
		attend.setEmpid(Integer.valueOf(request.getParameter("empid")));
		try {
			attend.setAttendDate(DateFactory.getDate(request.getParameter("attendDate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		attend.setAttendType(Integer.valueOf(request.getParameter("attendType")));
		this.attendService.editAttend(attend);
		return new ModelAndView("redirect:/getAttendList");
	}
	
	/**
	 * http://localhost:8080/SimpleAttendSystem/deleteAttend
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteAttend")
	public ModelAndView testedit(int id){
		this.attendService.deleteAttend(id);
		return new ModelAndView("redirect:/getAttendList");
	}
}
