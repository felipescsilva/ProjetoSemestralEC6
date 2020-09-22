package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Compras.Compras;

public class ComprasDAO {
	ConexaoDAO con;
	public boolean Inserir(Compras comprasObjeto) throws Exception {
		con = new ConexaoDAO();
		String data = comprasObjeto.getData().getDayOfMonth() + "/" + comprasObjeto.getData().getMonthValue() + "/" + comprasObjeto.getData().getYear();
		String SQL = "exec dbo.sp_InsertCompras ?, ?, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, comprasObjeto.getNumCartao());
		ps.setString(2, comprasObjeto.getDescricao());
		ps.setDouble(3, comprasObjeto.getValor());
		ps.setString(4, data);
		
		if (ps.executeUpdate() > 0)
			return true;
		return false;
	}
	
	public List<Compras> Consultar(String campo, String valor) throws Exception {
		List<Compras> listaCompras = new ArrayList<Compras>();
		
		con = new ConexaoDAO();
		String SQL = "exec dbo.sp_consulta tblCompras, ?, ?";
		PreparedStatement ps = con.getConexao().prepareStatement(SQL);
		ps.setString(1, campo);
		ps.setString(2, valor);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Compras compras = new Compras();
			
			compras.setData(LocalDate.parse(rs.getDate("Data").toString()));
			compras.setDescricao(rs.getString("Descricao"));
			compras.setIdCompras(rs.getInt("idCompras"));
			compras.setNumCartao(rs.getString("Num Cartao"));
			compras.setValor(rs.getDouble("Valor"));
			
			listaCompras.add(compras);
		}
		return listaCompras;
	}
}
