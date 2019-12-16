package clases;

import implementacion.MainGame;
import javafx.scene.canvas.GraphicsContext;

public class Tiles extends GeneralData{

	//Parametros dentro de la imagen principal

	private int altoImagen;
	private int anchoImagen;
	private int xImagen;
	private int yImagen;
	
	public Tiles(int x, int y, String indiceImagen, int velocidad, int altoImagen, int anchoImagen, int xImagen,
			int yImagen) {
		super(x, y, indiceImagen, velocidad);
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
	}

	public Tiles(int tipoTile,int x, int y, String indiceImagen, int velocidad){
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;

		
		switch(tipoTile){
			case 1:
				this.altoImagen = 64;
				this.anchoImagen = 64;
				this.xImagen = 0;
				this.yImagen = 0;
			break;
			case 2:
				this.altoImagen = 64;
				this.anchoImagen = 64;
				this.xImagen = 449;
				this.yImagen = 129;
			break;
		}
	}
	
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
	public int getAltoImagen() {
		return altoImagen;
	}
	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}
	public int getAnchoImagen() {
		return anchoImagen;
	}
	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}
	public int getxImagen() {
		return xImagen;
	}
	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}
	public int getyImagen() {
		return yImagen;
	}
	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
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
			graficos.drawImage(
				MainGame.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen, 
				this.x, 
				this.y,
				this.anchoImagen, this.altoImagen
			);				
			if (MainGame.derecha)
				x-=5;
	}
	
						
}
	
	
	

