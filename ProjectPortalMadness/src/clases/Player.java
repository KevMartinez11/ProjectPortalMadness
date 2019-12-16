package clases;

import java.util.HashMap;


import implementacion.MainGame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Player extends GeneralData{		
	private HashMap<String, Animation> animaciones;
	private String animacionActual;
	private int puntuacion = 0;
	//Coordenadas para el fragmento de la imagen a pintar
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	

	public Player(int x, int y, String indiceImagen, int velocidad, String animacionActual, int puntuacion) {
		super(x, y, indiceImagen, velocidad);
		this.animacionActual = animacionActual;
		this.puntuacion = puntuacion;
		inicializarAnimaciones();
	}
	

	
	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	public void mover(){
			
		this.animacionActual = "descanso";
		
		if (MainGame.derecha) {
			
		this.animacionActual = "correr";			
		}
				
		if (MainGame.arriba) {
		    this.animacionActual = "salto";
		}
					
	}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				MainGame.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		if (MainGame.arriba) {				
		  for(int i=0;i>70 ;i++)
			 this.y=i;
		}
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animation>();
			Rectangle coordenadasCorrer[]= {
					new Rectangle(0, 0, 72, 97),
					new Rectangle(73, 0, 72, 97),
					new Rectangle(146, 0, 72, 97),
					new Rectangle(0, 98, 72, 97),
					new Rectangle(73, 98, 72, 97),
					new Rectangle(146, 98, 72, 97),
					new Rectangle(219, 0, 72, 97),
					new Rectangle(292, 0, 72, 97),
					new Rectangle(219, 98, 72, 97),
					new Rectangle(365, 0, 72, 97),
					new Rectangle(292, 98, 72, 97)
				
			};			
			animaciones.put("correr",new Animation("correr",coordenadasCorrer,0.04));
						
			Rectangle coordenadasDescanso[] = {
					new Rectangle(67, 194, 72, 97)
			};			
			animaciones.put("descanso",new Animation("descanso",coordenadasDescanso,3));
			
			Rectangle coordenadasSalto[] = {
					new Rectangle(438, 93, 67, 94)
			};
			animaciones.put("salto",new Animation("salto",coordenadasSalto,0));
	}
	
	public boolean verificarColisiones(Item item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal()) && !item.isCapturado()) {				
				if (!item.isCapturado())
					this.puntuacion+=100;
				item.setCapturado(true);				
		}
		return false;
	}
	
	public boolean verificarGolpe(Enemies enemigo) {
		if (this.obtenerRectangulo().intersects(enemigo.obtenerRectangulo().getBoundsInLocal()) && !enemigo.isGolpeado()) {				
				if (!enemigo.isGolpeado())
					System.exit(0);
				enemigo.setGolpeado(true);				
		}
		return false;
	}
	


	public int getPuntuacion() {
		return puntuacion;
	}



	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
}
