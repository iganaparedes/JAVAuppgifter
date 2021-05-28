package com.example.demo.database;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.demo.beans.BearBeans;


public class SQLconnection {

	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;

	public static boolean connectSQL() {

		try {

			// driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception ex) {
			System.out.println("Exception Driver " + ex.getMessage());
			return false;
		}

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/slutuppgift", DatabaseLogin.getuName(),
					DatabaseLogin.getuPass());

			return true;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}

	}

	public static ArrayList<BearBeans> stateSQL(String bearAttribute, ArrayList<BearBeans> bearList) {

		try {
			String requestQuery = "SELECT `Character`, `Origin`, `Creator`, `Notes`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17` FROM `bearbase` WHERE `Character` LIKE ? OR `Origin` LIKE ? OR `Creator` LIKE ? OR `Notes` LIKE ?";

			System.out.println(requestQuery);

			stmt = conn.prepareStatement(requestQuery);

			stmt.setString(1, "%" + bearAttribute + "%");
			stmt.setString(2, "%" + bearAttribute + "%");
			stmt.setString(3, "%" + bearAttribute + "%");
			stmt.setString(4, "%" + bearAttribute + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				BearBeans bears = new BearBeans();

				bears.setColumn1(rs.getString(1));
				bears.setColumn2(rs.getString(2));
				bears.setColumn3(rs.getString(3));
				bears.setColumn4(rs.getString(4));
				bears.setColumn5(rs.getString(5));
				bears.setColumn6(rs.getString(6));
				bears.setColumn7(rs.getString(7));
				bears.setColumn8(rs.getString(8));
				bears.setColumn9(rs.getString(9));
				bears.setColumn10(rs.getString(10));
				bears.setColumn11(rs.getString(11));
				bears.setColumn12(rs.getString(12));
				bears.setColumn13(rs.getString(13));
				bears.setColumn14(rs.getString(14));
				bears.setColumn15(rs.getString(15));
				bears.setColumn16(rs.getString(16));
				bears.setColumn17(rs.getString(17));

				bearList.add(bears);
				
			}rs.close();
			return bearList;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		try {

			String requestQuery2 = "SELECT `name`, `description`, `Column_3`, `Column_4`, `Column_5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17` FROM `ikea_names` WHERE `name` LIKE ? OR `description` LIKE ? OR `Column_3` LIKE ? OR `Column_4` LIKE ? OR `Column_5` LIKE ?";

			System.out.println(requestQuery2);

			stmt = conn.prepareStatement(requestQuery2);

			stmt.setString(1, "%" + bearAttribute + "%");
			stmt.setString(2, "%" + bearAttribute + "%");
			stmt.setString(3, "%" + bearAttribute + "%");
			stmt.setString(4, "%" + bearAttribute + "%");
			stmt.setString(5, "%" + bearAttribute + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				BearBeans bears = new BearBeans();

				bears.setColumn1(rs.getString(1));
				bears.setColumn2(rs.getString(2));
				bears.setColumn3(rs.getString(3));
				bears.setColumn4(rs.getString(4));
				bears.setColumn5(rs.getString(5));
				bears.setColumn6(rs.getString(6));
				bears.setColumn7(rs.getString(7));
				bears.setColumn8(rs.getString(8));
				bears.setColumn9(rs.getString(9));
				bears.setColumn10(rs.getString(10));
				bears.setColumn11(rs.getString(11));
				bears.setColumn12(rs.getString(12));
				bears.setColumn13(rs.getString(13));
				bears.setColumn14(rs.getString(14));
				bears.setColumn15(rs.getString(15));
				bears.setColumn16(rs.getString(16));
				bears.setColumn17(rs.getString(17));

				bearList.add(bears);
			}
				rs.close();
				conn.endRequest();
				conn.close();
				return bearList;
			
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			
		}
	

		return null;

	}
}