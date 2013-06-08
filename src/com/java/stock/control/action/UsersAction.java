package com.java.stock.control.action;

import java.io.Serializable;
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
import com.java.stock.service.service.EmployeeService;
import com.java.stock.service.service.UserService;



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
	private HttpSession session = ( HttpSession ) context.getExternalContext().getSession(true);
	private UserService userSerice;  
	private EmployeeService employerService;
	private  FacesMessage msg;
	
	public UsersAction(){
		theEmployeeList = new  ArrayList<EmployeeBean>();  
		//searchAction();
	}
	
	public void loginAction() {
		
        try {
        	User usr = null;
        	
        	usr = userSerice.validateUserLogin(this.getUserName(), this.getUserPass());
        	
        	if(null != usr){
        		   if(usr.getUsState().equals("ACT")){
        			   if(null != usr.getEmployee()){
        			       Employee emp = usr.getEmployee();
        			       session.setAttribute("employeeLogin", emp);
        			   }
        			ServiceFinder.gotoPage("ui/home.jsf");
        		   }else{
        			   msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "User is Lock.", "");
        			   context.addMessage(null, msg);
        		   }
        	}else{
        		msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Name or Password", "");
        		context.addMessage(null, msg);
        	}
        	
        } catch (DataAccessException e) {
        	msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Name or Password", "");
        	context.addMessage(null, msg);
        } catch (SQLException ex){
        	msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Name or Password", "");
        	context.addMessage(null, msg);
        }
 
    }
	
	public void searchAction() {
        try {
        	theEmployeeList = new  ArrayList<EmployeeBean>();  
        	List<Employee> wah = null;
        	
        		 if(this.getUserState().equals("1")){
        			if(null == this.getUserName()|| this.getUserName().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please fill in employee number", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				 wah = employerService.searchEmployee(new Long(this.getUserName()), null);
        			}
        			
        		}else if(this.getUserState().equals("2")){
        			if(null == this.getUserName() || this.getUserName().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please fill in employee Name", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				wah = employerService.searchEmployee(0, this.getUserName());
        			}
        		}
        		EmployeeBean warB;	
        		
        	if(null != wah){
        		for(Employee wa : wah){
        			String user = null , pass = null;
        			if(null != wa.getUser()){
        				user = wa.getUser().getUsName();
        				pass = wa.getUser().getUsPass();
        			}else{
        				user = "Please enter Username";
        				pass = "Please enter Password";
        			}
        			warB = new EmployeeBean(String.valueOf(wa.getEmpId()),wa.getEmpFname(),wa.getEmpLname(),wa.getEmpAddr(),wa.getEmpEmail()
        					,wa.getEmpTel(),wa.getEmpPosition(),wa.getEmpSalary().doubleValue(), wa.getEmpStrdate(),wa.getEmpStatus(),user,pass);
        			theEmployeeList.add(warB);
        		}
        	}
        	
        } catch (DataAccessException e) {
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Error !", "");
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch(SQLException ex){
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Error !", "");
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        }
 
    }
	
	public void onEdit(RowEditEvent event) {  
	//	EmployeeBean whaBean = (EmployeeBean) event.getObject();
		FacesMessage msg = new FacesMessage("Save Success !", ((EmployeeBean) event.getObject()).getEMP_ID()); 
		FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
	
	public void onCancel(RowEditEvent event) {  
    	FacesMessage msg = new FacesMessage("Cancle", ((EmployeeBean) event.getObject()).getEMP_ID());  
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
