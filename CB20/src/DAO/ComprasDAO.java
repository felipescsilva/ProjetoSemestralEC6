package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Compras.Compras;

public class ComprasDAO {
	ConexaoDAO con;
	public boolean Inserir(Compras comprasObjeto) {
		PreparedStatement ps = null;
		try {
			
			String data = comprasObjeto.getData().getDayOfMonth() + "/" + comprasObjeto.getData().getMonthValue() + "/" + comprasObjeto.getData().getYear();
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_InsertCompras ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, comprasObjeto.getNumCartao());
			ps.setString(2, comprasObjeto.getDescricao());
			ps.setDouble(3, comprasObjeto.getValor());
			ps.setString(4, data);
			
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
	
	public boolean Atualizar(Compras comprasObjeto) {
		PreparedStatement ps = null;
		try {
			
			String data = comprasObjeto.getData().getDayOfMonth() + "/" + comprasObjeto.getData().getMonthValue() + "/" + comprasObjeto.getData().getYear();
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_UpdateCompras ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, comprasObjeto.getNumCartao());
			ps.setString(2, comprasObjeto.getDescricao());
			ps.setDouble(3, comprasObjeto.getValor());
			ps.setString(4, data);
			
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
	
	public boolean Remover(String idCompras) {
		PreparedStatement ps = null;
		try {
		con = new ConexaoDAO();
		String SQL = "delete from dbo.tblCompras where idCompras = ?";
		ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, idCompras);
		
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
	
	public List<Compras> Consultar(String campo, String valor) throws Exception {
		List<Compras> lista = new ArrayList<Compras>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblCompras, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Compras compras = new Compras();
				
				compras.setData(LocalDate.parse(rs.getDate("Data").toString()));
				compras.setDescricao(rs.getString("Descricao"));
				compras.setIdCompras(rs.getInt("idCompras"));
				compras.setNumCartao(rs.getString("NumCartao"));
				compras.setValor(rs.getDouble("Valor"));
				
				lista.add(compras);
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
		
		return lista;
	}
}
