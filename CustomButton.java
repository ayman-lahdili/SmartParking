import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class CustomButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// Déclaration de la variable Couleur, initialisée à false.
	private boolean Couleur = false;
	
	
	public CustomButton(String text) {
		
		// Ajout de l'écouteur d'action sur le bouton lui-même.
		addActionListener(this);
		
		// Définition des préférences de taille et de disposition du bouton.
		setPreferredSize(new Dimension(150,45));
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	// Méthode invoquée lorsqu'un événement d'action est détecté.
	public void actionPerformed(ActionEvent e) {
		
		// Si la couleur actuelle du fond du bouton est rouge :
		if(!Couleur) {
			
			// On change la couleur de fond en vert.
			setBackground(Color.RED);
			Couleur = true;
			
		} else {
			
			// Sinon, on change la couleur de fond en rouge.
			setBackground(Color.GREEN);
			Couleur = false;
			
		}
	}
}
