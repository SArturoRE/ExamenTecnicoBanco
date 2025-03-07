package Model;

import java.util.ArrayList;
import java.util.List;

import Dominio.Banco;
import Interface.BancoMetodos;

public class BancoMetodosImplementacion implements BancoMetodos {

	private List<Banco> clientes = new ArrayList<Banco>();

	@Override
	public void CrearCuenta(Banco nc) {
		clientes.add(nc);
		System.out.println("Se creo la cuenta correctamente");
		System.out.println(
				"Sr/a " + nc.getNombre() + " usted cuenta con:\n $" + nc.getSaldo() + " pesos en su cuenta");
	}

	@Override
	public Banco ConsultaSaldo(int posCli) {
		return this.clientes.get(posCli);
	}

	@Override
	public void Deposito(int pCl, float nSal) {
		float nuSal;
		if(nSal > 0 && nSal <= 10000) {
			System.out.println("Usted cuenta con:\n$" + clientes.get(pCl).getSaldo() + " pesos");

			System.out.println("Ha depositado: $" + nSal + " pesos");

			nuSal = this.clientes.get(pCl).getSaldo() + nSal;
			this.clientes.get(pCl).setSaldo(nuSal);

			System.out.println("Se realizo el deposito correctamente\n" + "Ahora usted cuenta con: $"
					+ this.clientes.get(pCl).getSaldo() + " pesos");
		}else {
			System.out.println("Lo sentimos,la cantidad que desea depositar no es valida");
			System.out.println("Recuerde que su deposito tiene que ser mayor a 0 y menor o igual a 10,000.00");
		}
	}

	@Override
	public void Retiro(int pCl, float canRet) {
		float nSal;
		
		if(canRet > 0 && canRet <= 10000) {
			if (this.clientes.get(pCl).getSaldo() < canRet) {
				System.out.println("Usted tiene saldo insuficiente para realizar esta operacion");
			} else {
				System.out.println("Usted cuenta con:\n$" + clientes.get(pCl).getSaldo() + " pesos");

				System.out.println("Ha Retirado: $" + canRet + " pesos");

				nSal = this.clientes.get(pCl).getSaldo() - canRet;
				this.clientes.get(pCl).setSaldo(nSal);

				System.out.println("Se realizo el retiro correctamente\n" + "Ahora usted cuenta con: $"
						+ this.clientes.get(pCl).getSaldo() + " pesos");
			}
		}else {
			System.out.println("Lo sentimos,la cantidad que desea retirar no es valida");
			System.out.println("Recuerde que su retiro tiene que ser mayor a 0 y menor o igual a 10,000.00");
		}
	}

	@Override
	public int Buscar(long cl) {
		int pCli = -1;
		
		for (int i = 0; i < this.clientes.size(); i++) {
			if (this.clientes.get(i).getNumCuenta() == cl) 
			{
				pCli = i;
			}
		}

		return pCli;
	}

}
