package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dataobject.Brand;
import dataobject.Category;
import dataobject.UnitOfMeasure;

public class UnitOfMeasureDA extends WHConnection {
	
	public Vector<UnitOfMeasure> getUnitOfMeasure() {
		String sql = "SELECT * FROM unitofmeasure";
		Vector<UnitOfMeasure> unitList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				UnitOfMeasure unit = new UnitOfMeasure(rs.getInt("id"),
						rs.getString("unitname"));
				unitList.add(unit);
			}
			return unitList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return unitList;
	}
	public UnitOfMeasure getUnitOfMeasure(int id ){
		String sql = "SELECT c.unitname  FROM unitofmesure c WHERE c.id = " + id;
		try(Connection conn = connect(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)){
			if(rs.next()){
				UnitOfMeasure unit = new UnitOfMeasure();
				
				//cat.setCategoryId(rs.getInt("categoriesid"));
				unit.setName(rs.getString("unitname"));
				//cat.setCategoryDescription(rs.getString("description"));
				return unit;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public DefaultTableModel getCategories1() {
		String sql = "SELECT * FROM unitofmeasure";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			return buildTableModel(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	
	public void insert(String name){
		String spl ="INSERT INTO unitofmeasure(unitname)"
				+ "VALUES(?)";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(spl)){
			pstmt.setString(1, name);
			//pstmt.setString(2, description);
			
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void update(String name, int categoryid){
		String sql = "UPDATE unitosmeasure SET unitname = ? "
				+ "WHERE(id = ?)";
		try(Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, name);
			//pstmt.setString(2, description);
			pstmt.setInt(3, categoryid);
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}