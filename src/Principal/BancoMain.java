package Principal;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import Dominio.Banco;
import Model.BancoMetodosImplementacion;

public class BancoMain {

	public static void main(String[] args) {
		 long numCuenta;
		 String nombre,app,apm;
		 LocalDate fechaNac;
		 float nuSaldo;
		 int menu;
		 Scanner leer = null; 
		 Banco cli = null;
		 BancoMetodosImplementacion cban = new BancoMetodosImplementacion();
		 
		 do {
			System.out.println("Menu Bancomer Bienvenido");
			System.out.println("[1]----- Alta cliente");
			System.out.println("[2]----- Consultar saldo");
			System.out.println("[3]----- Deposito en efectivo");
			System.out.println("[4]----- Retiro en efectivo");
			System.out.println("[5]----- Salir");
			leer = new Scanner(System.in);
			menu = leer.nextInt();
			 
			switch (menu) {
			case 1:
				try {
					System.out.println("Para abrir tu cuenta, tendras que proporcionar los siguientes datos:");
					System.out.println("Ingresa un numero de cuenta:");
					leer = new Scanner(System.in);
					numCuenta = leer.nextLong();
					System.out.println("Ingresa el nombre del propietario de la cuenta");
					leer = new Scanner(System.in);
					nombre = leer.next();
					System.out.println("Ingresa el apellido paterno del propietario de la cuenta");
					leer = new Scanner(System.in);
					app = leer.next();
					System.out.println("Ingresa el apellido materno del propietario de la cuenta");
					leer = new Scanner(System.in);
					apm = leer.next();
					System.out.println("Ingresa la fecha de nacimiento");
					System.out.println("Año-mes-dia");
					leer = new Scanner(System.in);
					String fecha = leer.next();
					fechaNac = LocalDate.parse(fecha);
					cli = new Banco(numCuenta, nombre, app, apm, fechaNac);
					cban.CrearCuenta(cli);					
					
				} catch (Exception e) {
					System.out.println("Algo salio mal, lo sentimos..." + e.getMessage());
				}
				break;
			case 2:
				try {
					System.out.println("Ingresa el numero de cuenta que vamos a consultar:");
					leer = new Scanner(System.in);
					numCuenta = leer.nextLong();
					int pCli = cban.Buscar(numCuenta);
					cli = cban.ConsultaSaldo(pCli);
					System.out.println("Usted cuenta con: $"+
					cli.getSaldo() + " pesos");
					
				} catch (Exception e) {
					System.out.println("Algo salio mal, lo sentimos..." + e.getMessage());
				}
				
				break;
			case 3:
				try {
					System.out.println("Ingresa el numero de cuenta al que le vamos a depositar:");
					leer = new Scanner(System.in);
					numCuenta = leer.nextLong();
					System.out.println("Ingrese la cantidad a depositar");
					leer = new Scanner(System.in);
					nuSaldo = leer.nextFloat();
					int pos = cban.Buscar(numCuenta);
					if(0 <= pos) {
						cban.Deposito(pos, nuSaldo);
					}else {
						System.out.println("El numero de cuenta que ingreso no existe");
					}
					
				} catch (Exception e) {
					System.out.println("Algo salio mal, lo sentimos..." + e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.println("Ingresa el numero de cuenta del que vamos a retirar:");
					leer = new Scanner(System.in);
					numCuenta = leer.nextLong();
					System.out.println("Ingrese la cantidad a retirar");
					leer = new Scanner(System.in);
					nuSaldo = leer.nextFloat();
					int pos = cban.Buscar(numCuenta);
					if(0 <= pos) {
						cban.Retiro(pos, nuSaldo);
					}else {
						System.out.println("El numero de cuenta que ingreso no existe");
					}
					
				} catch (Exception e) {
					System.out.println("Algo salio mal, lo sentimos..." + e.getMessage());
				}
				break;
			case 5:
				System.out.println("Adios...");
				break;
			default:
				System.out.println("Opcion incorrecta\nAdios...");
				break;
			}
		} while (menu < 5);
		 System.out.println("Agregamos una linea mas para hacer un commit");
		 

	}

}
