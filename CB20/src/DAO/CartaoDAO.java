package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cartao.Status;
import model.Cambio.Moeda;
import model.Cartao.Cartao;
import model.Cartao.Motivo;
import model.Cartao.Tipo;

public class CartaoDAO {
	ConexaoDAO con;
	public boolean Inserir(Cartao cartaoObjeto){
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String dataValidade = cartaoObjeto.getDataValidade().getDayOfMonth() + "/" + cartaoObjeto.getDataValidade().getMonthValue() + "/" + cartaoObjeto.getDataValidade().getYear();
			String SQL = "exec dbo.sp_InsertCartao ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, cartaoObjeto.getNumeroCartao());
			ps.setString(2, cartaoObjeto.getNumeroConta());
			ps.setString(3, cartaoObjeto.getTipo().getDescricao());
			ps.setString(4, cartaoObjeto.getMoeda().toString());
			ps.setDouble(5, cartaoObjeto.getSaldo());
			ps.setString(6, cartaoObjeto.getStatus().getDescricao());
			ps.setDouble(7, cartaoObjeto.getLimiteTotal());
			ps.setDouble(8, cartaoObjeto.getLimiteUsado());
			ps.setString(9, cartaoObjeto.getMotivoBloqueio().getDescricao());
			ps.setString(10, cartaoObjeto.getCvv());
			ps.setString(11, dataValidade);
		
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
	
	public boolean Atualizar(Cartao cartaoObjeto) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String dataValidade = cartaoObjeto.getDataValidade().getDayOfMonth() + "/" + cartaoObjeto.getDataValidade().getMonthValue() + "/" + cartaoObjeto.getDataValidade().getYear();
			String SQL = "exec dbo.sp_UpdateCartao ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, cartaoObjeto.getNumeroCartao());
			ps.setString(2, cartaoObjeto.getTipo().getDescricao());
			ps.setString(3, cartaoObjeto.getMoeda().toString());
			ps.setDouble(4, cartaoObjeto.getSaldo());
			ps.setString(5, cartaoObjeto.getStatus().getDescricao());
			ps.setDouble(6, cartaoObjeto.getLimiteTotal());
			ps.setDouble(7, cartaoObjeto.getLimiteUsado());
			ps.setString(8, cartaoObjeto.getMotivoBloqueio().getDescricao());
			ps.setString(9, cartaoObjeto.getCvv());
			ps.setString(10, dataValidade);
			
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
	
	public boolean Remover(String numCartao) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "delete from dbo.tblCartao where NumCartao = ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, numCartao);
			
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
	
	public List<Cartao> Consultar(String campo, String valor){
		List<Cartao> cartoes = new ArrayList<Cartao>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblCartao, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Cartao cartao = new Cartao();
				cartao.setStatus(Status.valueOf(rs.getString("flagBloqueado")));
				
				cartao.setCvv(rs.getString("CVV"));
				
				cartao.setDataValidade(LocalDate.parse(rs.getDate("DataValidade").toString()));
				
				cartao.setLimiteTotal(rs.getDouble("LimiteTotal"));
				
				cartao.setLimiteUsado(rs.getDouble("LimiteUsado"));
				
				cartao.setMoeda(rs.getString("Moeda"));
				
				cartao.setMotivoBloqueio(Motivo.valueOf(rs.getString("MotivoBloqueio")));
				
				cartao.setNumeroCartao(rs.getString("NumCartao"));
				
				cartao.setNumeroConta(rs.getString("NumConta"));
				
				cartao.setSaldo(rs.getDouble("Saldo"));
				
				cartao.setTipo(Tipo.valueOf(rs.getString("Tipo")));
				
				cartoes.add(cartao);
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
		return cartoes;
	}
}
