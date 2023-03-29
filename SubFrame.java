package Frame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SubFrame extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width,height;
	
	public SubFrame(int w, int h) {
		this.width=w;
		this.height=h;
		
		setPreferredSize(new Dimension(this.width,this.height));
		//setBackground(Color.BLUE);
		
		Border border=BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
		setBorder(border);
		
		JLabel label=new JLabel();
		
		add(label);
		
		
		setVisible(true);
	}
}
