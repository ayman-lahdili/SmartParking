import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CustomButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean Couleur = false;
	
	
	public CustomButton(String text) {
		addActionListener(this);
		
		
		
		setPreferredSize(new Dimension(150,45));
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(!Couleur) {
			
			setBackground(Color.RED);
			Couleur = true;
			
		} else {
			
			setBackground(Color.GREEN);
			Couleur = false;
			
		}
	}
	
	
}
