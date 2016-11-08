package application;

import java.util.Date;
import java.util.Random;
import modelo.Intento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Controller {

	int numeroAdivinar;

	@FXML
	TextField min;
	@FXML
	TextField max;
	@FXML
	TextField infoGenerar;

	public void botonGenerar(ActionEvent evt) {
		String numTemp;
		try {
			if (min.getText().isEmpty() || max.getText().isEmpty()) {
				infoGenerar.setText("Debe introducir dos valores.");
			}
			numTemp = min.getText();
			int minimo = Integer.parseInt(numTemp);
			numTemp = max.getText();
			int maximo = Integer.parseInt(numTemp);
			if (minimo >= maximo) {
				infoGenerar.setText("Mínimo debe ser menor que máximo.");
			} else {
				infoGenerar.setText(
						"Rango elegido: " + min.getText() + " y " + max.getText() + ", ya puede comenzar a jugar.");
				numeroAdivinar = generarAleatorioEntre(minimo, maximo);
			}
		} catch (NumberFormatException e) {
			infoGenerar.setText("Error de formato.");
		}
	}

	@FXML
	TextArea infoJugar;
	@FXML
	TextField numeroJugado;

	int contadorIntentos;
	Intento[] intentos = new Intento[10];

	public void botonJugar(ActionEvent evt) {
		String jugadoTemp;
		jugadoTemp = numeroJugado.getText();
		int numJugado = Integer.parseInt(jugadoTemp);
		Intento intento = new Intento(numJugado, new Date());

		intentos[contadorIntentos++] = intento;
		if (numJugado < numeroAdivinar) {
			infoJugar.setText("Pruebe un numero mayor.");
		} else if (numJugado > numeroAdivinar) {
			infoJugar.setText("Pruebe un numero menor.");
		} else {
			infoJugar.setText("Enhorabuena, has acertado! " + numeroAdivinar);
		}
	}

	public void verIntentos() {
		infoJugar.setText("Sus intentos han sido:");
		for (int i = 0; i < intentos.length; i++) {
			try {
				infoJugar.setText((i + 1) + " " + intentos[i].getNumero() + " " + intentos[i].getFechaHora() + " -> " + " ");
			} catch (NullPointerException e) {
				break;
			}
		}
	}

	public int generarAleatorioEntre(int minimo, int maximo) {
		return minimo + new Random().nextInt(maximo - minimo);
	}

}