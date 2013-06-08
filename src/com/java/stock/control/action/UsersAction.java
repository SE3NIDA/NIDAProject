package com.java.stock.control.action;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;
import com.java.stock.common.util.EmployeeBean;
import com.java.stock.common.util.ServiceFinder;
import com.java.stock.model.dao.EmployeeDao;
import com.java.stock.model.dao.UserDao;
import com.java.stock.model.entity.Employee;
import com.java.stock.model.entity.User;

public class UsersAction implements Serializable {

	private static final long serialVersionUID = 1L;

	private long userId;
	private String userName;
	private String userPass;
	private int userLevel;
	private String userState;
	private Date userCredate;
	private Date userUpdate;
	private String userUpby;

	private List<EmployeeBean> theEmployeeList;

	private FacesContext context = FacesContext.getCurrentInstance();
	private HttpSession session = (HttpSession) context.getExternalContext()
			.getSession(true);
	private EmployeeDao empDao = (EmployeeDao) ServiceFinder
			.findBean("employeeSpringDAO");
	private UserDao userDao = (UserDao) ServiceFinder.findBean("usersSpringDAO");

	public UsersAction() {
		theEmployeeList = new ArrayList<EmployeeBean>();
		// searchAction();
	}

	public void loginAction() {

		try {
			User usr = null;
			UserDao dao = (UserDao) ServiceFinder.findBean("usersSpringDAO");
			usr = dao.validateUserLogin(this.getUserName(), this.getUserPass());

			if (null != usr) {
				if (usr.getUsState().equals("ACT")) {
					if (null != usr.getEmployee()) {
						Employee emp = usr.getEmployee();
						session.setAttribute("employeeLogin", emp);
						System.out.println(usr.getUsCredate());
					}
					ServiceFinder.gotoPage("ui/home.jsf");
				} else {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"User is Lock !", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"User is Lock !", "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}

		} catch (DataAccessException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"User is Lock !", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addMessage(null, msg);
		} catch (SQLException ex) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"User is Lock !", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void searchAction() {
		try {
			theEmployeeList = new ArrayList<EmployeeBean>();
			List<Employee> wah = null;

			if (this.getUserState().equals("1")) {
				if (null == this.getUserName() || this.getUserName().equals("")) {
					FacesMessage msg = new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Please fill in employee number", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				} else {
					wah = empDao.searchEmployee(new Long(this.getUserName()),
							null);
				}

			} else if (this.getUserState().equals("2")) {
				if (null == this.getUserName() || this.getUserName().equals("")) {
					FacesMessage msg = new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Please fill in employee name", "");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				} else {
					wah = empDao.searchEmployee(0, this.getUserName());
				}
			}
			EmployeeBean warB;

			if (null != wah) {
				for (Employee wa : wah) {
				
					String user = null, pass = null, level = null, state = "select";
					if (null != wa.getUser()) {
						user = wa.getUser().getUsName();
						pass = wa.getUser().getUsPass();
							
						System.out.println(wa.getUser().getUsLevel());
						if(wa.getUser().getUsLevel().equals("1")){
							level = "Administator";
						   System.out.println("ttttt");
						}else if(wa.getUser().getUsLevel().equals("2")){
							level = "Manager";
						}else if(wa.getUser().getUsLevel().equals("3")){
							level = "Employee";
						}
					
						if(wa.getUser().getUsState().equals("ACT"))
							state = "Active";
						else if(wa.getUser().getUsState().equals("WAI"))
							state = "Waite";
						else if(wa.getUser().getUsState().equals("DEL"))
							state = "Delete";
						
					} else {
						user = "Please enter Username";
						pass = "Please enter Password";
					}
					warB = new EmployeeBean(String.valueOf(wa.getEmpId()),
							wa.getEmpFname(), wa.getEmpLname(),
							wa.getEmpAddr(), wa.getEmpEmail(), wa.getEmpTel(),
							wa.getEmpPosition(), wa.getEmpSalary()
									.doubleValue(), wa.getEmpStrdate(), state, user, pass, level);
					theEmployeeList.add(warB);
				}
			}

		} catch (DataAccessException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Save Error !", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (SQLException ex) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Save Error !", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void onEdit(RowEditEvent event) {
		EmployeeBean whaBean = (EmployeeBean) event.getObject();

		try {
		//	Employee emp = empDao.searchEmployeeByID(new Long(whaBean.getEMP_ID()));
			
			User user = new User();
			System.out.println(whaBean.getEMP_ID());
			user.setUsEmpId(new Long(whaBean.getEMP_ID()));
			user.setUsName(whaBean.getEMP_USER());
			user.setUsPass(whaBean.getEMP_PASS());
		//	user.setEmployee(emp);
			user.setUsBy("usby");
			user.setUsCredate(new Date());
			user.setUsLevel(new BigDecimal(1));
			user.setUsState(whaBean.getEMP_STATE());
			user.setUsUpddate(new Date());

			userDao.addnewUser(user);

		} catch (DataAccessException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Save Error !", whaBean.getEMP_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (NumberFormatException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Save Error !", whaBean.getEMP_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (SQLException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Save Error !", whaBean.getEMP_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Save Success !", whaBean.getEMP_FNAME());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancle",
				((EmployeeBean) event.getObject()).getEMP_ID());
		System.err.println("onCancel");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void reset() {
		RequestContext.getCurrentInstance().reset("form:panel");
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public Date getUserCredate() {
		return userCredate;
	}

	public void setUserCredate(Date userCredate) {
		this.userCredate = userCredate;
	}

	public Date getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(Date userUpdate) {
		this.userUpdate = userUpdate;
	}

	public String getUserUpby() {
		return userUpby;
	}

	public void setUserUpby(String userUpby) {
		this.userUpby = userUpby;
	}

	public List<EmployeeBean> getTheEmployeeList() {
		return theEmployeeList;
	}

	public void setTheEmployeeList(List<EmployeeBean> theEmployeeList) {
		this.theEmployeeList = theEmployeeList;
	}

}
