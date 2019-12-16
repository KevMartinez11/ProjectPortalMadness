package clases;

import implementacion.MainGame;
import javafx.scene.canvas.GraphicsContext;

public class Fondo extends GeneralData{
	private int x;
	private int y;	
	private String indiceImagen;
	private int velocidad;
	
	public Fondo(int x, int y, String indiceImagen, int velocidad) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.indiceImagen = indiceImagen;
	}
	
	public Fondo() {}

	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getIndiceImagen() {
		return indiceImagen;
	}

	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(MainGame.imagenes.get(indiceImagen), x, y);
		graficos.drawImage(MainGame.imagenes.get(indiceImagen), x, y);
	}
	
	public void mover() {
		if (MainGame.derecha)
			x-=velocidad;
		
	}
}
