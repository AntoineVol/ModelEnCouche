package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class DbClientDao implements IClientDao {

	@Override
	public void save(Client c) {
		PreparedStatement pstat = null;
		Connection con = null;
		
		try {
			con = DbUtil.seConnecter();
			String str = "INSERT INTO client(nom) VALUES (?)";
			pstat = con.prepareStatement(str);
			pstat.setString(1, c.getName());
			pstat.executeUpdate();
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
	}

	@Override
	public void delete(int id) {
		PreparedStatement pstat = null;
		Connection con = null;
		
		try {
			con = DbUtil.seConnecter();
			String str = "DELETE FROM client WHERE id=?";
			pstat = con.prepareStatement(str);
			pstat.setInt(1, id);
			pstat.executeUpdate();
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
	}

	@Override
	public Client findById(int id) {
		PreparedStatement pstat = null;
		Connection con = null;
		ResultSet res = null;
		
		
		try {
			con = DbUtil.seConnecter();
			String str = "SELECT * FROM client WHERE client.id = ?;";
			pstat = con.prepareStatement(str);
			pstat.setInt(1, id);
			res = pstat.executeQuery();
			con.commit();
			Client clt = new Client();
			while(res.next()) {
				clt.setId(res.getInt(1));
				clt.setName(res.getString(2));
			}
			return clt;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DbUtil.seDeconnecter(pstat, res, con);
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
		Statement stat = null;
		Connection con = null;
		ResultSet res = null;
		List<Client> liClient = new ArrayList<Client>();
		try {
			con = DbUtil.seConnecter();
			stat = con.createStatement();
			String str = "SELECT * FROM client ";
			res = stat.executeQuery(str);
			con.commit();
			while(res.next()) {
				Client clt = new Client();
				clt.setId(res.getInt(1));
				clt.setName(res.getString(2));
				liClient.add(clt);
			}
			return liClient;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.seDeconnecter(stat, res, con);
		}
		return null;
	}

	@Override
	public void updateClient(Client c) {
		PreparedStatement pstat = null;
		Connection con = null;
		
		try {
			con = DbUtil.seConnecter();
			String str = "UPDATE client SET nom=? WHERE id=?";
			pstat = con.prepareStatement(str);
			
			pstat.setString(1, c.getName());
			pstat.setInt(2, c.getId());
			pstat.executeUpdate();
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DbUtil.seDeconnecter(pstat, null, con);
		}
		
	}
	

}
