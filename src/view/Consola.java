package view;

import org.apache.commons.net.ftp.FTPClient;

import control.ConsolaController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Consola extends Stage{
	
	private TextArea textArea;
	private Button help;
	private Scene scene;
	private Button carpeta;
	private ConsolaController control;
	private FTPClient cliente;
	private Button subir;
	private Button descargar;
	private Button ubicacion;
	private Button eliminar;
	private Button moverse;
	
	
	public Consola(FTPClient cliente) {
		this.cliente = cliente;
		
		textArea = new TextArea();
		textArea.setLayoutX(21);
		textArea.setLayoutY(14);
		textArea.setPrefHeight(243);
		textArea.setPrefWidth(558);
		help = new Button("Help");
		help.setLayoutX(21);
		help.setLayoutY(273);
		carpeta = new Button("Crear Carpeta");
		carpeta.setLayoutX(95);
		carpeta.setLayoutY(273);
		subir = new Button("Subir Archivo");
		subir.setLayoutX(210);
		subir.setLayoutY(273);
		descargar = new Button("Desacargar Archivo");
		descargar.setLayoutX(350);
		descargar.setLayoutY(273);
		ubicacion = new Button("Ubicacion");
		ubicacion.setLayoutX(500);
		ubicacion.setLayoutY(273);
		eliminar = new Button("Eliminar Archivo");
		eliminar.setLayoutX(21);
		eliminar.setLayoutY(330);
		moverse = new Button("Cambiar de directorio");
		moverse.setLayoutX(160);
		moverse.setLayoutY(330);
		
		AnchorPane ap = new AnchorPane();
		ap.setPrefHeight(400);
		ap.setPrefWidth(600);
		ap.getChildren().add(textArea);
		ap.getChildren().add(help);
		ap.getChildren().add(carpeta);
		ap.getChildren().add(subir);
		ap.getChildren().add(descargar);
		ap.getChildren().add(ubicacion);
		ap.getChildren().add(eliminar);
		ap.getChildren().add(moverse);
		
		scene = new Scene(ap);
		this.setScene(scene);
		control = new ConsolaController(this, cliente);
		
	}


	public TextArea getTextArea() {
		return textArea;
	}


	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}


	public Button getHelp() {
		return help;
	}


	public void setHelp(Button help) {
		this.help = help;
	}


	public Button getCarpeta() {
		return carpeta;
	}


	public void setCarpeta(Button carpeta) {
		this.carpeta = carpeta;
	}


	public Button getSubir() {
		return subir;
	}


	public void setSubir(Button subir) {
		this.subir = subir;
	}


	public Button getDescargar() {
		return descargar;
	}


	public void setDescargar(Button descargar) {
		this.descargar = descargar;
	}


	public Button getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(Button ubicacion) {
		this.ubicacion = ubicacion;
	}


	public Button getEliminar() {
		return eliminar;
	}


	public void setEliminar(Button eliminar) {
		this.eliminar = eliminar;
	}


	public Button getMoverse() {
		return moverse;
	}


	public void setMoverse(Button moverse) {
		this.moverse = moverse;
	}
	
	
	
	


}
