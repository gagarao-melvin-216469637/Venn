package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SampleController {
	@FXML
	private Button button;
	@FXML
	private ColorPicker colorLeft;
	@FXML
	private ColorPicker colorRight;
	private String information;
	@FXML
	private TextField textField;
	@FXML
	private Label label;
	@FXML
	private Button file;
	@FXML
	private Circle circleLeft;
	@FXML
	private Circle circleRight;
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
	@FXML
	public void colorLeftClicked() {
		this.circleLeft.setFill(colorLeft.getValue());
		this.circleLeft.setOpacity(0.60);
	}
	@FXML
	public void colorRightClicked() {
		this.circleRight.setFill(colorRight.getValue());
		this.circleRight.setOpacity(0.60);
	}
}
