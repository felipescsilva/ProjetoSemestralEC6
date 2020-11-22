package model.Banco;

import java.time.LocalDate;

public class Banco {

	int idBanco;
	double patrimonioProprio;
	double patrimonioTerceiros;
	double faturamento;
	double custosFixos;
	double custosVariaveis;
	double impostos;
	LocalDate lastUpdate;
	
	public int getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	public double getPatrimonioProprio() {
		return patrimonioProprio;
	}
	public void setPatrimonioProprio(double patrimonioProprio) {
		this.patrimonioProprio = patrimonioProprio;
	}
	public double getPatrimonioTerceiros() {
		return patrimonioTerceiros;
	}
	public void setPatrimonioTerceiros(double patrimonioTerceiros) {
		this.patrimonioTerceiros = patrimonioTerceiros;
	}
	public double getFaturamento() {
		return faturamento;
	}
	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}
	public double getCustosFixos() {
		return custosFixos;
	}
	public void setCustosFixos(double custosFixos) {
		this.custosFixos = custosFixos;
	}
	public double getCustosVariaveis() {
		return custosVariaveis;
	}
	public void setCustosVariaveis(double custosVariaveis) {
		this.custosVariaveis = custosVariaveis;
	}
	public double getImpostos() {
		return impostos;
	}
	public void setImpostos(double impostos) {
		this.impostos = impostos;
	}
	public LocalDate getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
