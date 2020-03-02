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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class interfaz extends Application {
	Scene miEscena;
	Pane contenedor;
	Label lblSeleccion;
	Button btnInicio, btnEnviar;
	TextArea taMensajes;
	TextField tfChat;
	ListView<String> lstLenguajes;
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage miEscenario) {
		
		lblSeleccion = new Label("Aun no has seleccionado un lenguaje");
		lblSeleccion.setTranslateX(300);
		lblSeleccion.setTranslateY(20);
		
		btnInicio = new Button("Iniciar Servidor");
		btnInicio.setMinWidth(40);
		btnInicio.setTranslateX(13);
		btnInicio.setTranslateY(2);
		
		btnEnviar = new Button("Enviar");
		btnEnviar.setMinWidth(20);
		btnEnviar.setTranslateX(530);
		btnEnviar.setTranslateY(342);
		
		taMensajes = new TextArea();
		taMensajes.setMinHeight(310);
		taMensajes.setTranslateX(120);
		taMensajes.setTranslateY(30);
		
		tfChat = new TextField();
		tfChat.setMinWidth(400);
		tfChat.setMinHeight(20);
		tfChat.setTranslateX(124);
		tfChat.setTranslateY(342);
		
		lstLenguajes = new ListView<>();
		lstLenguajes.getItems().addAll("Socket1","Socket2","Socket3");
		lstLenguajes.setTranslateX(0);
		lstLenguajes.setTranslateY(30);
		lstLenguajes.setMaxSize(120, 370);
		lstLenguajes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> x,String anterior, String actual){
				String hola = "Hamborguesa";
				taMensajes.setText("Yo: " + hola + "\n");
			}
		});
		
		btnEnviar.setOnAction(e -> agregar());
		
		contenedor = new Pane();
		contenedor.getChildren().addAll(lstLenguajes,lblSeleccion, btnInicio, btnEnviar, taMensajes, tfChat);
		miEscena = new Scene(contenedor);
		miEscenario.setTitle("ListView");
		miEscenario.setMinWidth(600);
		miEscenario.setMinHeight(400);
		miEscenario.setScene(miEscena);
		miEscenario.getIcons().add(new Image(interfaz.class.getResourceAsStream("/Imagenes/Cancelar.jpg")));
		miEscenario.show();
	}
	public void agregar() {
		if(tfChat.getText().equals("")){
			
		}else{
			taMensajes.appendText("Me: " + tfChat.getText() + "\n");
			tfChat.setText("");
		}
	}
}
