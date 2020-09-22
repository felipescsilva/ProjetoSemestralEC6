package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Conta.Conta;

public class ContaDAO {
	ConexaoDAO con;
	public boolean Inserir(Conta contaObjeto) throws Exception {
		String dataAbertura = contaObjeto.getDataAbertura().getDayOfMonth() + "/" + contaObjeto.getDataAbertura().getMonthValue() + "/" + contaObjeto.getDataAbertura().getYear();
		con = new ConexaoDAO();
		String SQL = "exec dbo.sp_InsertConta ?, ?, ?, ?, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, contaObjeto.getNumeroConta());
		ps.setString(2, contaObjeto.getCPF());
		ps.setDouble(3, contaObjeto.getSaldo());
		ps.setString(4, dataAbertura);
		ps.setString(5, contaObjeto.getSenhaConta());
		ps.setString(6, contaObjeto.getSenhaApp());
		
		if (ps.executeUpdate() > 0)
			return true;
		return false;
	}
	
	public boolean Atualizar(Conta contaObjeto) throws Exception {
		con = new ConexaoDAO();
		String SQL = "exec dbo.sp_UpdateConta ?, ?, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, contaObjeto.getNumeroConta());
		ps.setDouble(2, contaObjeto.getSaldo());
		ps.setString(3, contaObjeto.getSenhaConta());
		ps.setString(4, contaObjeto.getSenhaApp());
		
		if (ps.executeUpdate() > 0)
			return true;
		return false;
	}
	
	public boolean Remover(String numConta) throws Exception {
		con = new ConexaoDAO();
		String SQL = "delete from dbo.tblConta where NumConta = ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, numConta);
		
		if (ps.executeUpdate() > 0)
			return true;
		return false;
	}
	
	public List<Conta> Consultar(String campo, String valor) throws Exception {
		List<Conta> lista = new ArrayList<Conta>();
		
		con = new ConexaoDAO();
		String SQL = "exec dbo.sp_consulta tblConta, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, campo);
		ps.setString(2, valor);
		ResultSet rs = ps.executeQuery();
		
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
		return lista;
	}
}
