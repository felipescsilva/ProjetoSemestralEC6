package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cambio.Cambio;
import model.Cambio.Moeda;
import model.Emprestimo.Emprestimo;

public class EmprestimoDAO {
	ConexaoDAO con;
	public boolean Inserir(Emprestimo emprestimoObjeto) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String dataSolicitacao = emprestimoObjeto.getDataSolicitacao().getDayOfMonth() + "/" + emprestimoObjeto.getDataSolicitacao().getMonthValue() + "/" + emprestimoObjeto.getDataSolicitacao().getYear();
			String prazoPagamento = emprestimoObjeto.getPrazoPagamento().getDayOfMonth() + "/" + emprestimoObjeto.getPrazoPagamento().getMonthValue() + "/" + emprestimoObjeto.getPrazoPagamento().getYear();
			String SQL = "exec dbo.sp_InsertEmprestimos ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, emprestimoObjeto.getCpf());
			ps.setString(2, emprestimoObjeto.getNumConta());
			ps.setString(3, dataSolicitacao);
			ps.setDouble(4, emprestimoObjeto.getTaxaJuros());
			ps.setString(5, prazoPagamento);
			ps.setDouble(6, emprestimoObjeto.getValorTotal());
			ps.setInt(7, emprestimoObjeto.getQuantidadeParcelas());
			ps.setDouble(8, emprestimoObjeto.getValorParcelas());
			ps.setString(9,  String.valueOf(emprestimoObjeto.getIOF()));
			ps.setString(10, emprestimoObjeto.getSituacao().getDescricao());
			
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
	
	public boolean Atualizar(Emprestimo emprestimoObjeto) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String dataSolicitacao = emprestimoObjeto.getDataSolicitacao().getDayOfMonth() + "/" + emprestimoObjeto.getDataSolicitacao().getMonthValue() + "/" + emprestimoObjeto.getDataSolicitacao().getYear();
			String prazoPagamento = emprestimoObjeto.getPrazoPagamento().getDayOfMonth() + "/" + emprestimoObjeto.getPrazoPagamento().getMonthValue() + "/" + emprestimoObjeto.getPrazoPagamento().getYear();
			String SQL = "exec dbo.sp_UpdateEmprestimos ?, ?, ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setInt(1, emprestimoObjeto.getIdEmprestimo());
			ps.setString(2, dataSolicitacao);
			ps.setDouble(3, emprestimoObjeto.getTaxaJuros());
			ps.setString(4, prazoPagamento);
			ps.setDouble(5, emprestimoObjeto.getValorTotal());
			ps.setString(6,  String.valueOf(emprestimoObjeto.getIOF()));
			ps.setString(7, emprestimoObjeto.getSituacao().getDescricao());
			
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
	
	public boolean Remover(String idEmprestimo) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "delete from dbo.tblEmprestimos where idEmprestimo = ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, idEmprestimo);
			
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
	
	public List<Emprestimo> Consultar(String campo, String valor) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		try {
			
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblEmprestimos, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Emprestimo emprestimo = new Emprestimo();
				
				emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
				emprestimo.setCpf(rs.getString("CPF"));
				emprestimo.setNumConta(rs.getString("NumConta"));
				emprestimo.setDataSolicitacao(LocalDate.parse(rs.getDate("DataSolicitacao").toString()));
				emprestimo.setTaxaJuros(Float.valueOf(rs.getString("TaxaJuros")));
				emprestimo.setPrazoPagamento(LocalDate.parse(rs.getDate("PrazoPagamento").toString()));
				emprestimo.setValorTotal(rs.getFloat("ValorTotal"));
				emprestimo.setQuantidadeParcelas(rs.getInt("QuantParcelas"));
				emprestimo.setValorParcelas(rs.getFloat("ValorParcelas"));
				emprestimo.setIOF(Float.valueOf(rs.getString("IOF")));
				emprestimo.setSituacao(rs.getString("Situacao"));
				
				
				emprestimos.add(emprestimo);
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
		return emprestimos;
	}
	
	public List<Emprestimo> Consultar() {
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		try {
			
			con = new ConexaoDAO();
			String SQL = "select * from tblEmprestimos";
			ps = con.getConexao().prepareStatement(SQL);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Emprestimo emprestimo = new Emprestimo();
				
				emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
				emprestimo.setCpf(rs.getString("CPF"));
				emprestimo.setNumConta(rs.getString("NumConta"));
				emprestimo.setDataSolicitacao(LocalDate.parse(rs.getDate("DataSolicitacao").toString()));
				emprestimo.setTaxaJuros(Float.valueOf(rs.getString("TaxaJuros")));
				emprestimo.setPrazoPagamento(LocalDate.parse(rs.getDate("PrazoPagamento").toString()));
				emprestimo.setValorTotal(rs.getFloat("ValorTotal"));
				emprestimo.setQuantidadeParcelas(rs.getInt("QuantParcelas"));
				emprestimo.setValorParcelas(rs.getFloat("ValorParcelas"));
				emprestimo.setIOF(Float.valueOf(rs.getString("IOF")));
				emprestimo.setSituacao(rs.getString("Situacao"));
				
				
				emprestimos.add(emprestimo);
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
		return emprestimos;
	}
	
}