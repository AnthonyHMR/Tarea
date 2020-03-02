package application;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class interfaz extends Application {
	Scene miEscena;
	Pane contenedor;
	Label lblSeleccion;
	ListView<String> lstLenguajes;
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage miEscenario) {
		lblSeleccion = new Label("Aun no has seleccionado un lenguaje");
		lblSeleccion.setTranslateX(300);
		lblSeleccion.setTranslateY(20);
		lstLenguajes = new ListView<>();
		lstLenguajes.getItems().addAll("Java","Python","C","C++","PHP");
		lstLenguajes.setTranslateX(0);
		lstLenguajes.setTranslateY(0);
		lstLenguajes.setMaxSize(200, 400);
		lstLenguajes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> x,String anterior, String actual){
				lblSeleccion.setText("Has seleccionado el lenguaje: " + actual);
			}
		});
		contenedor = new Pane();
		contenedor.getChildren().addAll(lstLenguajes,lblSeleccion);
		miEscena = new Scene(contenedor);
		miEscenario.setTitle("ListView");
		miEscenario.setMinWidth(600);
		miEscenario.setMinHeight(400);
		miEscenario.setScene(miEscena);
		miEscenario.getIcons().add(new Image(interfaz.class.getResourceAsStream("/Imagenes/Cancelar.jpg")));
		miEscenario.show();
	}

}
