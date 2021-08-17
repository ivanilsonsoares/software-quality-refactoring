/**
 * @author  Lais Frigério da Silva
 */
package view.avaliacao;


import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.io.Serializable;

public class EditarAvaliacaoProduct2 implements Serializable {
	private javax.swing.JButton bBuscarPaciente;

	public javax.swing.JButton getBBuscarPaciente() {
		return bBuscarPaciente;
	}

	public void setBBuscarPaciente(javax.swing.JButton bBuscarPaciente) {
		this.bBuscarPaciente = bBuscarPaciente;
	}

	public void bBuscarPacienteMouseEntered(java.awt.event.MouseEvent evt) {
		bBuscarPaciente.setBackground(Color.decode("#008542"));
	}

	public void bBuscarPacienteMouseExited(java.awt.event.MouseEvent evt) {
		bBuscarPaciente.setBackground(Color.decode("#006634"));
	}
}