package uniquindio.lenguaje.aplicacion;

import javafx.application.Application;
import javafx.stage.Stage;
import uniquindio.lenguaje.interfaces.AvionInterfaz;


public class Aplicacion extends Application {

	public static void main(String[] args)  {
		launch(args);
	 
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
     AvionInterfaz scene = new AvionInterfaz();
     
     primaryStage.setScene(scene);
     primaryStage.setTitle("Avión");
     primaryStage.show();
		
	}
}
