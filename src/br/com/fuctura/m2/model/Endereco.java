package br.com.fuctura.m2.model;

import java.util.Objects;

public class Endereco {
	private int id;
	private String rua;
	private String numero;
	private String complemento;
	
	public Endereco() {}
	
	public Endereco(int id, String rua, String numero, String complemento) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + "]";
	}
}