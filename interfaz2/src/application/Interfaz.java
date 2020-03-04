package application;


import java.io.IOException;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Interfaz extends Application {
	Scene miEscena;
	Pane contenedor;
	Label lblSeleccion;
	TextArea taMensajes;
	TextField tfChat;
	Button btnEnviar;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage miEscenario) {
		lblSeleccion = new Label("Socket 1");
		lblSeleccion.setTranslateX(30);
		lblSeleccion.setTranslateY(3);
		
		taMensajes = new TextArea();
		taMensajes.setMinHeight(290);
		taMensajes.setTranslateY(30);
		
		tfChat = new TextField();
		tfChat.setMinWidth(400);
		tfChat.setTranslateX(3);
		tfChat.setTranslateY(330);
		
		btnEnviar = new Button("Envair");
		btnEnviar.setTranslateX(415);
		btnEnviar.setTranslateY(330);
		
		btnEnviar.setOnAction(e -> {
			try {
				enviar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		contenedor = new Pane();
		contenedor.getChildren().addAll(lblSeleccion, taMensajes, tfChat, btnEnviar);
		miEscena = new Scene(contenedor);
		miEscenario.setTitle("ListView");
		miEscenario.setMinWidth(400);
		miEscenario.setMinHeight(400);
		miEscenario.setScene(miEscena);
		miEscenario.getIcons().add(new Image(Interfaz.class.getResourceAsStream("/Imagenes/Cancelar.jpg")));
		miEscenario.show();
	}
	public void enviar() throws IOException {
		Client cliente = new Client();
		if(tfChat.getText().equals("")) {
			
		}else {
			taMensajes.setText("Yo: "+tfChat.getText()+"\n");
			cliente.socket(tfChat.getText());
			tfChat.setText("");
		}
	}

}