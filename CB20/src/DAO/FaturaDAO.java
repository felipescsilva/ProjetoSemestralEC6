package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Fatura.Fatura;
import model.Fatura.Situacao;

public class FaturaDAO {
	/*
	ConexaoDAO con;
	public boolean Inserir(Fatura faturaObjeto) throws Exception {
		con = new ConexaoDAO();
		String dataVencimento = faturaObjeto.getDataVencimento().getDayOfMonth() + "/" + faturaObjeto.getDataVencimento().getMonthValue() + "/" + faturaObjeto.getDataVencimento().getYear();
		String SQL = "exec dbo.sp_InsertFatura ?, ?, ?, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, faturaObjeto.getNumCartao());
		ps.setString(2, dataVencimento);
		ps.setDouble(3, faturaObjeto.getValor());
		ps.setString(4, faturaObjeto.getSituacao().getDescricao());
		ps.setDouble(5, faturaObjeto.getTaxaJuros());
		
		if (ps.executeUpdate() > 0)
			return true;
		return false;
	}
	
	public boolean Atualizar(Fatura faturaObjeto) throws Exception {
		con = new ConexaoDAO();
		String dataVencimento = faturaObjeto.getDataVencimento().getDayOfMonth() + "/" + faturaObjeto.getDataVencimento().getMonthValue() + "/" + faturaObjeto.getDataVencimento().getYear();
		String SQL = "exec dbo.sp_UpdateFatura ?, ?, ?, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, faturaObjeto.getNumCartao());
		ps.setString(2, dataVencimento);
		ps.setDouble(3, faturaObjeto.getValor());
		ps.setString(4, faturaObjeto.getSituacao().getDescricao());
		ps.setDouble(5, faturaObjeto.getTaxaJuros());
		
		if (ps.executeUpdate() > 0)
			return true;
		return false;
	}
	
	public boolean Remover(String idFatura) throws Exception {
		con = new ConexaoDAO();
		String SQL = "delete from dbo.tblFatura where idFatura = ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, idFatura);
		
		if (ps.executeUpdate() > 0)
			return true;
		return false;
	}
	
	public List<Fatura> Consultar(String campo, String valor) throws Exception {
		List<Fatura> faturas = new ArrayList<Fatura>();
		
		con = new ConexaoDAO();
		String SQL = "exec dbo.sp_consulta tblFatura, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, campo);
		ps.setString(2, valor);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Fatura fatura = new Fatura();
			
			fatura.setDataVencimento(LocalDate.parse(rs.getDate("DataVencimento").toString()));
			fatura.setIdFatura(rs.getInt("idFatura"));
			fatura.setNumCartao(rs.getString("NumCartao"));
			fatura.setSituacao(Situacao.valueOf(rs.getString("Situacao")));
			fatura.setTaxaJuros(rs.getDouble("taxaJuros"));
			fatura.setValor(rs.getDouble(valor));
		}
		return faturas;
	}
	*/
}
