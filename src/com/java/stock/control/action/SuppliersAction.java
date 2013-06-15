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
import com.java.stock.common.util.SuppliersBean;
import com.java.stock.model.dao.CustomerDao;
import com.java.stock.model.dao.EmployeeDao;
import com.java.stock.model.dao.SuppliersDao;
import com.java.stock.model.entity.Customer;
import com.java.stock.model.entity.Employee;
import com.java.stock.model.entity.Supplier;

public class SuppliersAction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String  id;
	private String fName;
	private String addrs;
	private String custel;
	private String position;
	private String remark;
	
	private List<SuppliersBean> theSupliersList;
	
	private FacesContext context = FacesContext.getCurrentInstance();  
	private HttpSession session = ( HttpSession ) context.getExternalContext().getSession( true );
	private SuppliersDao supDao =(SuppliersDao)ServiceFinder.findBean("supplierSpringDAO");  
	
	public SuppliersAction(){
		ArrayList<SuppliersBean> theSupliersList = new  ArrayList<SuppliersBean>();  
		//searchAction();
	}
	
	public void saveAction() throws SQLException {
        try {
        	
        	System.out.println("TEST");
        	Supplier sup = new Supplier();
        	sup.setSupId(new Long(this.getId()));
        	sup.setSupName(this.getfName());
        	sup.setSupAddrs(this.getAddrs());
        	sup.setSupTel(this.getCustel());
        	sup.setSupPosition(this.getPosition());
        	sup.setSupRemark(this.getRemark());        		
        		
        		supDao.addnewSup(sup);
        		
        		
        		
        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Success", "");
	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        
        	
        } catch (DataAccessException e) {
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Error", "");
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        }   
 
    }
	
	public void searchAction() {
        try {
        	theSupliersList = new  ArrayList<SuppliersBean>();  
        	List<Supplier> wah = null;
        		SuppliersDao supDao = null;
				if(this.getStatus().equals("0")){
        			 wah = supDao.searchSuppliers();
        		}else if(this.getStatus().equals("1")){
        			if(null == this.getId() || this.getId().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please full in ID", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				 wah = supDao.searchSuppliers(new Long(id), null);
        			}
        			
        		}else if(this.getStatus().equals("2")){
        			if(null == this.getId() || this.getId().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please full in Name", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				wah = supDao.searchSuppliers(0, this.getId());
        			}
        		}
        		SuppliersBean warB;	
        		
        	
        	
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
		
		SuppliersBean whaBean = (SuppliersBean) event.getObject();
	
		try {
		Object cusDao = null;
		Supplier sup =  ((SuppliersDao) supDao).searchSuppliersByID(new Long(whaBean.getSUP_ID()));
			
			sup.setSupAddrs(whaBean.getSUP_ADDR());
			sup.setSupName(whaBean.getSUP_FNAME());
			sup.setSupTel(whaBean.getSUP_TEL());
			sup.setSupPosition(whaBean.getSUP_POSITION());
			sup.setSupRemark(whaBean.getSUP_REMARK());
			
			
			((SuppliersDao) cusDao).addnewSup(sup);
			
		} catch (DataAccessException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Error !", whaBean.getSUP_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (NumberFormatException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Error !", whaBean.getSUP_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (SQLException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Error !", whaBean.getSUP_FNAME());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Success !", whaBean.getSUP_FNAME());
				FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
	
	public void onCancel(RowEditEvent event) {  
	    	FacesMessage msg = new FacesMessage("Cancle", ((SuppliersBean) event.getObject()).getSUP_FNAME());  
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



	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
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


	public List<SuppliersBean> gettheSupliersListList() {
		return theSupliersList;
	}

	public void setTheCustomer(List<SuppliersBean> theSuppliersList) {
		this.theSupliersList= theSupliersList ;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
	
	
}
