package application;
import application.control.MainController;
import javafx.application.Application;

//creare su Mysql 
//database password con una tabella
//tablepassword con i seguenti campi:
//Tipo varchar
//Nome varchar
//Password varchar
//Sito varchar
//Note varchar

public class ManageDBPassword2 {

	public static void main(String...args) {
		Application.launch(MainController.class,args);
	}
}
