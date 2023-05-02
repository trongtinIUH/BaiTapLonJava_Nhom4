package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import connectDB.ConnectDB;

public class PhatSinhMa_DAO {
	

	public String generateRandomKH() {
		String prefix = "KH";
		int maxNumber = 999999;
		int randomNum = new Random().nextInt(maxNumber);
		String suffix = String.format("%06d", randomNum);
		return prefix + suffix;
	}
	
	public String generateRandomHopDong() {
		String prefix = "HD";
		int maxNumber = 999999;
		int randomNum = new Random().nextInt(maxNumber);
		String suffix = String.format("%06d", randomNum);
		return prefix + suffix;
	}
	
	public String generateRandomChiTietHopDong() {
		String prefix = "CTHD";
		int maxNumber = 999999;
		int randomNum = new Random().nextInt(maxNumber);
		String suffix = String.format("%06d", randomNum);
		return prefix + suffix;
	}

	public String generateRandomHoaDonXuatHang() {
		String prefix = "HDH_X";
		int maxNumber = 999999;
		int randomNum = new Random().nextInt(maxNumber);
		String suffix = String.format("%06d", randomNum);
		return prefix + suffix;
	}

}

