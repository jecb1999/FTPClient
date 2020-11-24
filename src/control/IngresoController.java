package control;



import comm.FTPCom;
import javafx.application.Platform;
import view.Consola;
import view.Ingreso;

public class IngresoController {
	
	private Ingreso view;
	private FTPCom com;
	
	public IngresoController(Ingreso view) {
		this.view = view;
		com = new FTPCom();
		init();
	}
	
	
	public void init() {
		
		view.getIngresar().setOnAction((e->{
			Platform.runLater(()->{
				boolean entro = com.connect(view.getUsuarioIN().getText(), view.getContrasenhaIN().getText());
				if(entro) {
					Consola window = new Consola(com.getCliente());
					window.show();
					view.close();
				}else {
					view.alerta();
				}
				
			});
		}));
		
	}
	

}
