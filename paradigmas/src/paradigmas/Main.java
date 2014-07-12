package paradigmas;

import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.MenuBar;
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


import javax.swing.JToggleButton;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
public void run() {
 try {
  // crea el frame en memoria
  // y lo visualiza
	 Ventana ventana = new Ventana();
	 
		ParadigmasToolBar toolbar = ventana.getToolbar();
		Canvas canvas = ventana.getCanvas();
		EventBuilder eventos = EventBuilder.getEvents(ventana);
		
		toolbar.addBtn("MOVERCUAD", new JToggleButton("MOVER CUADRADO"));
		toolbar.addBtn("CUADRADO", new JToggleButton("CUADRADO"));
		toolbar.addBtn("CIRCULO", new JToggleButton("NODO"));
		toolbar.addBtn("MOVER", new JToggleButton("MOVER NODO"));
		toolbar.addBtn("LINEA", new JToggleButton("LINEA"));
		
		
		toolbar.getBtnLimpiar().addActionListener(eventos);
		toolbar.getBtn("LINEA").addActionListener(eventos);
		toolbar.getBtn("CIRCULO").addActionListener(eventos);
		toolbar.getBtn("MOVER").addActionListener(eventos);
		toolbar.getBtn("MOVERCUAD").addActionListener(eventos);
		toolbar.getBtn("CUADRADO").addActionListener(eventos);
		canvas.addMouseListener(eventos);
		canvas.addMouseMotionListener(eventos);
		
  ventana.setVisible(true);
 } catch (Exception e) {
  e.printStackTrace();
 }
}
});
}
}