/**
 * @author nauzetvm
 */

package control;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import modelo.Persona;
import modelo.Intento;

public class Ejercicios1 {

	private Scanner teclado = new Scanner(System.in);;

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

	public void convierteAEnteros() {
		String[] ncadena = { "123", "80", "894", "10024" };
		int[] nenteros = new int[ncadena.length];
		for (int i = 0; i < ncadena.length; i++) {
			nenteros[i] = Integer.parseInt(ncadena[i]);
			System.out.println(nenteros[i]);
		}
	}

	public int[] generarIntervalo() {
		System.out.println("Generador de número en el intervalo.");
		// Bucle validacion
		int min = 0;
		int max = 0;
		boolean error1 = true;
		while (error1) {
			System.out.println("Introduzca el intervalo deseado (Ejemplo: 10,20):");
			String intervalo = teclado.nextLine();
			String[] limites = intervalo.split(",");
			// Validamos que hay dos números.
			if (limites.length != 2) {
				System.out.println("Debe introducir dos valores: ");
				error1 = true;
				continue;
			}
			try {
				min = Integer.parseInt(limites[0]);
				max = Integer.parseInt(limites[1]);
				if (min >= max) {
					System.out.println("¡El primer número debe ser menor que el segundo!");
					error1 = true;
					continue;
				}
				// Valiración correcta
				error1 = false;
			} catch (NumberFormatException e) {
				System.out.println("¡Error de formato!");
				error1 = true;
				continue;
			}
		}
		int[] intervalo = { min, max };
		return intervalo;
	}

	public int generarAleatorioEntre(int min, int max) {
		/*
		 * int num = min; int diferencias = max-min; Random rnd = new Random();
		 * num += rnd.nextInt(diferencias); System.out.println(num);
		 */
		return min + new Random().nextInt(max - min);
	}

	public void adivinaNumero() {
		int[] limites = generarIntervalo(); // Se piden dos numeros y se genera
											// número a adivinar.
		int numeroAdivinar = generarAleatorioEntre(limites[0], limites[1]);
		jugarAdivinarNumero(numeroAdivinar);
	}

	public void jugarAdivinarNumero(int numeroAdivinar) {
		int contadorIntentos = 0;
		Intento[] intentos = new Intento[10];
		boolean jugando = true;
		String infoIntento = "";
		do { // Bucle del juego.
			boolean error1 = true;
			int numeroJugado = 0;
			String numeroTecleado = "";
			while (error1) {
				try {
					System.out.print("Introduzca su número: (Q: salir | R: revisar intentos): ");
					numeroTecleado = teclado.nextLine();
					if (numeroTecleado.compareToIgnoreCase("q") == 0) {
						System.out.println("Fin de la partida, hasta la próxima.");
						System.exit(0);
					} else if (contadorIntentos == intentos.length - 1) {
						System.out.println("Fin de la partida, se te han agotado los intentos.");
						System.exit(0);
					} else if (numeroTecleado.compareToIgnoreCase("r") == 0) {
						System.out.println("Sus intentos han sido:");
						for (int i = 0; i < intentos.length; i++) {
							try {
								System.out.printf("%d.- \t%d\t%s\n", i + 1, intentos[i].getNumero(),
										intentos[i].getFechaHora() + " -> " + infoIntento);
							} catch (NullPointerException e) {
								break;
							}
						}
						System.out.println("Le quedan " + (intentos.length - contadorIntentos) + " intentos. ");
						continue;
					}
					numeroJugado = Integer.parseInt(numeroTecleado);
					error1 = false;
					// Creamos un nuevo intento...
					Intento intento = new Intento(numeroJugado, new Date());
					intentos[contadorIntentos++] = intento;
				} catch (NumberFormatException e) {
					System.out.println("Número incorrecto.");
				}
			}
			// Numero valido.
			if (numeroJugado < numeroAdivinar) {
				infoIntento = "Pruebe un número mayor";
				System.out.println(infoIntento);
			} else if (numeroJugado > numeroAdivinar) {
				infoIntento = "Pruebe un número menor";
				System.out.println(infoIntento);
			} else {
				System.out
						.println("¡Enhorabuena, has acertado necesitando solamente " + contadorIntentos + " intentos.");
				jugando = false;
			}
		} while (jugando);
	}

	public String[] ordenaListaCadenas(String[] lista) {
		for (int i = 0; i < lista.length - 1; i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i].compareTo(lista[j]) < 0) { // Hay que permutar.
					String aux = lista[j];
					lista[j] = lista[i];
					lista[i] = aux;
				}
			}
		}
		System.out.println("FIN");
		return lista;
	}

	public int[] ordenaListaNumeros(int[] lista) {
		for (int i = 0; i < lista.length - 1; i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i] > lista[j]) { // Hay que permutar.
					int aux = lista[j];
					lista[j] = lista[i];
					lista[i] = aux;
				}
			}
		}
		return lista;
	}

	public int[] mezclaArrayEnteros(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length + a2.length];
		int i = 0, j = 0, k = 0;
		System.out.println(a3.length);
		while (k < a3.length) {
			try {
				System.out.println("Comparo " + a1[i] + "  " + a2[j]);
				if (a1[i] < a2[j]) {
					a3[k] = a1[i];
					System.out.println("Ahora a1 " + a1[i] + "\n");
					i++;
				} else {
					a3[k] = a2[j];
					System.out.println("Ahora a2 " + a2[j] + "\n");
					j++;
				}
				k++;
			} catch (ArrayIndexOutOfBoundsException e) {
				if (i >= a1.length) {
					a1[i - 1] = Integer.MAX_VALUE;
					i--;
				} else if (j >= a2.length) {
					a2[j - 1] = Integer.MAX_VALUE;
					j--;
				}
			}
		}
		return a3;
	}

	public boolean busquedaBinaria(int buscame, int[] enDonde) {
		int inf = 0;
		int sup = enDonde.length - 1;
		while (inf <= sup) {
			int mid = inf + (sup - inf) / 2;
			if (enDonde[mid] == buscame) {
				return true;
			} else if (enDonde[mid] > buscame) {
				sup = mid - 1;
			} else {
				inf = mid + 1;
			}
		}
		return false;
	}

	public int sumaMatrizEnteros(int[][] matriz) {
		int sum = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				sum += matriz[i][j];
			}
		}
		return sum;
	}

	public int[] sumaFilaMatriz(int[][] matriz) {
		int[] sum = new int[matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				sum[i] += matriz[i][j];
			}
		}
		return sum;
	}

	public int[] sumaColumnaMatrizTry(int[][] matriz) {
		int nMaxCols = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i].length > nMaxCols) {
					nMaxCols = matriz[i].length;
				}
			}
		}
		int[] sum = new int[nMaxCols];
		for (int j = 0; j < nMaxCols; j++) {
			for (int i = 0; i < matriz.length + 1; i++) {
				try {
					sum[j] += matriz[i][j];
				} catch (ArrayIndexOutOfBoundsException e) {
					// Capturo excepción
				}
			}
		}
		return sum;
	}

	public int[] sumaColumnaMatrizIf(int[][] matriz) {
		int nMaxCols = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i].length > nMaxCols) {
					nMaxCols = matriz[i].length;
				}
			}
		}
		int[] sum = new int[nMaxCols];

		for (int j = 0; j < nMaxCols; j++) {
			for (int i = 0; i < matriz.length; i++) {
				if (j < matriz[i].length) {
					sum[j] += matriz[i][j];
				}
			}
		}
		return sum;
	}

	public int calculaSaldoFinal(int[] movimientosCuenta, int saldoInicial) {
		int saldoFinal = saldoInicial;
		for (int i = 0; i < movimientosCuenta.length; i++) {
			saldoFinal += movimientosCuenta[i];
		}
		return saldoFinal;
	}

	public String ordenaCadena(String palabra) {
		String res = "";
		char[] pa2vec = palabra.toCharArray();
		for (int i = 0; i < pa2vec.length; i++) {
			for (int j = i + 1; j < pa2vec.length; j++) {
				if (pa2vec[i] > pa2vec[j]) { // Hay que permutar.
					char aux = pa2vec[j];
					pa2vec[j] = pa2vec[i];
					pa2vec[i] = aux;
				}
			}
			res += pa2vec[i];
		}
		return res;
	}

	public static void main(String[] args) {
		Ejercicios1 ej1 = new Ejercicios1();

		// Ordenar lista enteros
		int[] listaN = { 1, 5, 3, 6, 2, 5, 2, 7, 9, 3, 100, 53, 6, 45 };
		int[] listaIntOrdenada = ej1.ordenaListaNumeros(listaN);

		// Buscar numero
		// boolean encontrado = ej1.busquedaBinaria(100, listaIntOrdenada);
		// if (encontrado) {
		// System.out.println("Encontrado");
		// } else {
		// System.out.println("NO encontrado");
		// }

		// Mezclar arrays.
		// int[] a1 = { 1, 5, 2, 70 };
		// int[] a2 = { 10, 53, 6, 77, 45 };
		// ej1.mezclaArrayEnteros(a1, a2);

		// int[][] matriz = { { 6, 2 }, { 8, 9, 5, 7, 9 }, { 1 }, { 4, 5, 7, 2,
		// 100, 5, 2 } };

		// SUMAR POR COLUMNAS
		// int[] res1 = ej1.sumaColumnaMatrizTry(matriz);
		// for (int i = 0; i < res1.length; i++) {
		// System.out.println(res1[i]);
		// }

		// int[] movCuenta = { 250, -125, 45, -15, 210 };
		// int saldoCuenta = 895;
		// int saldoFinal = ej1.calculaSaldoFinal(movCuenta, saldoCuenta);
		// System.out.println(saldoFinal);

		String palabra = "guadalajara";
		String resultado = ej1.ordenaCadena(palabra);
		System.out.println(resultado);

	}
}
