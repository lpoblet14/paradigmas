package paradigmas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cuadrado implements Dibujable, Comparable<Cuadrado>{

	
	private int radio;
	private Point posicion;
	private Color color;
	private int id;
	private static int total=0;
	
	public Cuadrado(Point posicion, int radio)
	{
		this.posicion = new Point();
		this.posicion.x=posicion.x-radio;
		this.posicion.y=posicion.y-radio;
		this.radio=radio;
		this.color = Color.blue;
		total++;
		this.id=total;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}



	public Point getPosicion() {
		return posicion;
	}

	public void cambiarColor(Color color) {
		this.color = color;
	}
	
	public void setPosicion(Point posicion) {
		this.posicion.x=posicion.x-radio;
		this.posicion.y=posicion.y-radio;
	}
	
	public int getRadius() {
		return radio;
	}

	public void setRadius(int radio) {
		this.radio = radio;
	}
	public void dibujar(Graphics g) {
		g.setColor(color);
		g.drawRect(posicion.x, posicion.y, radio*2, radio*2);
	}
	
	public boolean isHere(Point p) {
		Point pt = new Point();
		pt.x=p.x-radio;
		pt.y=p.y-radio;
		if (Math.abs(pt.distance(this.posicion)) <= radio)
			return true;
		return false;
	}
	
	public int getId() {
		return id;
	}

	public boolean equals(Object o) {
		return ((o instanceof Cuadrado) && 
				(((Cuadrado)o).id == this.id));
	}

	@Override
	public int compareTo(Cuadrado k) {
		if (k.id>this.id){
			return 1;
		} else if(k.id<this.id) {
			return -1;
		}
		return 0;
	}}
