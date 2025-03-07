package Dominio;

import java.time.LocalDate;
import java.util.Date;

public class Banco {
	private long numCuenta;
	private String nombre,app,apm;
	private LocalDate fechaNac;
	private float saldo;

	public Banco() {
	}


	public Banco(long numCuenta, String nombre, String app, String apm, LocalDate fechaNac) {
		this.numCuenta = numCuenta;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.fechaNac = fechaNac;
		this.saldo = 0.0f;
	}

	
	@Override
	public String toString() {
		return "Banco [numCuenta=" + numCuenta + ", nombreComp=" + nombre + ", app=" + app + ", apm=" + apm
				+ ", fechaNac=" + fechaNac + ", saldo=" + saldo + "]\n";
	}


	public long getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(long numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}


	public void setApp(String app) {
		this.app = app;
	}


	public String getApm() {
		return apm;
	}


	public void setApm(String apm) {
		this.apm = apm;
	}


	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

}
