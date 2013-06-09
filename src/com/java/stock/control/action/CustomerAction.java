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

import com.java.stock.common.util.CustomerBean;
import com.java.stock.common.util.EmployeeBean;
import com.java.stock.common.util.ServiceFinder;
import com.java.stock.model.dao.CustomerDao;
import com.java.stock.model.dao.EmployeeDao;
import com.java.stock.model.entity.Customer;
import com.java.stock.model.entity.Employee;

public class CustomerAction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String  id;
	private String fName;
	private String lName;
	private String addrs;
	private String email;
	private String custel;
	private String position;
	private String remark;
	
	private List<CustomerBean> theCustomerList;
	
	private FacesContext context = FacesContext.getCurrentInstance();  
	private HttpSession session = ( HttpSession ) context.getExternalContext().getSession( true );
	private CustomerDao custDao =(CustomerDao)ServiceFinder.findBean("customerSpringDAO");  
	
	public CustomerAction(){
		ArrayList<CustomerBean> theCustomereList = new  ArrayList<CustomerBean>();  
		//searchAction();
	}
	
	public void saveAction() throws SQLException {
        try {
        	
        	System.out.println("TEST");
        	Customer cus = new Customer();
        		cus.setCusId(new Long(this.getId()));
        		cus.setCusFname(this.getfName());
        		cus.setCusLname(this.getlName());
        		cus.setCusAddrs(this.getAddrs());
        		cus.setCusEmail(this.getEmail());
        		cus.setCusTel(this.getCustel());
        		cus.setCusPosition(this.getPosition());
        		cus.setCusRemark(this.getRemark());        		
        		
        		custDao.addnewCus(cus);
        		
        		
        		
        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Success", "");
	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        
        	
        } catch (DataAccessException e) {
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Error", "");
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        }   
 
    }
	
	public void searchAction() {
        try {
        	theCustomerList = new  ArrayList<CustomerBean>();  
        	List<Customer> wah = null;
        		CustomerDao cusDao = null;
				if(this.getStatus().equals("0")){
        			 wah = cusDao.searchCustomer();
        		}else if(this.getStatus().equals("1")){
        			if(null == this.getId() || this.getId().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please full in ID", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				 wah = cusDao.searchCustomer(new Long(id), null);
        			}
        			
        		}else if(this.getStatus().equals("2")){
        			if(null == this.getId() || this.getId().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please full in Name", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				wah = cusDao.searchCustomer(0, this.getId());
        			}
        		}
        		CustomerBean warB;	
        		
        	
        	
        } catch (DataAccessException e) {
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Error !", "");
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch(SQLException ex){
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Error !", "");
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        }
 
    }
	
	private Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public void onEdit(RowEditEvent event) {  
		
		CustomerBean whaBean = (CustomerBean) event.getObject();
	
		try {
		Object cusDao = null;
		Customer cus =  ((CustomerDao) cusDao).searchCustomerByID(new Long(whaBean.getCUS_ID()));
			
			cus.setCusAddrs(whaBean.getCUS_ADDR());
			cus.setCusEmail(whaBean.getCUS_EMAIL());
			cus.setCusFname(whaBean.getCUS_FNAME());
			cus.setCusLname(whaBean.getCUS_LNAME());
			cus.setCusTel(whaBean.getCUS_TEL());
			cus.setCusPosition(whaBean.getCUS_POSITION());
			cus.setCusRemark(whaBean.getCUS_REMARK());
			
			
			((CustomerDao) cusDao).addnewCus(cus);
			
		} catch (DataAccessException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Error !", whaBean.getCUS_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (NumberFormatException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Error !", whaBean.getCUS_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (SQLException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Error !", whaBean.getCUS_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Success !", whaBean.getCUS_FNAME());
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

	

	public String getCustel() {
		return custel;
	}

	public void setCustel(String custel) {
		this.custel = custel;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<CustomerBean> getTheCustomerList() {
		return theCustomerList;
	}

	public void setTheCustomer(List<CustomerBean> theCustomerList) {
		this.theCustomerList = theCustomerList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
	
	
}
