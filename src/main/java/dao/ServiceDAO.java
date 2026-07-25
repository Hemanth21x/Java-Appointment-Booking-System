package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;

import model.Service;
import util.DBConnection;

public class ServiceDAO {
	
	//Get all services
	
	public List<Service> getAllServices(){
		
		List<Service> services=new ArrayList<>();
		 
		String sql="select * from services";
		try {
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				Service service = new  Service();
				
				service.setServiceId(rs.getInt("service_id"));
				service.setName(rs.getString("name"));
				service.setDurationMinutes(rs.getInt("duration_minutes"));
                service.setPrice(rs.getDouble("price"));

                services.add(service);
			}
		 
		}catch(Exception e) {
			e.printStackTrace();
		}
	return services;

}
	
	//GetServicebyid
	public Service getServiceById(int serviceId) {
		
		 Service service = null;
		 
		 String sql = "select*from services where service_id=?";
		 
		 try {
			 Connection conn =DBConnection.getConnection();
			 
			 PreparedStatement ps = conn.prepareStatement(sql);
			 
			 ps.setInt(1,serviceId);
			 
			 ResultSet rs= ps.executeQuery();
			 
			 if(rs.next()) {
				 
			    service = new Service();
				 
				service.setServiceId(rs.getInt("service_id"));
                service.setName(rs.getString("name"));
                service.setDurationMinutes(rs.getInt("duration_minutes"));
                service.setPrice(rs.getDouble("price"));
            }
				 
			 
			 
		 }catch(Exception e) {
			 e.printStackTrace();;
		 }
		 
		 return service;
		
	}
	//get total services
	
	public int getTotalServices() {
		int totalServices=0;
		
		String sql="select count(*)from services";
		
		try {
			Connection conn =DBConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				totalServices=rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return  totalServices;
		
	}
	// Add Service
	public boolean addService(Service service) {

	    boolean status = false;

	    String sql = "INSERT INTO services(name, duration_minutes, price) VALUES(?, ?, ?)";

	    try {

	        Connection conn = DBConnection.getConnection();

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, service.getName());
	        ps.setInt(2, service.getDurationMinutes());
	        ps.setDouble(3, service.getPrice());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {

	            status = true;

	        }

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return status;
	}
	// Update Service
	public boolean updateService(Service service) {

	    boolean status = false;

	    String sql = "UPDATE services SET name=?, duration_minutes=?, price=? WHERE service_id=?";

	    try {

	        Connection conn = DBConnection.getConnection();

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, service.getName());
	        ps.setInt(2, service.getDurationMinutes());
	        ps.setDouble(3, service.getPrice());
	        ps.setInt(4, service.getServiceId());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {

	            status = true;

	        }

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return status;
	}
	// Delete Service
	public boolean deleteService(int serviceId) {

	    boolean status = false;

	    String sql = "DELETE FROM services WHERE service_id = ?";

	    try {

	        Connection conn = DBConnection.getConnection();

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setInt(1, serviceId);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            status = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
}
