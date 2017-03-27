package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.DataBaseConnect;
import model.bean.AdminPanelBean;

public class AdminPanelDAO extends DataBaseConnect{
	private static Statement st=null;
	private static ResultSet rs=null;
	
	public ArrayList<AdminPanelBean> getListTKBaiDang() {
		ArrayList<AdminPanelBean> list = new ArrayList<AdminPanelBean>();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select NgayDang ThoiGian,count(MaBaiDang) as SoLuong from BaiDang "
					+ "WHERE ( "
					+ "NgayDang between DATEADD(mm,-1, GETDATE()) and GETDATE() "
					+ ") "
					+ "group by NgayDang");
			AdminPanelBean thongKeBean;
			while(rs.next()){
				thongKeBean = new AdminPanelBean();
				String thoiGian=rs.getString("ThoiGian");
				thoiGian = thoiGian.replaceAll("-", ",");
				thongKeBean.setCotMot(thoiGian);
				thongKeBean.setSoLuong(rs.getInt("soLuong"));
				list.add(thongKeBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<AdminPanelBean> getListTKBinhLuan() {
		ArrayList<AdminPanelBean> list = new ArrayList<AdminPanelBean>();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select NgayBinhLuan ThoiGian,count(MaBinhLuan) as SoLuong from BinhLuan "
					+ "WHERE ( "
					+ "NgayBinhLuan between DATEADD(mm,-1, GETDATE()) and GETDATE() "
					+ ") "
					+ "group by NgayBinhLuan");
			AdminPanelBean thongKeBean;
			while(rs.next()){
				thongKeBean = new AdminPanelBean();
				String thoiGian=rs.getString("ThoiGian");
				thoiGian = thoiGian.replaceAll("-", ",");
				thongKeBean.setCotMot(thoiGian);
				thongKeBean.setSoLuong(rs.getInt("soLuong"));
				list.add(thongKeBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<AdminPanelBean> getListTKYeuThich() {
		ArrayList<AdminPanelBean> list = new ArrayList<AdminPanelBean>();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select NgayThich ThoiGian,count(MaBaiDang) as SoLuong from Thich "
					+ "WHERE ( "
					+ "NgayThich between DATEADD(mm,-1, GETDATE()) and GETDATE() "
					+ ") "
					+ "group by NgayThich");
			AdminPanelBean thongKeBean;
			while(rs.next()){
				thongKeBean = new AdminPanelBean();
				String thoiGian=rs.getString("ThoiGian");
				thoiGian = thoiGian.replaceAll("-", ",");
				thongKeBean.setCotMot(thoiGian);
				thongKeBean.setSoLuong(rs.getInt("soLuong"));
				list.add(thongKeBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<AdminPanelBean> getListTKTaiKhoan() {
		ArrayList<AdminPanelBean> list = new ArrayList<AdminPanelBean>();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select NgayDangKy ThoiGian,count(Username) as SoLuong from TaiKhoan "
					+ "WHERE ( "
					+ "NgayDangKy between DATEADD(mm,-1, GETDATE()) and GETDATE() "
					+ ") "
					+ "group by NgayDangKy");
			AdminPanelBean thongKeBean;
			while(rs.next()){
				thongKeBean = new AdminPanelBean();
				String thoiGian=rs.getString("ThoiGian");
				thoiGian = thoiGian.replaceAll("-", ",");
				thongKeBean.setCotMot(thoiGian);
				thongKeBean.setSoLuong(rs.getInt("soLuong"));
				list.add(thongKeBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<AdminPanelBean> getListTKTinhThanh() {
		ArrayList<AdminPanelBean> list = new ArrayList<AdminPanelBean>();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select TenTinhThanh,count(MaBaiDang) SoLuong FROM BaiDang,DanhMuc,TinhThanh "
					+ "WHERE "
					+ "BaiDang.MaDanhMuc=DanhMuc.MaDanhMuc and BaiDang.MaTinhThanh=TinhThanh.MaTinhThanh "
					+ "and MaLoaiTin=2 "
					+ "group by TenTinhThanh "
					+ "having count(MaBaiDang) >1");
			AdminPanelBean thongKeBean;
			while(rs.next()){
				thongKeBean = new AdminPanelBean();
				thongKeBean.setCotMot(rs.getString("TenTinhThanh"));
				thongKeBean.setSoLuong(rs.getInt("soLuong"));
				list.add(thongKeBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<AdminPanelBean> getListTKDanhMuc() {
		ArrayList<AdminPanelBean> list = new ArrayList<AdminPanelBean>();
		try {
			st=getConnect().createStatement();
			rs=st.executeQuery("select TenDanhMuc,count(MaBaiDang) SoLuong FROM BaiDang,DanhMuc,TinhThanh "
					+ "WHERE "
					+ "BaiDang.MaDanhMuc=DanhMuc.MaDanhMuc and BaiDang.MaTinhThanh=TinhThanh.MaTinhThanh "
					+ "and MaLoaiTin=2 "
					+ "group by TenDanhMuc "
					+ "having count(MaBaiDang) >1");
			AdminPanelBean thongKeBean;
			while(rs.next()){
				thongKeBean = new AdminPanelBean();
				thongKeBean.setCotMot(rs.getString("TenDanhMuc"));
				thongKeBean.setSoLuong(rs.getInt("soLuong"));
				list.add(thongKeBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				getConnect().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
