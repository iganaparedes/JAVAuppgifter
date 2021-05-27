package com.example.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.demo.beans.BearBeans;
import com.example.demo.beans.ikeaBeans;

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

	public static ArrayList<BearBeans> stateSQL(String bearAttribute, ArrayList<BearBeans> merchants) {

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

				BearBeans merchant = new BearBeans();

				merchant.setColumn1(rs.getString(1));
				merchant.setColumn2(rs.getString(2));
				merchant.setColumn3(rs.getString(3));
				merchant.setColumn4(rs.getString(4));
				merchant.setColumn5(rs.getString(5));
				merchant.setColumn6(rs.getString(6));
				merchant.setColumn7(rs.getString(7));
				merchant.setColumn8(rs.getString(8));
				merchant.setColumn9(rs.getString(9));
				merchant.setColumn10(rs.getString(10));
				merchant.setColumn11(rs.getString(11));
				merchant.setColumn12(rs.getString(12));
				merchant.setColumn13(rs.getString(13));
				merchant.setColumn14(rs.getString(14));
				merchant.setColumn15(rs.getString(15));
				merchant.setColumn16(rs.getString(16));
				merchant.setColumn17(rs.getString(17));

				merchants.add(merchant);
			}
			rs.close();
			// conn.endRequest();
			// conn.close();
			return merchants;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;

	}

	public static ArrayList<ikeaBeans> ikeaSQL(String ikeaName, ArrayList<ikeaBeans> ikeaResults) {

		try {
			String requestQuery = "SELECT `name`, `description`, `Column_3`, `Column_4`, `Column_5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17` FROM `ikea_names` WHERE `name` LIKE ? OR `description` LIKE ? OR `Column_3` LIKE ? OR `Column_4` LIKE ? OR `Column_5` LIKE ?";

			System.out.println(requestQuery);

			stmt = conn.prepareStatement(requestQuery);

			stmt.setString(1, "%" + ikeaName + "%");
			stmt.setString(2, "%" + ikeaName + "%");
			stmt.setString(3, "%" + ikeaName + "%");
			stmt.setString(4, "%" + ikeaName + "%");
			stmt.setString(5, "%" + ikeaName + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				ikeaBeans ikea = new ikeaBeans();

				ikea.setColumn1(rs.getString(1));
				ikea.setColumn2(rs.getString(2));
				ikea.setColumn3(rs.getString(3));
				ikea.setColumn4(rs.getString(4));
				ikea.setColumn5(rs.getString(5));
				ikea.setColumn6(rs.getString(6));
				ikea.setColumn7(rs.getString(7));
				ikea.setColumn8(rs.getString(8));
				ikea.setColumn9(rs.getString(9));
				ikea.setColumn10(rs.getString(10));
				ikea.setColumn11(rs.getString(11));
				ikea.setColumn12(rs.getString(12));
				ikea.setColumn13(rs.getString(13));
				ikea.setColumn14(rs.getString(14));
				ikea.setColumn15(rs.getString(15));
				ikea.setColumn16(rs.getString(16));
				ikea.setColumn17(rs.getString(17));

				ikeaResults.add(ikea);
			}
			rs.close();
			conn.endRequest();
			conn.close();
			return ikeaResults;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;

	}
}