package paradigmas;

import java.awt.BorderLayout;import java.awt.Color;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {
	//___
	//el panel que todo lo contiene
	private JPanel contentPane;

	//la entrada al programa, lo que primero
	//se ejecuta

	//ésto es lo relativo al menú desplegable
	//lo que hace es mostrar éste menú donde sea que hagamos click 
	private static void addPopup(Component component, final JPopupMenu popup) {
	component.addMouseListener(new MouseAdapter() {
	public void mousePressed(MouseEvent e) {
	if (e.isPopupTrigger()) {
	showMenu(e);
	}
	}

	public void mouseReleased(MouseEvent e) {
	if (e.isPopupTrigger()) {
	showMenu(e);
	}
	}

	private void showMenu(MouseEvent e) {
	popup.show(e.getComponent(), e.getX(), e.getY());
	}
	});
	}
	//____
	
	public final static int NINGUNO=0;
	public final static int CIRCULO=1;
	public final static int MOVER=2;
	public final static int CUADRADO=3;
	public final static int MOVERCUAD=4;
	public final static int LINEA=5;
	
	private Canvas canvas;
	private ParadigmasToolBar toolbar;
	private int seleccionado;

	public Ventana(){
		
	//________
		// al cerrar la ventana sale del programa
				super("Red de ordenamiento");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// dimensiones y posición al arrancar del JFrame
				setBounds(100, 100, 450, 300);

				// la barra de menú
				JMenuBar menuBar = new JMenuBar();
				setJMenuBar(menuBar);

				// el menú Archivo empieza aquí ---------------------------------------
				JMenu mnArchivo = new JMenu("Archivo");
				menuBar.add(mnArchivo);
				 JMenuItem mntmSalir_1 = new JMenuItem("Salir");
				  mntmSalir_1.addMouseListener(new MouseAdapter() {
				   @Override
				   public void mousePressed(MouseEvent e) {
				    dispose();
				   }
				  });
				  mnArchivo.add(mntmSalir_1);
				//_________________
				JMenu nom = new JMenu("Desarrolladores");
				menuBar.add(nom);

				JMenuItem n1 = new JMenuItem("Carlos Aburto");
				nom.add(n1);

				JSeparator separator_1 = new JSeparator();
				nom.add(separator_1);

				JMenuItem n2= new JMenuItem("Fabian Avila");
				nom.add(n2);
				JSeparator separator_2 = new JSeparator();
				nom.add(separator_2);
				JMenuItem n3 = new JMenuItem("Richard Fica");
				nom.add(n3);

				JSeparator separator_3 = new JSeparator();
				nom.add(separator_3);

				JMenuItem n4= new JMenuItem("Luis Poblete");
				nom.add(n4);
				//_________________

				// el menú Colores empieza aquí ---------------------------------------
				JMenu mnColores = new JMenu("Colores Margen");
				menuBar.add(mnColores);

				JMenuItem mntmBlanco = new JMenuItem("Blanco");
				mntmBlanco.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
				 contentPane.setBackground(Color.WHITE);
				}
				});
				mnColores.add(mntmBlanco);

				JMenuItem mntmNegro = new JMenuItem("Negro");
				mntmNegro.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
				 contentPane.setBackground(Color.BLACK);
				}
				});
				mnColores.add(mntmNegro);

				JMenu mnCambiarElColor = new JMenu(
				 "Cambiar el color del margen con otros colores");
				mnColores.add(mnCambiarElColor);

				JMenuItem mntmVerde = new JMenuItem("Verde");
				mntmVerde.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
				 contentPane.setBackground(Color.GREEN);
				}
				});
				mnCambiarElColor.add(mntmVerde);

				JMenuItem mntmRojo = new JMenuItem("Rojo");
				mntmRojo.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
				 contentPane.setBackground(Color.RED);
				}
				});
				mnCambiarElColor.add(mntmRojo);

				JMenuItem mntmAzul = new JMenuItem("Azul");
				mntmAzul.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
				 contentPane.setBackground(Color.BLUE);
				}
				});
				mnCambiarElColor.add(mntmAzul);

				// el elemento del menú para minimizar está aquí ---------------------------------------
				// aquí termina la barra de menú ...


				// el panel que todo lo contiene se crea
				contentPane = new JPanel();
				// se le pone un borde
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				// se establece en el JFrame
				setContentPane(contentPane);

				// se hace JPopupMenu y lo pongo en el panel contenedor
				JPopupMenu popupMenu = new JPopupMenu();
				popupMenu.setBounds(0, 0, 319, 58);
				addPopup(contentPane, popupMenu);

				
		//________
		this.canvas = new Canvas();
		this.toolbar = new ParadigmasToolBar();
		this.setSize(new Dimension(800,600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(toolbar, BorderLayout.NORTH);
		this.add(canvas, BorderLayout.CENTER);
		this.setSeleccionado(NINGUNO);
		 
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public ParadigmasToolBar getToolbar() {
		return toolbar;
	}

	public void setToolbar(ParadigmasToolBar toolbar) {
		this.toolbar = toolbar;
	}

	public int getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(int seleccionado) {
		this.seleccionado = seleccionado;
	}

}