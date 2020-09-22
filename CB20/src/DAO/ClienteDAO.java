package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cliente.Cliente;
import model.Cliente.Formacao;
import model.Cliente.Profissao;

public class ClienteDAO {
	ConexaoDAO con;
	public boolean Inserir(Cliente clienteObjeto) throws Exception {
		con = new ConexaoDAO();
		String dataNascimento = clienteObjeto.getDataNascimento().getDayOfMonth() + "/" + clienteObjeto.getDataNascimento().getMonthValue() + "/" + clienteObjeto.getDataNascimento().getYear();
		String SQL = "exec dbo.sp_InsertCliente ?, ?, ?, ?, ?, ?, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, clienteObjeto.getNome());
		ps.setString(2, clienteObjeto.getCPF());
		ps.setString(3, clienteObjeto.getTelefone());
		ps.setString(4, clienteObjeto.getEmail());
		ps.setString(5, dataNascimento);
		ps.setString(6, clienteObjeto.getFormacao().getDescricao());
		ps.setString(7, clienteObjeto.getProfissao().getDescricao());
		ps.setDouble(8, clienteObjeto.getRenda());
		
		if (ps.executeUpdate() > 0)
			return true;
		return false;
	}
	
	public boolean Atualizar(Cliente clienteObjeto) throws Exception {
		con = new ConexaoDAO();
		String SQL = "exec dbo.sp_UpdateCliente ?, ?, ?, ?, ?, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, clienteObjeto.getNome());
		ps.setString(2, clienteObjeto.getCPF());
		ps.setString(3, clienteObjeto.getTelefone());
		ps.setString(4, clienteObjeto.getEmail());
		ps.setString(5, clienteObjeto.getFormacao().getDescricao());
		ps.setString(6, clienteObjeto.getProfissao().getDescricao());
		ps.setDouble(7, clienteObjeto.getRenda());
		
		if (ps.executeUpdate() > 0)
			return true;
		return false;
	}
	
	public boolean Remover(String CPF) throws Exception {
		con = new ConexaoDAO();
		String SQL = "delete from dbo.tblCliente where CPF = ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, CPF);
		
		if (ps.executeUpdate() > 0)
			return true;
		return false;
	}
	
	public List<Cliente> Consultar(String campo, String valor) throws Exception {
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		con = new ConexaoDAO();
		String SQL = "exec dbo.sp_consulta tblCliente, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, campo);
		ps.setString(2, valor);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setCPF(rs.getString("CPF"));
			cliente.setDataNascimento(LocalDate.parse(rs.getDate("DataNascimento").toString()));
			cliente.setEmail(rs.getString("Email"));
			cliente.setFormacao(Formacao.valueOf(rs.getString("Formacao")));
			cliente.setNome(rs.getString("Nome"));
			cliente.setProfissao(Profissao.valueOf(rs.getString("Profissao")));
			cliente.setRenda(rs.getDouble("Renda"));
			cliente.setTelefone(rs.getString("Telefone"));
			
			clientes.add(cliente);
		}
		return clientes;
	}
}
