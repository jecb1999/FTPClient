package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPCmd;

import javafx.application.Platform;
import view.Consola;

public class ConsolaController {
	
	private Consola view;
	private FTPClient cliente;
	
	public ConsolaController(Consola view, FTPClient cliente) {
		this.view = view;
		this.cliente = cliente;
		init();
	}
	
	public void init() {
		view.getHelp().setOnAction((e)->{
			Platform.runLater(() -> {
				try {
					cliente.sendCommand(FTPCmd.HELP);
					view.getTextArea().setText(cliente.getReplyString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		});
		
		view.getCarpeta().setOnAction((e) -> {
			Platform.runLater(()->{
				String nombre = JOptionPane.showInputDialog ( "Introduzca el nombre de la carpeta:" );
				try {
					cliente.sendCommand(FTPCmd.MKD, nombre);
					view.getTextArea().clear();
					view.getTextArea().setText(cliente.getReplyString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		});
		
		view.getSubir().setOnAction((e) -> {
			Platform.runLater(()->{
				try {
					JFileChooser fileChooser = new JFileChooser();
			        fileChooser.showOpenDialog(fileChooser);			
			        File FS = new File(fileChooser.getSelectedFile().getAbsolutePath());
			        FileInputStream input  = new FileInputStream(FS);
			        cliente.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
			        cliente.enterLocalActiveMode();
			        cliente.storeFile(FS.getName(), input);
			        input.close();
					view.getTextArea().clear();
					view.getTextArea().setText(cliente.getReplyString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		});
		
		view.getDescargar().setOnAction((e) -> {
			Platform.runLater(()->{
				try {
					String nombre = JOptionPane.showInputDialog ( "Introduzca el nombre del archivo que desea descargar:" );
					FileOutputStream out = new FileOutputStream(nombre);
					cliente.retrieveFile(nombre, out);
					out.close();
					view.getTextArea().clear();
					view.getTextArea().setText(cliente.getReplyString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		});
		
		view.getUbicacion().setOnAction((e) -> {
			Platform.runLater(()->{
				try {
					cliente.sendCommand(FTPCmd.PWD);
					view.getTextArea().clear();
					view.getTextArea().setText(cliente.getReplyString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		});
		
		view.getEliminar().setOnAction((e) -> {
			Platform.runLater(()->{
				try {
					String nombre = JOptionPane.showInputDialog ( "Introduzca la ruta del archivo que desea eliminar:" );
					cliente.deleteFile(nombre);
					view.getTextArea().clear();
					view.getTextArea().setText(cliente.getReplyString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		});
		
		view.getMoverse().setOnAction((e) -> {
			Platform.runLater(()->{
				try {
					String nombre = JOptionPane.showInputDialog ( "Introduzca el directorio al que se desea cambiar" );
					cliente.changeWorkingDirectory(nombre);
					view.getTextArea().clear();
					view.getTextArea().setText(cliente.getReplyString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		});
		
		
	}
	

}
