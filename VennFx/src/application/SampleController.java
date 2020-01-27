package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SampleController {
	@FXML
	private Button button;
	private String information;
	@FXML
	private TextField textField;
	@FXML
	private Label label;
	@FXML
	private Button file;
	@FXML 
	public void buttonClicked() {
		information = textField.getText();
		label.setText(information);
	}
	
	@FXML
	public void fileButtonClicked() {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("Open source File");
		filechooser.showOpenDialog(new Stage());
	}
}
