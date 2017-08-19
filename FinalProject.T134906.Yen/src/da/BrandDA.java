package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dataobject.Brand;

public class BrandDA extends WHConnection {
	
	public Vector<Brand> getAllBrands() {
		String sql = "SELECT *FROM brand";
		Vector<Brand> brandList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Brand bra = new Brand(rs.getInt("id"), rs.getString("brandname"));
				//cat.setCategoryId(rs.getInt("categoryid"));
				//cat.setCategoryName(rs.getString("categoryname"));
				
				//categoryList.add(rs.getString("categoryname"));
				//System.out.format("%3d %-40s %7.2f %4d\n", rs.getInt("categoryid"), rs.getString("categoryname"),
//						rs.getDouble("description"));
				brandList.add(bra);
			}
			return brandList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
