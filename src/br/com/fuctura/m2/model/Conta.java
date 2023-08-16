package br.com.fuctura.m2.model;

import java.util.Objects;

public class Conta {
	private int numero;
	private double saldo;
	private double limite;
	
	public Conta() {};
	
	public Conta(int numero, double saldo, double limite) {
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return numero == other.numero;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", limite=" + limite + "]";
	}

}
