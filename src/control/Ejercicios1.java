/**
 * @author nauzetvm
 */

package control;

import java.util.Date;
import modelo.Persona;
import modelo.Estudiante;

public class Ejercicios1 {
	/*
	 * public int lanzarDado() { double rnd = Math.random()*10; if (rnd < 6 &&
	 * rnd >=1) { return (int) Math.round(rnd); } else { return lanzarDado(); }
	 * }
	 */

	public int lanzarDado() {
		double rnd = (int) (1 + Math.random() * 6);
		return (int) rnd;
	}

	public int[] lanzadas(int nLanzadas) {
		int[] resultado = new int[6];
		int num = 0;
		for (int i = 0; i < nLanzadas; i++) {
			num = lanzarDado();
			resultado[num - 1]++;
		}
		return resultado;
	}

	public static void mostrarEstadisticas(int[] vecEstadisticas, int nLanzadas) {
		double percent;
		for (int i = 0; i < vecEstadisticas.length; i++) {
			percent = (vecEstadisticas[i] * 100) / nLanzadas;
			System.out.println("Te ha salido un " + (i + 1) + " " + vecEstadisticas[i] + " (" + percent + "%) veces.");
		}
	}

	public void rangoNumero(int num) {
		for (int i = 0; i <= num; i++)
			System.out.println(i);
	}

	public void bucleReloj() {
		int h = 0, m = 0, s = 0;
		while (h < 24) { // bucle de horas.
			m = 0;
			while (m < 60) { // bucle de minutos.
				s = 0;
				while (s < 60) { // bucle de segundos.
					System.out.println(h + ":" + m + ":" + s);
					s++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				m++;
			}
			h++;
		}
	}

	public int sumaIntervalo(int n1, int n2) {
		int res = 0;
		// while (n1 <= n2) {
		// res += n1;
		// n1++;
		// }

		for (int i = n1; i <= n2; i++)
			res += i;
		return res;
	}

	public void fibonaccif(int n) {
		int a = 0, b = 1, c;
		for (int i = 0; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
			System.out.print(c + ",");
		}
	}

	public void fibonacciw(int n) {
		int a = 0, b = 1, c;
		int i = 0;
		while (i != n) {
			c = a + b;
			a = b;
			b = c;
			System.out.print(c + ",");
			i++;
		}
	}

	public int producto(int a, int b) {
		int res = 0;
		for (int i = 0; i < b; i++)
			res += a;
		return res;
	}

	public boolean esPrimo(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				// System.out.println("El número " + num + " NO es primo.");
				return false;
			}
		}
		// System.out.println("El número " + num + " es primo.");
		return true;
	}

	public void listarPrimos(int cuantos) {
		int candidato = 1;
		for (int cont = 0; cont < cuantos; cont++) {
			if (esPrimo(candidato))
				System.out.print(candidato + ", ");
			candidato++;
		}

	}

	public void creaListaPersonas() {
		Persona juan = new Persona();
		Persona pepe = new Persona("65423541L", "Pepe", 'H', null);
		Persona maria = new Persona("12352324G", "Maria", 'M', null);

		Persona[] listaPersonas = new Persona[20];
		listaPersonas[9] = juan;
		listaPersonas[1] = pepe;
		listaPersonas[3] = maria;

		for (int i = 0; i < listaPersonas.length; i++) {
			try {
				System.out.println(listaPersonas[i].getNombre());
			} catch (NullPointerException e) {
				
				System.out.println("Objeto nulo");
			}
		}

	}

	public void crearHebras(int cuantas) {
		for (int i = 0; i < cuantas; i++) {
			Thread hebra = new Hebra();
			hebra.setName("Hebra" + i);
			hebra.start();
		}
	}

	public void convierteAEnteros(){
		String [] numeros = {"123","80","894","10024"};
		//Completar
	}
	
	
	public static void main(String[] args) {
		// Scanner teclado = new Scanner(System.in);
		Ejercicios1 ej1 = new Ejercicios1();
		// DADO
		// int [] numero = ej1.lanzadas(100);
		// System.out.println("Te ha salido un: " + numero);

		// LANZADAS Y ESTADISTICAS
		// int nLanzadas = 150;
		// int[] estadisticas = ej1.lanzadas(nLanzadas);
		// mostrarEstadisticas(estadisticas, nLanzadas);

		// MOSTRAR RANGO
		// System.out.print("Introduzca un número límite: ");
		// int num = teclado.nextInt();
		// ej1.rangoNumero(num);

		// RELOJ
		// ej1.bucleReloj();

		// SUMA INTERVALOS
		// System.out.println("Introduzca el valor menor: ");
		// int menor = teclado.nextInt();
		// System.out.println("Introduzca el valor mayor: ");
		// int mayor = teclado.nextInt();
		// teclado.close();
		// System.out.print("Numeros sumados: " + ej1.sumaIntervalo(menor,
		// mayor));

		// FIBONACCI
		// ej1.fibonacciw(10);

		// PRODUCTO CON SUMA
		// int x = 5;
		// int y = 9;
		//
		// int res = ej1.producto(x, y);
		// System.out.println("El producto de " + x + " * " + y + " es: " +
		// res);

		// PRIMOS
		// ej1.esPrimo(1987);
		// ej1.listarPrimos(100);

		// PERSONAS
		ej1.creaListaPersonas();

		// HEBRAS
		// ej1.crearHebras(100);

		// ESTUDIANTE
		Estudiante estu1 = new Estudiante("95482512E", "Pedro", 'H', new Date(), 2, "2016/09/14");
	}
}
