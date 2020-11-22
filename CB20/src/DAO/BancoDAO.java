package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Banco.Banco;
import model.Emprestimo.Emprestimo;

public class BancoDAO {
	ConexaoDAO con;
	public boolean Inserir(Banco bancoObjeto) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();						
			String SQL = "exec dbo.sp_InsertBanco ?, ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setDouble(1, bancoObjeto.getPatrimonioProprio());
			ps.setDouble(2, bancoObjeto.getPatrimonioTerceiros());
			ps.setDouble(3, bancoObjeto.getFaturamento());
			ps.setDouble(4, bancoObjeto.getCustosFixos());
			ps.setDouble(5, bancoObjeto.getCustosVariaveis());
			ps.setDouble(6, bancoObjeto.getImpostos());
						
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try{
				 if(ps != null)
					 ps.close();
				 con.FecharConexao();
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		}
		
		return false;
	}
	
	public boolean Atualizar(Banco bancoObjeto) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();			
			String SQL = "exec dbo.sp_UpdateBanco ?, ?, ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setInt(1, bancoObjeto.getIdBanco());
			ps.setDouble(2, bancoObjeto.getPatrimonioProprio());
			ps.setDouble(3, bancoObjeto.getPatrimonioTerceiros());
			ps.setDouble(4, bancoObjeto.getFaturamento());
			ps.setDouble(5, bancoObjeto.getCustosFixos());
			ps.setDouble(6, bancoObjeto.getCustosVariaveis());
			ps.setDouble(7, bancoObjeto.getImpostos());
			
			if (ps.executeUpdate() > 0)
				return true;
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try{
				 if(ps != null)
					 ps.close();
				 con.FecharConexao();
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		}
		return false;
	}
	
	public boolean Remover(String idBanco) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "delete from dbo.tblBanco where idBanco = ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, idBanco);
			
			if (ps.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try{
				 if(ps != null)
					 ps.close();
				 con.FecharConexao();
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		}
		
		return false;
	}
	
	public List<Banco> Consultar(String campo, String valor) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Banco> bancos = new ArrayList<Banco>();
		try {
			
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblBanco, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Banco banco = new Banco();
				
				banco.setIdBanco(rs.getInt("idBanco"));
				banco.setPatrimonioProprio(rs.getDouble("PatrimonioProprio"));
				banco.setPatrimonioTerceiros(rs.getDouble("PatrimonioTerceiros"));
				banco.setFaturamento(rs.getDouble("Faturamento"));
				banco.setCustosFixos(rs.getDouble("CustosFixos"));
				banco.setCustosVariaveis(rs.getDouble("CustosVariaveis"));
				banco.setImpostos(rs.getDouble("Impostos"));			
				
				bancos.add(banco);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 try{
				 if (rs != null)
					 rs.close();
				 if(ps != null)
					 ps.close();
				 con.FecharConexao();
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		}
		return bancos;
	}
	
}