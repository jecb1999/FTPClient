package view;

import javax.swing.JOptionPane;

import control.IngresoController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ingreso extends Stage{
	
	private Label titulo;
	private Label usuario;
	private Label contrasenha;
	private TextField usuarioIN;
	private TextField contrasenhaIN;
	private Button ingresar;
	private IngresoController control;
	private Scene scene;
	
	public Ingreso() {
		titulo = new Label("Ingreso");
		titulo.setLayoutX(142);
		titulo.setLayoutY(14);
		titulo.setFont(new Font (38));
		usuario = new Label("Usuario");
		usuario.setLayoutX(81);
		usuario.setLayoutY(101);
		contrasenha = new Label("Clave");
		contrasenha.setLayoutX(81);
		contrasenha.setLayoutY(142);
		usuarioIN = new TextField();
		usuarioIN.setLayoutX(205);
		usuarioIN.setLayoutY(97);
		contrasenhaIN = new TextField();
		contrasenhaIN.setLayoutX(205);
		contrasenhaIN.setLayoutY(138);
		ingresar = new Button("Ingresar");
		ingresar.setLayoutX(175);
		ingresar.setLayoutY(196);
		
		AnchorPane ap = new AnchorPane();
		ap.setPrefHeight(235);
		ap.setPrefWidth(409);
		
		ap.getChildren().add(titulo);
		ap.getChildren().add(usuario);
		ap.getChildren().add(usuarioIN);
		ap.getChildren().add(contrasenha);
		ap.getChildren().add(contrasenhaIN);
		ap.getChildren().add(ingresar);
		
		scene = new Scene(ap);
		this.setScene(scene);
		control = new IngresoController(this);
		
	}

	public Label getTitulo() {
		return titulo;
	}

	public void setTitulo(Label titulo) {
		this.titulo = titulo;
	}

	public Label getUsuario() {
		return usuario;
	}

	public void setUsuario(Label usuario) {
		this.usuario = usuario;
	}

	public Label getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(Label contrasenha) {
		this.contrasenha = contrasenha;
	}

	public TextField getUsuarioIN() {
		return usuarioIN;
	}

	public void setUsuarioIN(TextField usuarioIN) {
		this.usuarioIN = usuarioIN;
	}

	public TextField getContrasenhaIN() {
		return contrasenhaIN;
	}

	public void setContrasenhaIN(TextField contrasenhaIN) {
		this.contrasenhaIN = contrasenhaIN;
	}

	public Button getIngresar() {
		return ingresar;
	}

	public void setIngresar(Button ingresar) {
		this.ingresar = ingresar;
	}

	public IngresoController getControl() {
		return control;
	}

	public void setControl(IngresoController control) {
		this.control = control;
	}

	public void alerta() {
		JOptionPane.showMessageDialog(null, "Clave o Usuario Incorrectos", null , JOptionPane.ERROR_MESSAGE);
	}
	
	

}
