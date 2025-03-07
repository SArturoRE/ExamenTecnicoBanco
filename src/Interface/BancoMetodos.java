package Interface;


import Dominio.Banco;

public interface BancoMetodos {
	
	public void CrearCuenta(Banco nc);
	public Banco ConsultaSaldo(int posCli);
	public void Deposito(int pCl, float nSal);
	public void Retiro(int pCl, float canRet);
	/*Crearemos un metodo que nos regresara la pocicion del cliente en la lista
	 * ya que es un metodo que utilizaremos frecuentemente*/ 
	public int Buscar(long numCu);
}
