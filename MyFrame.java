

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MyFrame extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Nos attributs
	 */
	private Color buttonColor;
	private JLabel displayGraph,titre;
	private JLabel lb1,lb2,lb3,lb4;
	private JButton btn2;
	private JPanel panel;
	private JTextField capacity1,capacity2,capacity3,capacity4,localisation;
	private JTextField flux1,flux2,flux3,flux4;
	private JTextField occup1,occup2,occup3,occup4;
	private JTextArea textArea;
	
	
	//Attributs personnalisées à partir de class natif ou primitif
	private CustomButton btn1;
	private SubFrame p1,p2,p3,p4,p5,p6,p11,p12,p13,p14;
	private boolean modeAgressif = false;
	private boolean pressBtn1=false;
	
	
	/**
	 * @apiNote Class's Constructor
	 */
	public MyFrame() {
		super("www.parkingAuto.com");
		
		/*
		 * Initialisation de nos label et textField pour notre panel1
		 */
		
		//Label
		lb1=new JLabel("PARKING 1");
		lb2=new JLabel("PARKING 2");
		lb3=new JLabel("PARKING 3");
		lb4=new JLabel("PARKING 4");
		
		//Capacity 1
		capacity1=new JTextField();
		capacity1.setText("Capacité");
		capacity1.setForeground(new Color(0x808080));
		capacity1.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (capacity1.getText().equals("Capacité")){
                    capacity1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (capacity1.getText().equals("")){
                    capacity1.setText("Capacité");
                }
            }
		});
		
		
		//Capacity 2
		capacity2=new JTextField();
		capacity2.setText("Capacité");
		capacity2.setForeground(new Color(0x808080));
		capacity2.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (capacity2.getText().equals("Capacité")){
                    capacity2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (capacity2.getText().equals("")){
                    capacity2.setText("Capacité");
                }
            }
		});
		
		//Capacity 3
		capacity3=new JTextField();
		capacity3.setText("Capacité");
		capacity3.setForeground(new Color(0x808080));
		capacity3.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (capacity3.getText().equals("Capacité")){
                    capacity3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (capacity3.getText().equals("")){
                    capacity3.setText("Capacité");
                }
            }
		});
		
		//Capacity 4
		capacity4=new JTextField();
		capacity4.setText("Capacité");
		capacity4.setForeground(new Color(0x808080));
		capacity4.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (capacity4.getText().equals("Capacité")){
                    capacity4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (capacity4.getText().equals("")){
                    capacity4.setText("Capacité");
                }
            }
		});
		
		
		//Flux 1
		flux1=new JTextField();
		flux1.setText("Flux");
		flux1.setForeground(new Color(0x808080));
		flux1.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (flux1.getText().equals("Flux")){
                    flux1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (flux1.getText().equals("")){
                    flux1.setText("Flux");
                }
            }
		});
		
		//Flux 2
		flux2=new JTextField();
		flux2.setText("Flux");
		flux2.setForeground(new Color(0x808080));
		flux2.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (flux2.getText().equals("Flux")){
                    flux2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (flux2.getText().equals("")){
                    flux2.setText("Flux");
                }
            }
		});
		
		//Flux 3
		flux3=new JTextField();
		flux3.setText("Flux");
		flux3.setForeground(new Color(0x808080));
		flux3.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (flux3.getText().equals("Flux")){
                    flux3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (flux3.getText().equals("")){
                    flux3.setText("Flux");
                }
            }
		});
		
		//Flux 4
		flux4=new JTextField();
		flux4.setText("Flux");
		flux4.setForeground(new Color(0x808080));
		flux4.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (flux4.getText().equals("Flux")){
                    flux4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (flux4.getText().equals("")){
                    flux4.setText("Flux");
                }
            }
		});
		
		//Occupation 1
		occup1=new JTextField();
		occup1.setText("Occupation");
		occup1.setForeground(new Color(0x808080));
		occup1.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (occup1.getText().equals("Occupation")){
                    occup1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (occup1.getText().equals("")){
                    occup1.setText("Occupation");
                }
            }
		});
		
		//Occupation 2
		occup2=new JTextField();
		occup2.setText("Occupation");
		occup2.setForeground(new Color(0x808080));
		occup2.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (occup2.getText().equals("Occupation")){
                    occup2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (occup2.getText().equals("")){
                    occup2.setText("Occupation");
                }
            }
		});
		
		//Occupation 3
		occup3=new JTextField();
		occup3.setText("Occupation");
		occup3.setForeground(new Color(0x808080));
		occup3.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (occup3.getText().equals("Occupation")){
                    occup3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (occup3.getText().equals("")){
                    occup3.setText("Occupation");
                }
            }
		});
		
		//Occupation 4
		occup4=new JTextField();
		occup4.setText("Occupation");
		occup4.setForeground(new Color(0x808080));
		occup4.addFocusListener(new FocusListener(){
			@Override
            public void focusGained(FocusEvent event){
                if (occup4.getText().equals("Occupation")){
                    occup4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event){
                if (occup4.getText().equals("")){
                    occup4.setText("Occupation");
                }
            }
		});
		
		
		
		/**
		 * Creation de nos Panel
		 */
		
		//Le panel Mère, celui-ci contient 6 autres panel (p1,p2,p3,p4,p5,p6)
		panel=new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Creation des panneaux issu de notre class natif 'SubFrame' à l'interieur du p1
		p11=new SubFrame(175,175);
		p12=new SubFrame(175,175);
		p13=new SubFrame(175,175);
		p14=new SubFrame(175,175);
		
		//Customisation du p11
		p11.setLayout(new BoxLayout(p11,BoxLayout.Y_AXIS));
		p11.add(lb1);
		p11.add(capacity1);
		p11.add(flux1);
		p11.add(occup1);
	
		//Customisation du p12
		p12.setLayout(new BoxLayout(p12,BoxLayout.Y_AXIS));
		p12.add(lb2);
		p12.add(capacity2);
		p12.add(flux2);
		p12.add(occup2);
	
		//Customisation du p13
		p13.setLayout(new BoxLayout(p13,BoxLayout.Y_AXIS));
		p13.add(lb3);
		p13.add(capacity3);
		p13.add(flux3);
		p13.add(occup3);
								
		//Customisation du p14
		p14.setLayout(new BoxLayout(p14,BoxLayout.Y_AXIS));
		p14.add(lb4);
		p14.add(capacity4);
		p14.add(flux4);
		p14.add(occup4);		
		
		/* P1 COMPONENT */
		p1=new SubFrame(500, 400);
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		p1.add(p11);
		p1.add(p12);
		p1.add(p13);
		p1.add(p14);
				
		/* P2 COMPONENT */
		p2=new SubFrame(600, 400);
		
		//Le code pour afficher le graph dans le p2
			try {
				ImageIcon Graph = new ImageIcon(getClass().getResource("Graph.png"));
				displayGraph = new JLabel(Graph);
				p2.add(displayGraph);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(displayGraph, "L'image n'a pas pu être affiché. Assurez-vous d'avoir l'image Graph à l'intérieur du même package que cette class");
			}
				
			//Legende de notre border
			titre=new JLabel("Portion de ville comportant 4 Parking");
			
			//Ajouter un border à notre p2 et un titre à celui ci
			p2.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createEmptyBorder(10,10,10,10),BorderFactory.createTitledBorder("VILLE")));
			
			p2.setBackground(Color.WHITE); //background de notre p2
			p2.add(titre);                 //titre de p2
			
		
		/* P3 COMPONENT */
		p3=new SubFrame(180,85);
		JLabel lb=new JLabel("Agressif/Safe");
		btn1=new CustomButton("");
		buttonColor=btn1.getBackground();
		
		p3.add(lb);
		p3.add(btn1);
		p3.setBackground(Color.WHITE);
		
		/* P4 COMPONENT */
		p4=new SubFrame(140,85);
		JLabel lb0=new JLabel("LOCALISATION");
		localisation=new JTextField();
		
		p4.add(lb0);
		p4.add(localisation);
		p4.setBackground(Color.WHITE);
		p4.setLayout(new BoxLayout(p4,BoxLayout.Y_AXIS));
		
		/* P5 COMPONENT */
		p5=new SubFrame(300,85);
		
		//Label dedié a notre affichage
		JLabel lab=new JLabel("RESULTAT PARKING (Pn) TRAJET\n");
		textArea=new JTextArea();
		textArea.setEditable(false);
		
		p5.add(lab);
		p5.add(textArea);
		p5.setLayout(new BoxLayout(p5,BoxLayout.Y_AXIS));
		
		/* P6 COMPONENT */
		p6=new SubFrame(350,85);
		JLabel lab2=new JLabel("                 EFFECTUER LA REQUÊTE                 ");
		btn2=new JButton("PUSH");
		
		p6.add(lab2);
		p6.add(btn2);
		p6.setBackground(Color.WHITE);
		p6.setLayout(new BoxLayout(p6,BoxLayout.X_AXIS));
		
		/* panel COMPONENT */
		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		panel.add(p5);
		panel.add(p6);
		panel.setBackground(Color.LIGHT_GRAY);
		
		//Notre container
		Container cnt=getContentPane();
		cnt.add(panel);
		
		/*Ajout d'actions à nos boutons*/
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	
		//Proprieté de notre frame
		setSize(new Dimension(1200,600));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	/**
	 * @apiNote methode pour ajouter des actions après click sur boutton
	 */
	public void actionPerformed(ActionEvent event) {
		
		try {
					
			if(event.getSource()==btn1) {
				pressBtn1=true;
			
			}else if(event.getSource()==btn2) {
				
				if(!pressBtn1) {
					JOptionPane.showInternalMessageDialog(this,JOptionPane.ERROR_MESSAGE);
				}else {
					
					//Capacity
					String InputTextCapacity1=capacity1.getText();
					String InputTextCapacity2=capacity2.getText();
					String InputTextCapacity3=capacity3.getText();
					String InputTextCapacity4=capacity4.getText();
					
					//flux
					String InputTextFlux1=flux1.getText();
					String InputTextFlux2=flux2.getText();
					String InputTextFlux3=flux3.getText();
					String InputTextFlux4=flux4.getText();
					
					//Occupation
					String InputTextOccup1=occup1.getText();
					String InputTextOccup2=occup2.getText();
					String InputTextOccup3=occup3.getText();
					String InputTextOccup4=occup4.getText();
					
					//Localisation
					String InputTextLocalisation=localisation.getText();
					
					/*Conversion en entier*/
					
					//Capacity
					int InputCapacity1=Integer.parseInt(InputTextCapacity1);
					int InputCapacity2=Integer.parseInt(InputTextCapacity2);
					int InputCapacity3=Integer.parseInt(InputTextCapacity3);
					int InputCapacity4=Integer.parseInt(InputTextCapacity4);
			
					//flux
					int InputFlux1=Integer.parseInt(InputTextFlux1);
					int InputFlux2=Integer.parseInt(InputTextFlux2);
					int InputFlux3=Integer.parseInt(InputTextFlux3);
					int InputFlux4=Integer.parseInt(InputTextFlux4);
					
					//Ocuppation
					int InputOccup1=Integer.parseInt(InputTextOccup1);
					int InputOccup2=Integer.parseInt(InputTextOccup2);
					int InputOccup3=Integer.parseInt(InputTextOccup3);
					int InputOccup4=Integer.parseInt(InputTextOccup4);

					
					/* Integration de notre fonction principale */			
					Map<String, Node> graph = new HashMap<>();

					//Initiate starting intersections
					Node a = new Node("A");
					Node b = new Node("B");
					Node c = new Node("C");
					Node d = new Node("D");
					Node e = new Node("E");
					Node f = new Node("F");
					Node g = new Node("G");
					Node h = new Node("H");
					Node i = new Node("I");

					//Initiate destination parkings
					Parking p1 = new Parking("PARKING 1", InputCapacity1, InputOccup1, InputFlux1);
					Parking p2 = new Parking("PARKING 2", InputCapacity2, InputOccup2, InputFlux2);
					Parking p3 = new Parking("PARKING 3", InputCapacity3, InputOccup3, InputFlux3);
					Parking p4 = new Parking("PARKING 4", InputCapacity4, InputOccup4, InputFlux4);
				
					//Connect intersections and parking together
					a.addEdge(p1, 20,90);
					a.addEdge(p2, 20,90);
					a.addEdge(e, 3, 70);
					b.addEdge(p1, 3, 30);
					b.addEdge(e, 10, 50);
					c.addEdge(p2, 3, 30);
					c.addEdge(e, 10, 50);
					d.addEdge(p1, 3, 30);
					d.addEdge(p3, 3, 30);
					e.addEdge(g, 10, 50);
					e.addEdge(h, 10, 50);
					f.addEdge(p2, 3, 30);
					f.addEdge(p4, 3, 30);
					g.addEdge(p3, 10, 50);
					h.addEdge(p4, 10, 50);
					i.addEdge(p3, 20, 100);
					i.addEdge(p4, 20, 100);

					//Add all the Nodes to the graph
					graph.put(a.id, a);
					graph.put(b.id, b);
					graph.put(c.id, c);
					graph.put(d.id, d);
					graph.put(e.id, e);
					graph.put(f.id, f);
					graph.put(g.id, g);
					graph.put(h.id, h);
					graph.put(i.id, i);

					graph.put(p1.id, p1);
					graph.put(p2.id, p2);
					graph.put(p3.id, p3);
					graph.put(p4.id, p4);

			        /*
			         * Use case
			         * Here the agressive parameter is false
			         * 
			         * Here the aggressive parameter is set to false
			         * The algo will therefore take into account the capacity of the parkings
			         */
					
					//Dijkstra test1 = new Dijkstra(graph, InputTextLocalisation, false);
	                Dijkstra test1 = new Dijkstra(graph, InputTextLocalisation, modeAgressif);
					
	                int tempsEnMinutes = (int)test1.getTimeBestPath();
					double tempsTotalEnSecondes = (test1.getTimeBestPath()*60)%60;
					int tempsEnSecondes = (int)tempsTotalEnSecondes;
					
					if(tempsEnSecondes >= 60) {
						tempsEnSecondes -= 60;
						tempsEnMinutes += 1;
					}
					
					
					//Effacer le contenu actuel du JTextArea
					textArea.setText("");
					
					//Afficher le resultat attendu dans notre TextArea
					String msg="Le meilleur chemin : \n"+test1.getDirectionBestPaths()+"\n"+"Le temps necessaire :\n"+tempsEnMinutes +" minutes et " +tempsEnSecondes +" secondes.";
					textArea.append(msg);
					
				}
				
				
					
			}
		
		}catch(Exception event2) {
			JOptionPane.showMessageDialog(btn2, "FATAL ERROR!!\nS'il vous plaît, \n 1-Assurez vous d'avoir remplir tous les champs vide avec des entiers \n 2-Assurez vous de remplir le champs de la localisation par une lettre \n majuscule comprise entre [ A __ I ]\n 3-Assurez vous d'avoir choisir un mode (Agressif/Safe) svp");
		}
			
		
		/**
		 * gerer notre bouton color
		 */
		
		if(event.getSource()==btn1) {	
			if(!modeAgressif) {
				
				modeAgressif = true;
				doActionForRedButton();
				
			} else {
				
				modeAgressif = false;
				doActionForGreenButton();
			}
			
			btn1.setBackground(buttonColor);
			
			
		}
			
	}

	
	private void doActionForRedButton() {
		JOptionPane.showMessageDialog(btn1, " Lorsque le bouton est rouge, vous êtes en mode agressif. Dans le mode agressif, l'algorithme ne prends pas compte du nombre de voitures présentes dans le parking.");
	}
	private void doActionForGreenButton() {
		JOptionPane.showMessageDialog(btn1, " Lorsque le bouton est vert, vous êtes en mode safe. Dans le mode safe, l'algorithme prends en compte le nombre de voiture présentes dans le parking.");
	}
	
	public static void main(String[] args) {
		
			new MyFrame();
		
	}

}
