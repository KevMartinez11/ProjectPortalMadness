package clases;


import implementacion.MainGame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Item extends GeneralData{
	private boolean capturado;	
	//Parametros dentro de la imagen principal
	private int altoImagen;
	private int anchoImagen;
	private int xImagen;
	private int yImagen;
	private String tipoItem;
	
	public Item(int x, int y, String indiceImagen, int velocidad, boolean capturado, int altoImagen, int anchoImagen,
			int xImagen, int yImagen) {
		super(x, y, indiceImagen, velocidad);
		this.capturado = capturado;
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
	}
	
	public Item(int tipoItem,int x, int y, String indiceImagen, int velocidad){
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		
		switch(tipoItem){
			case 1:
				this.altoImagen = 38;
				this.anchoImagen = 38;
				this.xImagen = 143;
				this.yImagen = 403;
			break;
			case 2:
				this.altoImagen = 57;
				this.anchoImagen = 55;
				this.xImagen = 455;
				this.yImagen = 259;
			break;
	
		}
		
	}

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
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

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
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
		if (this.capturado) {
			
			return;
		}
		
}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	/*public void pintar(GraphicsContext graficos) {
		if (this.capturado)
			return;
			
		
		graficos.strokeRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		graficos.drawImage(MainGame.imagenes.get(indiceImagen), x, y);
	}*/
	
}
