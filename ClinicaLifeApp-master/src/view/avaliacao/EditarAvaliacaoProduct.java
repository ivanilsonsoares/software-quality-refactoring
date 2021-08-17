/**
 * @author  Lais Frigério da Silva
 */
package view.avaliacao;


import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.io.Serializable;

public class EditarAvaliacaoProduct implements Serializable {
	private javax.swing.JButton bSalvarAvaliacao;

	public javax.swing.JButton getBSalvarAvaliacao() {
		return bSalvarAvaliacao;
	}

	public void setBSalvarAvaliacao(javax.swing.JButton bSalvarAvaliacao) {
		this.bSalvarAvaliacao = bSalvarAvaliacao;
	}

	public void bSalvarAvaliacaoMouseEntered(java.awt.event.MouseEvent evt) {
		bSalvarAvaliacao.setBackground(Color.decode("#008542"));
	}

	public void bSalvarAvaliacaoMouseExited(java.awt.event.MouseEvent evt) {
		bSalvarAvaliacao.setBackground(Color.decode("#006634"));
	}

	public void bSalvarAvaliacaoFocusGained(java.awt.event.FocusEvent evt) {
		bSalvarAvaliacao.setBackground(Color.decode("#008542"));
	}

	public void bSalvarAvaliacaoFocusLost(java.awt.event.FocusEvent evt) {
		bSalvarAvaliacao.setBackground(Color.decode("#006634"));
	}
}