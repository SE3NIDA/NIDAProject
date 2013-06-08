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
import com.java.stock.service.service.EmployeeService;

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
	private  FacesMessage msg;
	private HttpSession session = ( HttpSession ) context.getExternalContext().getSession( true );
	private EmployeeService employerService;
	
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
        		
        		employerService.addnewEmp(emp);
        		
        		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Success !", "");
        		context.addMessage(null, msg);	
        } catch (DataAccessException e) {
        	msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Error !", "");
    		context.addMessage(null, msg);
        }   
 
    }
	public void searchAction() {
        try {
        	theEmployeeList = new  ArrayList<EmployeeBean>();  
        	List<Employee> wah = null;
        		if(this.getStatus().equals("0")){
        			 wah = employerService.searchEmployee();
        		}else if(this.getStatus().equals("1")){
        			if(null == this.getId() || this.getId().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please Input ID", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				 wah = employerService.searchEmployee(new Long(id), null);
        			}
        			
        		}else if(this.getStatus().equals("2")){
        			if(null == this.getId() || this.getId().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please Input Name", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				wah = employerService.searchEmployee(0, this.getId());
        			}
        		}
        		EmployeeBean warB;	
        		
        	if(null != wah){
        		for(Employee wa : wah){
        			warB = new EmployeeBean(String.valueOf(wa.getEmpId()),wa.getEmpFname(),wa.getEmpLname(),wa.getEmpAddr(),wa.getEmpEmail()
        					,wa.getEmpTel(),wa.getEmpPosition(),wa.getEmpSalary().doubleValue(), wa.getEmpStrdate(),wa.getEmpStatus(),null,null);
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
