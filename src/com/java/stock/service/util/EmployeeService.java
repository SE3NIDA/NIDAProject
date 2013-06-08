package com.java.stock.service.util;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.java.stock.common.util.ServiceFinder;
import com.java.stock.model.entity.Employee;

public class EmployeeService {
	
	// name : empService
	
	private long  id;
	private String fName;
	private String lName;
	private String addrs;
	private String email;
	private String emptel;
	private String position;
	private double salary;
	private Date strDate;
	private String status;
	private long waID;
	
	private FacesContext context = FacesContext.getCurrentInstance();  
	private HttpSession session = ( HttpSession ) context.getExternalContext().getSession( true );
	
	@PostConstruct
    public void init() {
		
		
		Employee emp = (Employee) session.getAttribute("employeeLogin");
		if(null == emp){
			ServiceFinder.gotoPage("ui/login.jsf");
		}else{
			this.setfName(emp.getEmpFname());
			this.setlName(emp.getEmpLname());
		}
	}
	
	public void logout(){
		
		session.removeAttribute("employeeLogin");
		session.invalidate();
		
		ServiceFinder.gotoPage("ui/login.jsf");
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getWaID() {
		return waID;
	}
	public void setWaID(long waID) {
		this.waID = waID;
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
	
	
	

}
