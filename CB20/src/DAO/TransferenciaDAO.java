package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Transferencia.Transferencia;

public class TransferenciaDAO {
	ConexaoDAO con;
	public boolean Inserir(Transferencia transferenciaObjeto) {
		PreparedStatement ps = null;
		try {
			
			String dataTransacao = transferenciaObjeto.getDataTransacao().getDayOfMonth() + "/" + transferenciaObjeto.getDataTransacao().getMonthValue() + "/" + transferenciaObjeto.getDataTransacao().getYear();
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_InsertTransferencia ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, transferenciaObjeto.getCpf());
			ps.setString(2, transferenciaObjeto.getContaOrigem());
			ps.setString(3, transferenciaObjeto.getContaDestino());
			ps.setDouble(4, transferenciaObjeto.getValor());
			ps.setString(5, dataTransacao);
			
			
			
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
	
	
	public boolean Remover(String idFatura) {
		PreparedStatement ps = null;
		try {
		con = new ConexaoDAO();
		String SQL = "delete from dbo.tblfatura where idFatura = ?";
		ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, idFatura);
		
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
	
	public List<Transferencia> Consultar(String campo, String valor) throws Exception {
		List<Transferencia> lista = new ArrayList<Transferencia>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblTransferencia, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Transferencia transferencia = new Transferencia();
	
				transferencia.setContaDestino(rs.getString("ContaDestino"));
				transferencia.setContaOrigem(rs.getString("ContaOrigem"));
				transferencia.setCpf(rs.getString("CPF"));
				transferencia.setDataTransacao(LocalDate.parse(rs.getDate("DataTransacao").toString()));
				transferencia.setIdTransferencia(rs.getInt("idTransferencia"));
				transferencia.setValor(rs.getDouble("Valor"));
				
				lista.add(transferencia);
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
