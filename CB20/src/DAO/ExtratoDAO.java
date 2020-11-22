package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Extrato.Extrato;

public class ExtratoDAO {
	ConexaoDAO con;
	public boolean Inserir(Extrato extratoObjeto) {
		PreparedStatement ps = null;
		try {
			
			String dataTransacao = extratoObjeto.getDataTransacao().getDayOfMonth() + "/" + extratoObjeto.getDataTransacao().getMonthValue() + "/" + extratoObjeto.getDataTransacao().getYear();
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_InsertExtrato ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, extratoObjeto.getNumConta());
			ps.setDouble(2, extratoObjeto.getValor());
			ps.setString(3, dataTransacao);
			
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
	
	public boolean Atualizar(Extrato extratoObjeto) {
		PreparedStatement ps = null;
		try {
			
			String dataTransacao = extratoObjeto.getDataTransacao().getDayOfMonth() + "/" + extratoObjeto.getDataTransacao().getMonthValue() + "/" + extratoObjeto.getDataTransacao().getYear();
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_UpdateExtrato ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, extratoObjeto.getNumConta());
			ps.setDouble(2, extratoObjeto.getValor());
			ps.setString(3, dataTransacao);
			
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
	
	public boolean Remover(String idExtrato) {
		PreparedStatement ps = null;
		try {
		con = new ConexaoDAO();
		String SQL = "delete from dbo.tblExtrato where idExtrato = ?";
		ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, idExtrato);
		
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
	
	public List<Extrato> Consultar(String campo, String valor) throws Exception {
		List<Extrato> lista = new ArrayList<Extrato>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblExtrato, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Extrato extrato = new Extrato();
				
				extrato.setDataTransacao(LocalDate.parse(rs.getDate("DataTransacao").toString()));
				extrato.setIdExtrato(rs.getInt("idExtrato"));
				extrato.setNumConta(rs.getString("NumConta"));
				extrato.setValor(rs.getDouble("Valor"));
				
				lista.add(extrato);
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
