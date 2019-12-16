package clases;

import implementacion.MainGame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Enemies extends GeneralData{
	private boolean golpeado;	
	//Parametros dentro de la imagen principal
	private int altoImagen;
	private int anchoImagen;
	private int xImagen;
	private int yImagen;
	private String tipoEnemie;
	
	public Enemies(int x, int y, String indiceImagen, int velocidad, boolean golpeado, int altoImagen, int anchoImagen,
			int xImagen, int yImagen) {
		super(x, y, indiceImagen, velocidad);
		this.golpeado = golpeado;
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
	}
	
	public Enemies(int tipoEnemie,int x, int y, String indiceImagen, int velocidad){
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		
		switch(tipoEnemie){
			case 1:
				this.altoImagen = 63;
				this.anchoImagen = 64;
				this.xImagen = 190;
				this.yImagen = 385;
			break;	
		}
		
	}

	public boolean isGolpeado() {
		return golpeado;
	}

	public void setGolpeado(boolean golpeado) {
		this.golpeado = golpeado;
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

	public String getTipoEnemie() {
		return tipoEnemie;
	}

	public void setTipoEnemie(String tipoEnemie) {
		this.tipoEnemie = tipoEnemie;
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
		if (MainGame.derecha) {
			x-=5;
		}
		if (this.golpeado) {		
			return;
		}
		
}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
}
