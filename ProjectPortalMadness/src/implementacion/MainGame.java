package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import clases.Enemies;
import clases.Fondo;
import clases.Player;
import clases.Tiles;
import clases.Item;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainGame extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private Player jugadorAnimado;
	private Fondo fondo1;
	private Fondo fondo2;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static HashMap<String, Image> imagenes; 

	private ArrayList<Enemies> enemigo;
	private int[][] enemigos = {
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0}
	};
	private ArrayList<Item> item;
	private int[][] items = {
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0}
	};
	
	private ArrayList<Tiles> tiles;	
	private int[][] mapa = {
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{0,0,0,0,0,0,1,2,0},
			{1,1,1,1,1,1,1,2,0},
	};
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("PORTAL MADNESS");
		gestionarEventos();
		ventana.show();
		cicloJuego();		
	}
	
	public void inicializarComponentes() {
		fondo1 = new Fondo(0,0,"fondo",3);
		fondo2 = new Fondo(1917,0,"fondo2",5);
		jugadorAnimado = new Player(50,290,"player",1, "descanso",0);
		root = new Group();
		escena = new Scene(root,1000,500);
		canvas  = new Canvas(1000,500);
		imagenes = new HashMap<String,Image>();
		//item = new Item(100,200,0,0,"item");
		//item2 = new Item(200,200,0,0,"item");
		cargarImagenes();
		cargarTiles();
		cargarItems();
		cargarEnemies();
	}
	
	public void cargarImagenes() {
		imagenes.put("tilemap", new Image("Tilemap.png"));
		imagenes.put("player", new Image("Jugador.png"));
		imagenes.put("fondo", new Image("fondo.jpg"));
		imagenes.put("fondo2", new Image("fondo2.jpg"));
		//imagenes.put("item", new Image("item.png"));
	}
	
	public void pintar() {	
		graficos.fillRect(0, 0, 500, 500);
		fondo1.pintar(graficos);
		fondo2.pintar(graficos);		
		jugadorAnimado.pintar(graficos);
		///Pintar tiles
		for (int i=0;i<tiles.size();i++)
			tiles.get(i).pintar(graficos);
		
		for (int i=0;i<item.size();i++)
			item.get(i).pintar(graficos);
		
		for (int i=0;i<enemigo.size();i++)
			enemigo.get(i).pintar(graficos);
		
		graficos.setFont(new Font(20));		
		graficos.setFill(Color.YELLOW);		
		graficos.fillText(String.valueOf("Puntuacion: " + jugadorAnimado.getPuntuacion()), 10, 30);


	}
	
	public void cargarTiles() {
		tiles = new ArrayList<Tiles>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tiles(mapa[i][j], i*64, j*64, "tilemap",0));
			}
		}
	}
	
	public void cargarItems() {
		item = new ArrayList<Item>();		
		for(int i=0; i<items.length; i++) {
			for(int j=0; j<items[i].length; j++) {
				if (items[i][j]!=0)
					item.add(new Item(items[i][j], i*64, j*64, "tilemap",0));
			}
		}				
	}
	
	public void colisionItems() {
		for(int i=0;i<item.size();i++) {
			jugadorAnimado.verificarColisiones(item.get(i));
		//item.remove(item.get(i));
		}
	}
	
	public void cargarEnemies() {
		enemigo = new ArrayList<Enemies>();		
		for(int i=0; i<enemigos.length; i++) {
			for(int j=0; j<enemigos[i].length; j++) {
				if (enemigos[i][j]!=0)
					enemigo.add(new Enemies(enemigos[i][j], i*64, j*64, "tilemap",0));
			}
		}				
	}
	
	public void colisionEnemies() {
		for(int i=0;i<enemigo.size();i++) {
			jugadorAnimado.verificarColisiones(item.get(i));
		//item.remove(item.get(i));
		}
	}
	
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					
					switch (evento.getCode().toString()) {
						case "RIGHT": 
							derecha=true;
							break;
						case "LEFT": 
							izquierda=true;
						break;
						case "UP":
							arriba=true;
							break;

					}
			}			
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				
				switch (evento.getCode().toString()) {
				case "RIGHT":
					derecha=false;
					break;
				case "LEFT": 
					izquierda=false;
				break;
				case "UP":
					arriba=false;
					break;

			}
				
			}
			
		});
		
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintar();
				actualizar(t);				
			}			
		};
		animationTimer.start(); 
	}
	
	
	
	public void actualizar(double t) {
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
		fondo1.mover();
		fondo2.mover();
		cambiarFondos();
		colisionItems();
		
		for (int i=0; i<item.size();i++) {
			if (jugadorAnimado.verificarColisiones(item.get(i)))
				item.remove(item.get(i));
			}
		
		for (int i=0; i<enemigo.size();i++) {
			if (jugadorAnimado.verificarGolpe(enemigo.get(i)))
				enemigo.remove(enemigo.get(i));
			}
		
		
		
		//jugadorAnimado.verificarColisiones(item);
		//jugadorAnimado.verificarColisiones(item2);
	}
	public void cambiarFondos() {
		if (fondo2.getX() <= 0) {
			fondo1.setX((int)imagenes.get("fondo2").getWidth()+fondo2.getX());
		}
		
		if (fondo1.getX() <= 0) {
			fondo2.setX((int)imagenes.get("fondo").getWidth()+fondo1.getX());
		}
	}

}