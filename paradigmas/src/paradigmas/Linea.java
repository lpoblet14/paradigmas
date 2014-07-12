package paradigmas;

import java.awt.Graphics;
import java.awt.Point;


public class Linea implements Dibujable, Comparable<Linea>{

	private Point inicio;
	private Point fin;
	private int id;
	private static int total=0;

	public Linea(Point inicio, Point fin) {
		this.inicio = inicio;
		this.fin = fin;
		total++;
		this.id=total;
	}

	@Override
	public void dibujar(Graphics g) {
		g.drawLine(inicio.x, inicio.y, fin.x, fin.y);

	}
	public Point getInicio() {
		return inicio;
	}
	public void setInicio(Point inicio) {
		this.inicio = inicio;
	}
	public Point getFin() {
		return fin;
	}
	public void setFin(Point fin) {
		this.fin = fin;
	}
	
	public int getId() {
		return id;
	}

	public boolean equals(Object o) {
		return ((o instanceof Linea) && 
				(((Linea)o).id == this.id));
	}
	
	@Override
	public int compareTo(Linea c) {
		// TODO Auto-generated method stub
		if (c.id>this.id){
			return 1;
		} else if(c.id<this.id) {
			return -1;
		}
		return 0;
	}



}