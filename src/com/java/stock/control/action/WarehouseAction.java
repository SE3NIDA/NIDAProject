package com.java.stock.control.action;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;

import com.java.stock.common.util.ServiceFinder;
import com.java.stock.common.util.WharehouseBean;
import com.java.stock.model.dao.EmployeeDao;
import com.java.stock.model.dao.WarehouseDao;
import com.java.stock.model.entity.Employee;
import com.java.stock.model.entity.Warehouse;
import com.sun.xml.internal.ws.developer.Stateful;



@SessionScoped
@Stateful
public class WarehouseAction implements Serializable {  
	
	private String  id;
	private String waName;
	private String waLocate;
	private String waTel;
	private String waEmail;
	private String waStatus;
	
	
	private List<WharehouseBean> warehouseList;  
	
	private HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
	private WarehouseDao warDao =(WarehouseDao)ServiceFinder.findBean("wharehouseSpringDAO");  
	
	public WarehouseAction(){
		warehouseList = new  ArrayList<WharehouseBean>();  
		//searchAction();
	}
	
	
	public void saveAction() {
		
        try {
        		Warehouse wah = new Warehouse();
        			wah.setWaId(new Long(this.getId()));
        			wah.setWaName(this.getWaName());
        			wah.setWaLocate(this.getWaLocate());
        			wah.setWaTel(this.getWaTel());
        			wah.setWaEmail(this.getWaEmail());
        			wah.setWaStatus(this.getWaStatus());
        			wah.setWaCredate(new Date());
        			wah.setWaUpdate(new Date());
        			Employee emps = (Employee) session.getAttribute("employeeLogin");
        			wah.setWaUpby(String.valueOf(emps.getEmpId()));
        		
        			
        			warDao.addnewWharehouse(wah);
        		
        			FacesMessage  msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Success !", "");
        			FacesContext.getCurrentInstance().addMessage(null, msg);
        	
        //	ServiceFinder.gotoPage("ui/home.jsf");
        	
        } catch (DataAccessException e) {
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Error !", "");
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch(SQLException ex){
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Save Error !", "");
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        }
 
    }
	
	public void searchAction() {
        try {
        	warehouseList = new  ArrayList<WharehouseBean>();  
        	List<Warehouse> wah = null;
        		if(this.getWaStatus().equals("0")){
        			 wah = warDao.searchWherehouse();
        		}else if(this.getWaStatus().equals("1")){
        			if(null == this.getId() || this.getId().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "กรูณา กรอก รหัสคลังสินค้า", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				 wah = warDao.searchWherehouse(new Long(this.getId()), null);
        			}
        			
        		}else if(this.getWaStatus().equals("2")){
        			if(null == this.getId() || this.getId().equals("")){
        				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "กรูณา กรอก รหัสคลังสินค้า", "");
        	        	FacesContext.getCurrentInstance().addMessage(null, msg);
        			}else{
        				wah = warDao.searchWherehouse(0, this.getId());
        			}
        		}
        		WharehouseBean warB;	
        	if(null != wah){
        		for(Warehouse wa : wah){
        			warB = new WharehouseBean(String.valueOf(wa.getWaId()),wa.getWaName(),wa.getWaLocate(),wa.getWaTel()
        					,wa.getWaEmail(),wa.getWaStatus(),wa.getWaCredate(), wa.getWaUpdate(),wa.getWaUpby());
        			warehouseList.add(warB);
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
	
	
	
	public void reset() {  
        RequestContext.getCurrentInstance().reset("form:panel");  
    }
	
	public void genID() {  
		try {
			long wah = warDao.maxWharehouseId();
			this.setId(String.valueOf(wah+1));
		} catch (DataAccessException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Genarate ID Error !", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (SQLException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Genarate ID Error !", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
    }
	
	public void onEdit(RowEditEvent event) {  
		
		WharehouseBean whaBean = (WharehouseBean) event.getObject();
	
				try {
					Warehouse wah = new Warehouse();
						wah.setWaId(new Long(whaBean.getId()));
						wah.setWaName(whaBean.getWaName());
						wah.setWaLocate(whaBean.getWaLocate());
						wah.setWaTel(whaBean.getWaTel());
						wah.setWaEmail(whaBean.getWaEmail());
						wah.setWaStatus(whaBean.getWaStatus());
						wah.setWaCredate(whaBean.getCreatDate());
						wah.setWaUpdate(new Date());
						Employee emps = (Employee) session.getAttribute("employeeLogin");
						wah.setWaUpby(String.valueOf(emps.getEmpId()));
					
					warDao.addnewWharehouse(wah);
				} catch (DataAccessException e) {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "แก้ไขข้อมูลคลังสินค้า Error !", whaBean.getWaName());
					FacesContext.getCurrentInstance().addMessage(null, msg);
				} catch (SQLException e) {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "แก้ไขข้อมูลคลังสินค้า Error !", whaBean.getWaName());
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
	
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "แก้ไขข้อมูลคลังสินค้า  Success", whaBean.getWaName());
				FacesContext.getCurrentInstance().addMessage(null, msg);
    }  
      
    public void onCancel(RowEditEvent event) {  
    	FacesMessage msg = new FacesMessage("ยกเลิกการแก้ไขข้อมูล ", ((WharehouseBean) event.getObject()).getWaName());  
    	FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWaName() {
		return waName;
	}
	public void setWaName(String waName) {
		this.waName = waName;
	}
	public String getWaLocate() {
		return waLocate;
	}
	public void setWaLocate(String waLocate) {
		this.waLocate = waLocate;
	}
	public String getWaTel() {
		return waTel;
	}
	public void setWaTel(String waTel) {
		this.waTel = waTel;
	}
	public String getWaEmail() {
		return waEmail;
	}
	public void setWaEmail(String waEmail) {
		this.waEmail = waEmail;
	}
	public String getWaStatus() {
		return waStatus;
	}
	public void setWaStatus(String waStatus) {
		this.waStatus = waStatus;
	}

	public List<WharehouseBean> getWarehouseList() {
		return warehouseList;
	}

	
	
	

}
