package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Conta.Conta;
import model.Deposito.Deposito;

public class ContaDAO {
	ConexaoDAO con;
	public boolean Inserir(Conta contaObjeto) {
		PreparedStatement ps = null;
		try {
			String dataAbertura = contaObjeto.getDataAbertura().getDayOfMonth() + "/" + contaObjeto.getDataAbertura().getMonthValue() + "/" + contaObjeto.getDataAbertura().getYear();
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_InsertConta ?, ?, ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, contaObjeto.getNumeroConta());
			ps.setString(2, contaObjeto.getCPF());
			ps.setDouble(3, contaObjeto.getSaldo());
			ps.setString(4, dataAbertura);
			ps.setString(5, contaObjeto.getSenhaConta());
			ps.setString(6, contaObjeto.getSenhaApp());
			
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
	
	public boolean Atualizar(Conta contaObjeto) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_UpdateConta ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, contaObjeto.getNumeroConta());
			ps.setDouble(2, contaObjeto.getSaldo());
			ps.setString(3, contaObjeto.getSenhaConta());
			ps.setString(4, contaObjeto.getSenhaApp());
			
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
	
	public boolean Remover(String numConta) {
		PreparedStatement ps = null;
		try {
		con = new ConexaoDAO();
		String SQL = "delete from dbo.tblConta where NumConta = ?";
		ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, numConta);
		
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
	
	public List<Conta> Consultar(String campo, String valor) throws Exception {
		List<Conta> lista = new ArrayList<Conta>();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblConta, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Conta conta = new Conta();
	
				conta.setCPF(rs.getString("CPF"));
				conta.setDataAbertura(LocalDate.parse(rs.getDate("DataAbertura").toString()));
				conta.setNumeroConta(rs.getString("NumConta"));
				conta.setSaldo(rs.getDouble("Saldo"));
				conta.setSenhaConta(rs.getString("SenhaConta"));
				conta.setSenhaApp(rs.getString("SenhaApp"));
				
				lista.add(conta);
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
	
	public boolean realizarPagamento(String codPagamento) {
		DepositoDAO dao = new DepositoDAO();
		List<Deposito> lista = dao.Consultar("linhaDigitavel", codPagamento);
		if (lista.size() == 0)
			return false;
		else {
			try {
				
				return true;
			} catch (Exception e) {
				System.out.println(e.toString());
				return false;
			}
		}
	}
}
