package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cambio.Cambio;
import model.Cambio.Moeda;

public class CambioDAO {
	ConexaoDAO con;
	public boolean Inserir(Cambio cambioObjeto) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String dataSolicitacao = cambioObjeto.getDataSolicitacao().getDayOfMonth() + "/" + cambioObjeto.getDataSolicitacao().getMonthValue() + "/" + cambioObjeto.getDataSolicitacao().getYear();
			String dataValidade = cambioObjeto.getDataValidade().getDayOfMonth() + "/" + cambioObjeto.getDataValidade().getMonthValue() + "/" + cambioObjeto.getDataValidade().getYear();
			String SQL = "exec dbo.sp_InsertCambio ?, ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, cambioObjeto.getCpf());
			ps.setDouble(2, cambioObjeto.getValor());
			ps.setString(3, cambioObjeto.getMoeda().toString());
			ps.setString(4, cambioObjeto.getDescricao());
			ps.setString(5, dataSolicitacao);
			ps.setString(6, dataValidade);
			
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
	
	public boolean Atualizar(Cambio cambioObjeto) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String dataSolicitacao = cambioObjeto.getDataSolicitacao().getDayOfMonth() + "/" + cambioObjeto.getDataSolicitacao().getMonthValue() + "/" + cambioObjeto.getDataSolicitacao().getYear();
			String dataValidade = cambioObjeto.getDataValidade().getDayOfMonth() + "/" + cambioObjeto.getDataValidade().getMonthValue() + "/" + cambioObjeto.getDataValidade().getYear();
			String SQL = "exec dbo.sp_UpdateCambio ?, ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setInt(1, cambioObjeto.getIdCampo());
			ps.setDouble(2, cambioObjeto.getValor());
			ps.setString(3, cambioObjeto.getMoeda().toString());
			ps.setString(4, cambioObjeto.getDescricao());
			ps.setString(5, dataSolicitacao);
			ps.setString(6, dataValidade);
			
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
	
	public boolean Remover(String idCambio) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "delete from dbo.tblCambio where idCambio = ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, idCambio);
			
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
	
	public List<Cambio> Consultar(String campo, String valor) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Cambio> cambios = new ArrayList<Cambio>();
		try {
			
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblCambio, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Cambio cambio = new Cambio();
				
				cambio.setCpf(rs.getString("CPF"));
				cambio.setDataSolicitacao(LocalDate.parse(rs.getDate("DataSolicitacao").toString()));
				cambio.setDescricao(rs.getString("Descricao"));
				cambio.setIdCampo(rs.getInt("idCambio"));
				cambio.setMoeda(Moeda.valueOf(rs.getString("Moeda")));
				cambio.setValidade(LocalDate.parse(rs.getDate("DataValidade").toString()));
				cambio.setValor(rs.getFloat("Valor"));
				
				
				cambios.add(cambio);
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
		return cambios;
	}
	
	public List<Cambio> Consultar() {
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Cambio> cambios = new ArrayList<Cambio>();
		try {
			
			con = new ConexaoDAO();
			String SQL = "select * from tblCambio";
			ps = con.getConexao().prepareStatement(SQL);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Cambio cambio = new Cambio();
				
				cambio.setCpf(rs.getString("CPF"));
				cambio.setDataSolicitacao(LocalDate.parse(rs.getDate("DataSolicitacao").toString()));
				cambio.setDescricao(rs.getString("Descricao"));
				cambio.setIdCampo(rs.getInt("idCambio"));
				cambio.setMoeda(Moeda.valueOf(rs.getString("Moeda")));
				cambio.setValidade(LocalDate.parse(rs.getDate("DataValidade").toString()));
				cambio.setValor(rs.getFloat("Valor"));
				
				
				cambios.add(cambio);
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
		return cambios;
	}
}
