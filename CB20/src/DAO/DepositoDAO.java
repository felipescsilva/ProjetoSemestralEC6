package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Deposito.Deposito;

public class DepositoDAO {
	ConexaoDAO con;
	public boolean Inserir(Deposito depositoObjeto) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String data = depositoObjeto.getDataTransacao().getDayOfMonth() + "/" + depositoObjeto.getDataTransacao().getMonthValue() + "/" + depositoObjeto.getDataTransacao().getYear();
			String SQL = "exec dbo.sp_InsertDepositos ?, ?, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, depositoObjeto.getCpf());
			ps.setString(2, depositoObjeto.getNumConta());
			ps.setString(3, data);
			ps.setDouble(4, depositoObjeto.getValor());
			
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
	
	
	public boolean Remover(String idDepositos) {
		PreparedStatement ps = null;
		try {
			con = new ConexaoDAO();
			String SQL = "delete from dbo.tblDepositos where idDepositos = ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, idDepositos);
			
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
	
	public List<Deposito> Consultar(String campo, String valor) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Deposito> depositos = new ArrayList<Deposito>();
		try {
			
			con = new ConexaoDAO();
			String SQL = "exec dbo.sp_consulta tblDepositos, ?, ?";
			ps = con.getConexao().prepareStatement(SQL);
			ps.setString(1, campo);
			ps.setString(2, valor);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Deposito deposito = new Deposito();
				
				deposito.setCpf(rs.getString("CPF"));
				deposito.setDataTransacao(LocalDate.parse(rs.getDate("DataTransacao").toString()));
				deposito.setIdDepositos(rs.getInt("idDepositos"));
				deposito.setNumConta(rs.getString("NumConta"));
				deposito.setValor(rs.getDouble("Valor"));
				
				depositos.add(deposito);
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
		return depositos;
	}
}
