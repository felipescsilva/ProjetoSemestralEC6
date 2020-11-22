package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Fatura.Fatura;
import model.Fatura.FaturaEmprestimo;
import model.Fatura.Situacao;

public class FaturaEmprestimoDAO {
	ConexaoDAO con;
	public boolean Inserir(FaturaEmprestimo faturaObjeto) {
		PreparedStatement ps = null;
		try {
			
			String dataVencimento = faturaObjeto.getDataVencimento().getDayOfMonth() + "/" + faturaObjeto.getDataVencimento().getMonthValue() + "/" + faturaObjeto.getDataVencimento().getYear();
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_InsertFaturasEmprestimo ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setInt(1, faturaObjeto.getIdEmprestimo());
			ps.setString(2, dataVencimento);
			ps.setDouble(3, faturaObjeto.getValor());
			ps.setString(4, faturaObjeto.getDescricao());			
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
	
	public boolean Atualizar(FaturaEmprestimo faturaObjeto) {
		PreparedStatement ps = null;
		try {
			String dataVencimento = faturaObjeto.getDataVencimento().getDayOfMonth() + "/" + faturaObjeto.getDataVencimento().getMonthValue() + "/" + faturaObjeto.getDataVencimento().getYear();
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_UpdateFaturasEmprestimo ?, ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setInt(1, faturaObjeto.getIdFatEmp());
			ps.setInt(2, faturaObjeto.getIdEmprestimo());
			ps.setString(3, dataVencimento);
			ps.setDouble(4, faturaObjeto.getValor());			
			ps.setString(5, faturaObjeto.getDescricao());
			ps.setDouble(6, faturaObjeto.getTaxaJuros());
			
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
	
	public boolean Remover(String idFatEmp) {
		PreparedStatement ps = null;
		try {
		con = new ConexaoDAO();
		String SQL = "delete from dbo.tblFaturasEmprestimo where idFatEmp = ?";
		ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, idFatEmp);
		
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
	
	public List<FaturaEmprestimo> Consultar(String campo, String valor) throws Exception {
		List<FaturaEmprestimo> lista = new ArrayList<FaturaEmprestimo>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblFaturasEmprestimo, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				FaturaEmprestimo fatura = new FaturaEmprestimo();
	
				
				fatura.setDataVencimento(LocalDate.parse(rs.getDate("DataVencimento").toString()));
				fatura.setIdFatEmp(rs.getInt("idFatEmp"));
				fatura.setIdEmprestimo(rs.getInt("idEmprestimo"));				
				fatura.setDescricao(rs.getString("Descricao"));
				fatura.setTaxaJuros((float)rs.getDouble("TaxaJuros"));
				fatura.setValor((float)rs.getDouble("valor"));				
				
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
