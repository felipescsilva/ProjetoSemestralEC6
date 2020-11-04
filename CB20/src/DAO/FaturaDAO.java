package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Fatura.Fatura;
import model.Fatura.Situacao;

public class FaturaDAO {
	ConexaoDAO con;
	public boolean Inserir(Fatura faturaObjeto) {
		PreparedStatement ps = null;
		try {
			
			String dataVencimento = faturaObjeto.getDataVencimento().getDayOfMonth() + "/" + faturaObjeto.getDataVencimento().getMonthValue() + "/" + faturaObjeto.getDataVencimento().getYear();
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_InsertFatura ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, faturaObjeto.getNumCartao());
			ps.setString(2, dataVencimento);
			ps.setDouble(3, faturaObjeto.getValor());
			ps.setString(4, faturaObjeto.getSituacao().toString());
			ps.setDouble(5, faturaObjeto.getTaxaJuros());
			
			
			
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
	
	public boolean Atualizar(Fatura faturaObjeto) {
		PreparedStatement ps = null;
		try {
			String dataVencimento = faturaObjeto.getDataVencimento().getDayOfMonth() + "/" + faturaObjeto.getDataVencimento().getMonthValue() + "/" + faturaObjeto.getDataVencimento().getYear();
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_UpdateFatura ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, faturaObjeto.getNumCartao());
			ps.setString(2, dataVencimento);
			ps.setDouble(3, faturaObjeto.getValor());
			ps.setString(4, faturaObjeto.getSituacao().toString());
			ps.setDouble(5, faturaObjeto.getTaxaJuros());
			
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
	
	public List<Fatura> Consultar(String campo, String valor) throws Exception {
		List<Fatura> lista = new ArrayList<Fatura>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblFatura, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Fatura fatura = new Fatura();
	
				
				fatura.setDataVencimento(LocalDate.parse(rs.getDate("DataVencimento").toString()));
				fatura.setIdFatura(rs.getInt("idFatura"));
				fatura.setNumCartao(rs.getString("NumCartao"));
				fatura.setSituacao(Situacao.valueOf(rs.getString("Situacao")));
				fatura.setTaxaJuros(rs.getDouble("TaxaJuros"));
				fatura.setValor(rs.getDouble("valor"));
				
				lista.add(fatura);
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
