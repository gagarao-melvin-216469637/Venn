package application;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
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
	private double dragDeltaX;
	private double dragDeltaY;

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

	@FXML
	public void labelOnDrag(MouseEvent event) {
		Dragboard db = label.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(label.getText());
		db.setContent(content);
		event.consume();
	}


	
	@FXML
	public void DragOverCircleLeft(DragEvent event) {
		/* data is dragged over the target */
		/*
		 * accept it only if it is not dragged from the same node and if it has a string
		 * data
		 */
		if (event.getGestureSource() != circleLeft && event.getDragboard().hasString()) {
			/* allow for moving */
			event.acceptTransferModes(TransferMode.MOVE);
		}

		event.consume();
	}

	@FXML
	public void labelDragDropped(DragEvent event) {
		/* data dropped */
		/* if there is a string data on dragboard, read it and use it */
		Dragboard db = event.getDragboard();
		boolean success = false;
		if (db.hasString()) {
			label.setText(db.getString());
			success = true;
		}
		/*
		 * let the source know whether the string was successfully transferred and used
		 */
		event.setDropCompleted(success);

		event.consume();
	}

	@FXML
	public void labelMousePressed(MouseEvent event) {
		dragDeltaX = label.getLayoutX() - event.getSceneX();
		dragDeltaY = label.getLayoutY() - event.getSceneY();
		label.setCursor(Cursor.MOVE);
	}
	@FXML
	public void labelMouseReleased(MouseEvent event) {
		label.getScene().setCursor(Cursor.HAND);
	}
	@FXML
	public void labelMouseDragged(MouseEvent event) {
		label.setLayoutX(event.getSceneX() + dragDeltaX);
	    label.setLayoutY(event.getSceneY() + dragDeltaY);
	}
	@FXML
	public void labelMouseEntered(MouseEvent event) {
		if (!event.isPrimaryButtonDown()) {
		      label.getScene().setCursor(Cursor.HAND);
		    }
	}
}
