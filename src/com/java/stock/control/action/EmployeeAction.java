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
import com.java.stock.model.entity.Employee;

public class EmployeeAction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String  id;
	private String fName;
	private String lName;
	private String addrs;
	private String email;
	private String emptel;
	private String position;
	private double salary;
	private Date strDate;
	private String status;
	
	private List<EmployeeBean> theEmployeeList;
	
	private FacesContext context = FacesContext.getCurrentInstance();  
	private HttpSession session = ( HttpSession ) context.getExternalContext().getSession( true );
	private EmployeeDao empDao =(EmployeeDao)ServiceFinder.findBean("employeeSpringDAO");  
	
	public EmployeeAction(){
		theEmployeeList = new  ArrayList<EmployeeBean>();  
		//searchAction();
	}
	
	public void saveAction() throws SQLException {
        try {
        	
        	Employee emp = new Employee();
        		emp.setEmpId(new Long(this.getId()));
        		emp.setEmpFname(this.getfName());
        		emp.setEmpLname(this.getlName());
        		emp.setEmpAddr(this.getAddrs());
        		emp.setEmpEmail(this.getEmail());
        		emp.setEmpTel(this.getEmptel());
        		emp.setEmpPosition(this.getPosition());
        		emp.setEmpSalary(new BigDecimal(this.getSalary()));
        		emp.setEmpStrdate(this.getStrDate());
        		emp.setEmpStatus(this.getStatus());
        		
        		Employee emps = (Employee) session.getAttribute("employeeLogin");
        		
        		emp.setWarehouse(emps.getWarehouse());
        		
        		
        		empDao.addnewEmp(emp);
        		
        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Success", "");
	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        	
        //	ServiceFinder.gotoPage("ui/home.jsf");
        	
        } catch (DataAccessException e) {
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Error", "");
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        }   
 
    }
	public void searchAction() {
        try {
        	theEmployeeList = new  ArrayList<EmployeeBean>();  
        	List<Employee> wah = null;
        		if(this.getStatus().equals("0")){
        			 wah = empDao.searchEmployee();
        		}else if(this.getStatus().equals("1")){
        			if(null == this.getId() || this.getId().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please full in ID", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				 wah = empDao.searchEmployee(new Long(id), null);
        			}
        			
        		}else if(this.getStatus().equals("2")){
        			if(null == this.getId() || this.getId().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please full in Name", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				wah = empDao.searchEmployee(0, this.getId());
        			}
        		}
        		EmployeeBean warB;	
        		/*
        		 * EmployeeBean(String emp_id,String emp_name
			,String emp_lname,String emp_addr,String emp_email
			,String emp_tel,String emp_position,double emp_salary
			,Date emp_strdate,String emp_state)
        		 */
        	if(null != wah){
        		for(Employee wa : wah){
        			String state = null;
        			if(wa.getEmpStatus().equals("ACT"))
						state = "Active";
					else if(wa.getEmpStatus().equals("WAI"))
						state = "Waite";
					else if(wa.getEmpStatus().equals("DEL"))
						state = "Delete";
        			
        			warB = new EmployeeBean(String.valueOf(wa.getEmpId()),wa.getEmpFname(),wa.getEmpLname(),wa.getEmpAddr(),wa.getEmpEmail()
        					,wa.getEmpTel(),wa.getEmpPosition(),wa.getEmpSalary().doubleValue(), wa.getEmpStrdate(),state,null,null,null);
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
		
		EmployeeBean whaBean = (EmployeeBean) event.getObject();
	
		try {
			Employee emp =  empDao.searchEmployeeByID(new Long(whaBean.getEMP_ID()));
			
			emp.setEmpAddr(whaBean.getEMP_ADDR());
			emp.setEmpEmail(whaBean.getEMP_EMAIL());
			emp.setEmpFname(whaBean.getEMP_FNAME());
			emp.setEmpLname(whaBean.getEMP_LNAME());
			emp.setEmpTel(whaBean.getEMP_TEL());
			emp.setEmpPosition(whaBean.getEMP_POSITION());
			emp.setEmpStatus(whaBean.getEMP_STATE());
			emp.setEmpSalary(new BigDecimal(whaBean.getEMP_SALARY()));
			emp.setEmpStrdate(whaBean.getEMP_STRDATE());
			
			empDao.addnewEmp(emp);
			
		} catch (DataAccessException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Error !", whaBean.getEMP_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (NumberFormatException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Error !", whaBean.getEMP_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (SQLException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Error !", whaBean.getEMP_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Success !", whaBean.getEMP_FNAME());
				FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
	
	public void onCancel(RowEditEvent event) {  
	    	FacesMessage msg = new FacesMessage("Cancle", ((EmployeeBean) event.getObject()).getEMP_FNAME());  
	    	FacesContext.getCurrentInstance().addMessage(null, msg);  
	}  
	
	public void reset() {  
        RequestContext.getCurrentInstance().reset("form:panel");  
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmptel() {
		return emptel;
	}

	public void setEmptel(String emptel) {
		this.emptel = emptel;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getStrDate() {
		return strDate;
	}

	public void setStrDate(Date strDate) {
		this.strDate = strDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<EmployeeBean> getTheEmployeeList() {
		return theEmployeeList;
	}

	public void setTheEmployeeList(List<EmployeeBean> theEmployeeList) {
		this.theEmployeeList = theEmployeeList;
	}
	
	
	
	
	
	
}
