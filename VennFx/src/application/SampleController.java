package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {
	@FXML
	private Button button;
	private String information;
	@FXML
	private TextField textField;
	@FXML
	private Label label;

	@FXML 
	public void buttonClicked() {
		information = textField.getText();
		System.out.println(information);
		System.out.println("Button CLicked!");
	}
}
