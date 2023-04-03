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

    private static final long serialVersionUID = 1L;

    // Couleur des boutons
    private Color buttonColor;

    // Labels pour les parkings
    private JLabel lb1, lb2, lb3, lb4;

    // Boutons pour les parkings
    private CustomButton btn1;
    private JButton btn2;

    // Champ de texte pour les capacités, les flux et les taux d'occupation
    private JTextField capacity1, capacity2, capacity3, capacity4, localisation;
    private JTextField flux1, flux2, flux3, flux4;
    private JTextField occup1, occup2, occup3, occup4;

    // Panneaux pour organiser les éléments graphiques
    private JPanel panel;
    private SubFrame p1, p2, p3, p4, p5, p6, p11, p12, p13, p14;

    // Label pour afficher le graphique des taux d'occupation
    private JLabel displayGraph;

    // Text area pour afficher les informations sur les parkings
    private JTextArea textArea;

    // Titre de la fenêtre p2
    private JLabel titre;

    // Variables pour le mode agressif et le bouton 1
    private boolean modeAgressif = false;
    private boolean pressBtn1 = false;

    /**
     * Constructeur de la classe MyFrame
     */
    public MyFrame() {
        // Appel du constructeur de la classe JFrame pour initialiser la fenêtre principale
        super("www.parkingAuto.com");

        /*
         * Initialisation de nos label et textField pour notre panel1
         */

        // Création des labels pour les parkings
        lb1 = new JLabel("PARKING 1");
        lb2 = new JLabel("PARKING 2");
        lb3 = new JLabel("PARKING 3");
        lb4 = new JLabel("PARKING 4");

        // Création du champ de texte pour la capacité du parking 1
        capacity1 = new JTextField();
        capacity1.setText("Capacité");
        capacity1.setForeground(new Color(0x808080));

        // Ajout d'un FocusListener pour effacer le texte par défaut lorsqu'il est sélectionné et pour rétablir le texte par défaut s'il est laissé vide.
        capacity1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                if (capacity1.getText().equals("Capacité")) {
                    capacity1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (capacity1.getText().equals("")) {
                    capacity1.setText("Capacité");
                }
            }
        });

       // Création du champ de texte pour la capacité de du parking 2
        capacity2 = new JTextField();
        capacity2.setText("Capacité"); // Texte par défaut du champ de texte
        capacity2.setForeground(new Color(0x808080)); // Couleur de texte gris clair
        capacity2.addFocusListener(new FocusListener() { // Ajout de l'écouteur de focus au champ de texte
            @Override
            public void focusGained(FocusEvent event) {
                if (capacity2.getText().equals("Capacité")) { // Si le texte du champ de texte est "Capacité"
                    capacity2.setText(""); // Remplacer le texte par une chaîne de caractères vide
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (capacity2.getText().equals("")) { // Si le texte du champ de texte est vide
                    capacity2.setText("Capacité"); // Remplacer le texte par le texte par défaut "Capacité"
                }
            }
        });

        // Création du champ de texte pour la capacité du parking 3
        capacity3 = new JTextField();
        capacity3.setText("Capacité"); // Texte par défaut du champ de texte
        capacity3.setForeground(new Color(0x808080)); // Couleur de texte gris clair
        capacity3.addFocusListener(new FocusListener() { // Ajout de l'écouteur de focus au champ de texte
            @Override
            public void focusGained(FocusEvent event) {
                if (capacity3.getText().equals("Capacité")) { // Si le texte du champ de texte est "Capacité"
                    capacity3.setText(""); // Remplacer le texte par une chaîne de caractères vide
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (capacity3.getText().equals("")) { // Si le texte du champ de texte est vide
                    capacity3.setText("Capacité"); // Remplacer le texte par le texte par défaut "Capacité"
                }
            }
        });

        // Création du champ de texte pour la capacité du parking 4
        capacity4 = new JTextField();
        capacity4.setText("Capacité"); // Texte par défaut du champ de texte
        capacity4.setForeground(new Color(0x808080)); // Couleur de texte gris clair
        capacity4.addFocusListener(new FocusListener() { // Ajout de l'écouteur de focus au champ de texte
            @Override
            public void focusGained(FocusEvent event) {
                if (capacity4.getText().equals("Capacité")) { // Si le texte du champ de texte est "Capacité"
                    capacity4.setText(""); // Remplacer le texte par une chaîne de caractères vide
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                if (capacity4.getText().equals("")) { // Si le texte du champ de texte est vide
                    capacity4.setText("Capacité"); // Remplacer le texte par le texte par défaut "Capacité"
                }
            }
        });

        //Création du champ de texte pour le flux du parking 1
        flux1=new JTextField(); // Création d'un champ de texte JTextField pour le flux 1
        flux1.setText("Flux"); // Définition du texte par défaut "Flux" pour le flux 1
        flux1.setForeground(new Color(0x808080)); // Définition de la couleur de texte du flux 1
        flux1.addFocusListener(new FocusListener(){ // Ajout d'un écouteur de focus pour le flux 1

            @Override
            public void focusGained(FocusEvent event){ // Lorsque le champ de texte obtient le focus
                if (flux1.getText().equals("Flux")){ // Si le texte est égal à "Flux"
                    flux1.setText(""); // Efface le texte pour permettre une nouvelle saisie
                }
            }

            @Override
            public void focusLost(FocusEvent event){ // Lorsque le champ de texte perd le focus
                if (flux1.getText().equals("")){ // Si le champ de texte est vide
                    flux1.setText("Flux"); // Réaffiche le texte par défaut "Flux"
                }
            }
        });

      //Création du champ de texte pour le flux du parking 2
        flux2=new JTextField(); // Création d'un champ de texte JTextField pour le flux 2
        flux2.setText("Flux"); // Définition du texte par défaut "Flux" pour le flux 2
        flux2.setForeground(new Color(0x808080)); // Définition de la couleur de texte du flux 2
        flux2.addFocusListener(new FocusListener(){ // Ajout d'un écouteur de focus pour le flux 2

            @Override
            public void focusGained(FocusEvent event){ // Lorsque le champ de texte obtient le focus
                if (flux2.getText().equals("Flux")){ // Si le texte est égal à "Flux"
                    flux2.setText(""); // Efface le texte pour permettre une nouvelle saisie
                }
            }

            @Override
            public void focusLost(FocusEvent event){ // Lorsque le champ de texte perd le focus
                if (flux2.getText().equals("")){ // Si le champ de texte est vide
                    flux2.setText("Flux"); // Réaffiche le texte par défaut "Flux"
                }
            }
        });

        //Création du champ de texte pour le flux du parking 3
        flux3=new JTextField(); // Création d'un champ de texte JTextField pour le flux 3
        flux3.setText("Flux"); // Définition du texte par défaut "Flux" pour le flux 3
        flux3.setForeground(new Color(0x808080)); // Définition de la couleur de texte du flux 3
        flux3.addFocusListener(new FocusListener(){ // Ajout d'un écouteur de focus pour le flux 3

            @Override
            public void focusGained(FocusEvent event){ // Lorsque le champ de texte obtient le focus
                if (flux3.getText().equals("Flux")){ // Si le texte est égal à "Flux"
                    flux3.setText(""); // Efface le texte pour permettre une nouvelle saisie
                }
            }

            @Override
            public void focusLost(FocusEvent event){ // Lorsque le champ de texte perd le focus
                if (flux3.getText().equals("")){ // Si le champ de texte est vide
                    flux3.setText("Flux"); // Réaffiche le texte par défaut "Flux"
                }
            }
        });

        //Création du champ de texte pour le flux du parking 4
        flux4=new JTextField(); //Création d'un objet JTextField
        flux4.setText("Flux"); //Définition du texte affiché par défaut
        flux4.setForeground(new Color(0x808080)); //Définition de la couleur du texte
        flux4.addFocusListener(new FocusListener(){ //Ajout d'un écouteur de focus
            @Override
            public void focusGained(FocusEvent event){ //Lorsque le champ gagne le focus
                if (flux4.getText().equals("Flux")){ //Si le texte affiché est "Flux"
                    flux4.setText(""); //On vide le champ
                }
            }

            @Override
            public void focusLost(FocusEvent event){ //Lorsque le champ perd le focus
                if (flux4.getText().equals("")){ //Si le champ est vide
                    flux4.setText("Flux"); //On réaffiche le texte par défaut
                }
            }
        });

        // Création du champ de texte pour l'occupation du parking 1
        occup1=new JTextField(); // Crée un nouveau champ de texte pour l'occupation 1
        occup1.setText("Occupation"); // Définit le texte d'invite de saisie pour le champ de texte comme "Occupation"
        occup1.setForeground(new Color(0x808080)); // Définit la couleur du texte du champ de texte comme gris clair
        occup1.addFocusListener(new FocusListener(){ // Ajoute un écouteur de focus au champ de texte
            @Override
            public void focusGained(FocusEvent event){ // La méthode qui est appelée lorsque le champ de texte obtient le focus
                if (occup1.getText().equals("Occupation")){ // Vérifie si le texte dans le champ de texte est égal à "Occupation"
                    occup1.setText(""); // Efface le texte du champ de texte
                }
            }

            @Override
            public void focusLost(FocusEvent event){ // La méthode qui est appelée lorsque le champ de texte perd le focus
                if (occup1.getText().equals("")){ // Vérifie si le champ de texte est vide
                    occup1.setText("Occupation"); // Définit le texte d'invite de saisie pour le champ de texte comme "Occupation"
                }
            }
        });

        // Les trois blocs suivants sont presque identiques à celui-ci, mais pour les champs de texte d'occupation 2 à 4.
        // La seule différence est le nom du champ de texte (occup2, occup3, et occup4) dans les méthodes focusGained et focusLost.

        // Création du champ de texte pour l'occupation du parking 2
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

        // Création du champ de texte pour l'occupation du parking 3
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

        // Création du champ de texte pour l'occupation du parking 4
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
         * Création de nos panneaux
         */

        // Le panneau principal, celui-ci contient 6 autres panneaux (p1, p2, p3, p4, p5, p6)
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Création des panneaux issus de notre classe "SubFrame" à l'intérieur de p1
        p11 = new SubFrame(175, 175);
        p12 = new SubFrame(175, 175);
        p13 = new SubFrame(175, 175);
        p14 = new SubFrame(175, 175);

        // Personnalisation de p11
        p11.setLayout(new BoxLayout(p11, BoxLayout.Y_AXIS));
        p11.add(lb1);
        p11.add(capacity1);
        p11.add(flux1);
        p11.add(occup1);

        // Personnalisation de p12
        p12.setLayout(new BoxLayout(p12, BoxLayout.Y_AXIS));
        p12.add(lb2);
        p12.add(capacity2);
        p12.add(flux2);
        p12.add(occup2);

        // Personnalisation de p13
        p13.setLayout(new BoxLayout(p13, BoxLayout.Y_AXIS));
        p13.add(lb3);
        p13.add(capacity3);
        p13.add(flux3);
        p13.add(occup3);

        // Personnalisation de p14
        p14.setLayout(new BoxLayout(p14, BoxLayout.Y_AXIS));
        p14.add(lb4);
        p14.add(capacity4);
        p14.add(flux4);
        p14.add(occup4);

        /* COMPOSANT P1 */
        p1 = new SubFrame(500, 400);
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.add(p11);
        p1.add(p12);
        p1.add(p13);
        p1.add(p14);

        /* COMPOSANT P2 */
        p2 = new SubFrame(600, 400);

        // Le code pour afficher le graphique dans p2
        try {
            ImageIcon graphique = new ImageIcon(getClass().getResource("Graph.png"));
            displayGraph = new JLabel(graphique);
            p2.add(displayGraph);
        } catch (Exception e) {
            System.out.println("L'image n'a pas pu être affichée. Assurez-vous d'avoir l'image Graph à l'intérieur du même package que cette classe");
        }

        // Légende de notre bordure
        titre = new JLabel("Portion de ville comportant 4 parkings");

        // Ajout d'une bordure à p2 et d'un titre à celui-ci
        p2.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10), BorderFactory.createTitledBorder("VILLE")));
        p2.setBackground(Color.WHITE); // Fond de p2
        p2.add(titre); // Titre de p2
        
        /* P3 COMPONENT */
        p3 = new SubFrame(180, 85); // Création d'un objet SubFrame avec une taille de 180 pixels de largeur et 85 pixels de hauteur
        JLabel lb = new JLabel("Agressif/Safe"); // Création d'un JLabel avec le texte "Agressif/Safe"
        btn1 = new CustomButton(""); // Création d'un objet CustomButton vide
        buttonColor = btn1.getBackground(); // Stockage de la couleur de fond de btn1 dans la variable buttonColor

        p3.add(lb); // Ajout du JLabel à l'objet SubFrame p3
        p3.add(btn1); // Ajout du CustomButton à l'objet SubFrame p3
        p3.setBackground(Color.WHITE); // Définition de la couleur de fond de l'objet SubFrame p3 à blanc
        p3.setLayout(new FlowLayout(FlowLayout.LEFT)); // Définition du gestionnaire de mise en page de l'objet SubFrame p3 avec un alignement à gauche

        /* P4 COMPONENT */
        p4 = new SubFrame(140, 85); // Création d'un objet SubFrame avec une taille de 140 pixels de largeur et 85 pixels de hauteur
        JLabel lb0 = new JLabel("LOCALISATION"); // Création d'un JLabel avec le texte "LOCALISATION"
        localisation = new JTextField(); // Création d'un objet JTextField vide

        p4.add(lb0); // Ajout du JLabel à l'objet SubFrame p4
        p4.add(localisation); // Ajout du JTextField à l'objet SubFrame p4
        p4.setBackground(Color.WHITE); // Définition de la couleur de fond de l'objet SubFrame p4 à blanc
        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS)); // Définition du gestionnaire de mise en page de l'objet SubFrame p4 avec un alignement vertical (axe Y)
        
        /* P5 COMPONENT */
        p5 = new SubFrame(300, 85); // Création d'un objet SubFrame avec une taille de 300 pixels de largeur et 85 pixels de hauteur

        // Création d'un JLabel avec le texte "RESULTAT PARKING (Pn) TRAJET\n"
        JLabel lab = new JLabel("RESULTAT PARKING (Pn) TRAJET\n");
        textArea = new JTextArea(); // Création d'un objet JTextArea vide
        textArea.setEditable(false); // Interdiction de l'édition de textArea

        p5.add(lab); // Ajout du JLabel à l'objet SubFrame p5
        p5.add(textArea); // Ajout de l'objet JTextArea à l'objet SubFrame p5
        p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS)); // Définition du gestionnaire de mise en page de l'objet SubFrame p5 avec un alignement vertical (axe Y)

        /* P6 COMPONENT */
        p6 = new SubFrame(350, 85); // Création d'un objet SubFrame avec une taille de 350 pixels de largeur et 85 pixels de hauteur
        JLabel lab2 = new JLabel("                 EFFECTUER LA REQUÊTE                 "); // Création d'un JLabel avec le texte "EFFECTUER LA REQUÊTE"
        btn2 = new JButton("PUSH"); // Création d'un objet JButton avec le texte "PUSH"

        p6.add(lab2); // Ajout du JLabel à l'objet SubFrame p6
        p6.add(btn2); // Ajout du JButton à l'objet SubFrame p6
        p6.setBackground(Color.WHITE); // Définition de la couleur de fond de l'objet SubFrame p6 à blanc
        p6.setLayout(new BoxLayout(p6, BoxLayout.X_AXIS)); // Définition du gestionnaire de mise en page de l'objet SubFrame p6 avec un alignement horizontal (axe X)

        /* Pn1 COMPONENT */
        JPanel Pn1 = new JPanel(); // Création d'un objet JPanel
        Pn1.add(p1); // Ajout de l'objet SubFrame p1 à l'objet JPanel Pn1
        Pn1.add(p2); // Ajout de l'objet SubFrame p2 à l'objet JPanel Pn1
        Pn1.setBackground(Color.LIGHT_GRAY); // Définition de la couleur de fond de l'objet JPanel Pn1 à gris clair
        Pn1.setLayout(new FlowLayout(FlowLayout.LEFT)); // Définition du gestionnaire de mise en page de l'objet JPanel Pn1 avec un alignement à gauche

        /* Pn2 COMPONENT */
        JPanel Pn2 = new JPanel(); // Création d'un objet JPanel
        Pn2.add(p3); // Ajout de l'objet SubFrame p3 à l'objet JPanel Pn2
        Pn2.add(p4); // Ajout de l'objet SubFrame p4 à l'objet JPanel Pn2
        Pn2.add(p5); // Ajout de l'objet SubFrame p5 à l'objet JPanel Pn2
        Pn2.add(p6); // Ajout de l'objet SubFrame p6 à l'objet JPanel Pn2
        Pn2.setBackground(Color.LIGHT_GRAY); // Définition de la couleur de fond de l'objet JPanel Pn2 à gris clair
        Pn2.setLayout(new FlowLayout(FlowLayout.LEFT)); // Définition du

     		
		/* panel COMPONENT */
        // Ajout des différents composants au panel
        panel.add(p1);
        panel.add(p2);
        panel.add(Pn2);
        panel.setBackground(Color.LIGHT_GRAY);

        // Récupération du container de la JFrame
        Container cnt = getContentPane();
        // Ajout du panel au container
        cnt.add(panel);

        // Ajout d'actions aux boutons
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        // Propriétés de la JFrame
        setSize(new Dimension(1200, 600)); // Définition de la taille
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fermeture de la fenêtre lorsqu'on clique sur la croix
        setVisible(true); // Rendre la fenêtre visible

	}
	
	/**
	 * methode pour ajouter des actions après click sur boutton
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
					
					/*Conversion en entier de nos elements entrés par l'utilisateur*/
					
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
			         *Cas d'utilisation
			         * Ici, le paramètre agressif est faux
			         * 
			         * Ici, le paramètre agressif est défini sur false
			         * L’algo prendra donc en compte la capacité des parkings
			         */
					
                    Dijkstra test1 = new Dijkstra(graph, InputTextLocalisation, modeAgressif);

                    // Déclaration et initialisation de la variable tempsEnMinutes avec la partie entière du temps de parcours
                    int tempsEnMinutes = (int)test1.getTimeBestPath();

                    // Calcul de la partie décimale du temps de parcours en secondes
                    double tempsTotalEnSecondes = (test1.getTimeBestPath()*60)%60;

                    // Déclaration et initialisation de la variable tempsEnSecondes avec la partie entière de tempsTotalEnSecondes
                    int tempsEnSecondes = (int)tempsTotalEnSecondes;

                    // Si la partie entière de tempsTotalEnSecondes est supérieure ou égale à 60, 
                    // soustraire 60 à tempsEnSecondes et ajouter 1 à tempsEnMinutes pour prendre en compte la minute supplémentaire
                    if(tempsEnSecondes >= 60) {
                        tempsEnSecondes -= 60;
                        tempsEnMinutes += 1;
                    }



                    // Effacer le contenu actuel du JTextArea
                    textArea.setText("");

                    // Afficher le résultat attendu dans notre TextArea
                    String msg = "Le meilleur chemin : \n" + test1.getDirectionBestPaths() + "\n" + "Le temps nécessaire :\n" + tempsEnMinutes + " minutes et " + tempsEnSecondes + " secondes";
                    textArea.append(msg);

					
				}
				
				
					
			}
		
		}catch(Exception event2) {
			//Affichage en pop-up de notre resulta après appuie du bouton " push "
			JOptionPane.showMessageDialog(btn2, "FATAL ERROR!!\nS'il vous plaît, \n 1-Assurez vous d'avoir remplir tous les champs vide avec des entiers \n 2-Assurez vous de remplir le champs de la localisation par une lettre \n majuscule comprise entre [ A __ I ]\n 3-Assurez vous d'avoir choisir un mode (Agressif/Safe) svp");
		}
			
		/**
		 * Gérer la couleur de notre bouton en fonction du mode choisi par l'utilisateur
		 */

		// Si l'événement est déclenché par le bouton btn1
		if(event.getSource()==btn1) {	
			// Si le mode agressif n'est pas activé
			if(!modeAgressif) {
				// Activer le mode agressif et exécuter l'action associée au bouton rouge
				modeAgressif = true;
				doActionForRedButton();
			} else {
				// Désactiver le mode agressif et exécuter l'action associée au bouton vert
				modeAgressif = false;
				doActionForGreenButton();
			}

			// Mettre à jour la couleur de fond du bouton
			btn1.setBackground(buttonColor);
		}

			
			
		}
			

	
	// Définition de la fonction doActionForRedButton()
	private void doActionForRedButton() {
		// Affichage d'un message d'information lorsque le bouton est rouge et que le mode agressif est activé
		JOptionPane.showMessageDialog(btn1, "Lorsque le bouton est rouge, vous êtes en mode agressif. Dans le mode agressif, l'algorithme ne prend pas en compte le nombre de voitures présentes dans le parking.");
	}

	// Définition de la fonction doActionForGreenButton()
	private void doActionForGreenButton() {
		// Affichage d'un message d'information lorsque le bouton est vert et que le mode safe est activé
		JOptionPane.showMessageDialog(btn1, "Lorsque le bouton est vert, vous êtes en mode safe. Dans le mode safe, l'algorithme prend en compte le nombre de voitures présentes dans le parking.");
	}

	// Définition de la fonction main()
	public static void main(String[] args) {
		// Exécution de notre programme dans la classe principale en créant une nouvelle instance de MyFrame
		new MyFrame();
	}


}
