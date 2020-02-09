package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SampleController {
	@FXML
	private BorderPane border1;
	@FXML
	private Pane pane1;
	@FXML
	private ColorPicker textColor;
	@FXML
	private Button cancel;
	@FXML
	private ColorPicker color;
	@FXML
	private TextField labelName;
	@FXML
	private Button create;
	@FXML
	private Pane bottom;
	@FXML
	private Text delete;
	@FXML
	private Button button;
	@FXML
	private Pane pane;
	@FXML
	private ColorPicker colorLeft;
	@FXML
	private ColorPicker colorRight;
	@FXML
	private Button newCircle;
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
	private Button resize;
	@FXML
	private Rectangle rec;
	private static Pane PANE;
	private Stage popUp;
	@FXML
	public void buttonClicked() {
		Label label1 = new Label();
		pane.getChildren().add(label1);
		this.dragNode(label1);
		this.deletable(label1);
		information = textField.getText();
		label1.setBackground(new Background(new BackgroundFill(textColor.getValue(),new CornerRadii(5),Insets.EMPTY)));
		label1.setText(information);
	}
	@FXML
	public void circleResize() {
		DragResizeMod.makeResizable(circleLeft,null);
		dragNode(circleLeft);
		dragNode(circleRight);
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
	public void createNewCircle() {
		AnchorPane root1;
		PANE = pane;
		try {
			root1 = (AnchorPane)FXMLLoader.load(getClass().getResource("NewCircle.fxml"));
			Scene scene1 = new Scene(root1,600,400);
			popUp = new Stage();
			popUp.initModality(Modality.APPLICATION_MODAL);
			popUp.setScene(scene1);
			popUp.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@FXML
	public void addCircle() {
		Circle addCircle = new Circle(0,0,100);

		Stage popUpWindow = (Stage) create.getScene().getWindow();
		popUpWindow.close();
		addCircle.setFill(color.getValue());
		addCircle.setStroke(Color.BLACK);
		addCircle.setOpacity(0.6);
		dragNode(addCircle);
		PANE.getChildren().add(addCircle);
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
	public void deletable(Node node) {
		node.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.DELETE)) {
					pane.getChildren().remove(node);
				}
			}
		});
	}

	// Method to make sure every label created is draggable
	public void dragNode(Node node) {
		// Custom object to hold x and y positions
		final Delta dragDelta = new Delta();

		node.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				dragDelta.x = node.getLayoutX() - mouseEvent.getSceneX();
				dragDelta.y = node.getLayoutY() - mouseEvent.getSceneY();
			}
		});

		node.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				node.setCursor(Cursor.HAND);
			}
		});

		node.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				node.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
				node.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
			}
		});

		node.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				node.setCursor(Cursor.HAND);
			}
		});

	}

	class Delta {
		double x, y;
	};
}
