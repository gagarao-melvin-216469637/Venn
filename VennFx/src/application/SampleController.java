package application;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.sun.javafx.logging.Logger;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SampleController {
	@FXML
	private VBox vMiddle;
	@FXML
	private VBox vRight;
	@FXML
	private StackPane left;
	@FXML
	private StackPane middle;
	@FXML
	private TextArea areaLeft;
	@FXML
	private StackPane right;
	private static Group GROUPLEFT = new Group();
	private static Paint circleColor;
	private static Node selectedNode;
	private static Circle LEFT;
	private static Circle RIGHT;
	@FXML
	private BorderPane border1;
	private static Scene PrimeScene;
	@FXML
	private Pane pane1;
	@FXML
	private VBox propertySet;
	@FXML
	private Slider sizeSet;
	@FXML
	private ColorPicker colorSet;
	@FXML
	private ColorPicker textColor;
	@FXML
	private Button cancel;
	@FXML
	private TextField labelName;
	@FXML
	private Pane bottom;
	@FXML
	private Text delete;
	@FXML
	private Button insert;
	@FXML
	private Pane pane;

	@FXML
	private VBox vLeft;
	@FXML
	private ColorPicker colorLeft;
	private static Circle nodeToEdit;
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
	private MenuItem screenshot;
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
	private MenuItem basicTemp;
	@FXML
	private ColorPicker color;
	@FXML
	private Slider slider;
	@FXML
	private Circle circle;
	@FXML
	private Button create;
	private static VBox PROPERTY;
	
	@FXML
	private ColorPicker textBackground;
	
	@FXML
	public void buttonClicked() {
		Label label1 = new Label();
		PANE = pane;
		pane.getChildren().add(label1);
		this.dragNode(label1);
		this.delete(label1);
		
		information = textField.getText();
//		if(information.length()>11) {
//			char[] informationA = information.toCharArray();
//			information="";
//			for(int i=0; i<informationA.length;i++) {
//				information+=informationA[i];
//				if(i%11==0&&i>=11) {
//					information+="\n";
//				}
//			}
//		}
		
		label1.setMaxWidth(50);
		label1.setWrapText(true);
		label1.setMaxHeight(Double.POSITIVE_INFINITY);
		label1.setTextFill(textColor.getValue());
		label1.setBackground(new Background(new BackgroundFill(textBackground.getValue(),new CornerRadii(5),Insets.EMPTY)));
		label1.setText(information);
		dragInto(label1,vLeft);
		dragInto(label1,vMiddle);
		dragInto(label1,vRight);
		}
	@FXML
	public void basicTemp() {
		circleLeft.setVisible(true);
		circleRight.setVisible(true);
		dragNode(circleLeft);
		dragNode(circleRight);
		
		
	}
	
	
	
	@FXML
	public void circleResize() {
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
		PROPERTY=propertySet;
		try {
			root1 = (AnchorPane) FXMLLoader.load(getClass().getResource("NewCircle.fxml"));
			Scene scene1 = new Scene(root1, 600, 400);
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
		Circle addCircle = new Circle(450, 400, slider.getValue());
		addCircle.setFill(color.getValue());
		addCircle.setOpacity(0.8);
		addCircle.setStroke(Color.BLACK);
		
		Stage popUpWindow = (Stage) create.getScene().getWindow();
		popUpWindow.close();

		
		PANE.getChildren().addAll(addCircle);
		dragNode(addCircle);
		deleteCircle(addCircle);
	}
	
	@FXML
	public void radiusNewCircle() {
		circle.setRadius(slider.getValue());
	}
	
	@FXML
	public void colorNewCircle() {
		circle.setFill(color.getValue());
		circle.setOpacity(0.8);
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

	@FXML
	public void saveAsPng() {
		
		WritableImage image = new WritableImage((int) pane.getScene().getWidth(),
				(int) pane.getScene().getHeight());
		pane.getScene().snapshot(image);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialFileName("VennDiagram.png");
		File newFile = fileChooser.showSaveDialog(new Stage());
		
		// TODO: probably use a file chooser here
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", newFile);
			// System.out.println("snapshot saved: " + newFile.getAbsolutePath());
		} catch (IOException ex) {
			System.out.println("Nothing selected!");
		}
	}
	
	
	
	@FXML
	public void setting(MouseEvent event) {
		
		if(propertySet.isVisible()) {
			propertySet.setVisible(false);
			nodeToEdit = null;
		}
		else {
			nodeToEdit = (Circle) event.getTarget();
			
			propertySet.setLayoutX(event.getSceneX());
			propertySet.setLayoutY(event.getSceneY());
			propertySet.setVisible(true);
			
		}
	}
	@FXML
	public void setColor() {
		nodeToEdit.setFill(colorSet.getValue());
		nodeToEdit.setOpacity(0.8);
		
	}
	@FXML
	public void setSize() {
		
		nodeToEdit.setRadius(sizeSet.getValue());
	}
	public void textBoxOnEnter(TextField text) {

		text.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.ENTER) {

					PANE.requestFocus();
				}
			}
		});
	}

	public void delete(Node node) {

		node.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				
				if (node.getOpacity() == 0.5 && node == selectedNode) {
					node.setOpacity(1);

					selectedNode = null;
				} else {
					node.setOpacity(0.5);

					selectedNode = node;
					PANE.requestFocus();
				}

			}
		});

		PANE.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {

				if (keyEvent.getCode().equals(KeyCode.DELETE)) {
					
					PANE.getChildren().remove(selectedNode);
				}
			}
		});
	}
	
	public void deleteCircle(Circle node) {
		node.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				System.out.println(PROPERTY);
				
				if (selectedNode != node) {
					
					//node.setFill(Color.BLUE);
					node.setOpacity(0.6);
					selectedNode = node;
					PANE.requestFocus();
				} else {
					
					node.setOpacity(0.8);
					circleColor = null;
					selectedNode = null;
				}
				if(PROPERTY.isVisible()) {
					PROPERTY.setVisible(false);
					nodeToEdit = null;
				}
				else {
					nodeToEdit = node;
					
					PROPERTY.setLayoutX(nodeToEdit.getCenterX()+nodeToEdit.getRadius());
					PROPERTY.setLayoutY(nodeToEdit.getCenterY()+nodeToEdit.getRadius());
					PROPERTY.setVisible(true);
					
				}
				if(mouseEvent.getClickCount()==2) {
					TextField textContent = new TextField();
					textContent.setTranslateX(node.getTranslateX());
					textContent.setTranslateY(node.getTranslateY());
				}

			}
		});

		PANE.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {

				if (keyEvent.getCode().equals(KeyCode.DELETE)) {
					PANE.getChildren().remove(selectedNode);
					PROPERTY.setVisible(false);
				}
			}
		});
	}
	public void consumeDrag(Circle circle) {
		circle.setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				
				Label element = (Label) event.getTarget();
				
				GROUPLEFT.getChildren().addAll(circle,element);
				GROUPLEFT.setAutoSizeChildren(true);
				
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
	public void deleteV(Label label, VBox v) {

		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				
				if (label.getOpacity() == 0.5 && label == selectedNode) {
					label.setOpacity(1);

					selectedNode = null;
				} else {
					label.setOpacity(0.5);

					selectedNode = label;
					v.requestFocus();;
				}

			}
		});

		v.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {

				if (keyEvent.getCode().equals(KeyCode.DELETE)) {
					
					v.getChildren().remove(selectedNode);
				}
			}
		});
	}
	
public void dragInto(Label source, VBox target) {
	source.setOnDragDetected(event -> {
        /* drag was detected, start drag-and-drop gesture */

        /* allow any transfer mode */
        Dragboard db = source.startDragAndDrop(TransferMode.ANY);

        /* put a string on dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putString(source.getText());
        db.setContent(content);

        event.consume();
    });

    target.setOnDragOver(event -> {
        /* data is dragged over the target */

        /*
         * accept it only if it is not dragged from the same node and if it
         * has a string data
         */
        if (event.getGestureSource() != target && event.getDragboard().hasString()) {
            /* allow for both copying and moving, whatever user chooses */
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        event.consume();
    });

    target.setOnDragEntered(event -> {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
        if (event.getGestureSource() != target && event.getDragboard().hasString()) {
            
        }

        event.consume();
    });

    target.setOnDragExited(event -> {
        /* mouse moved away, remove the graphical cues */
        

        event.consume();
    });

    target.setOnDragDropped(event -> {
        /* data dropped */
        /* if there is a string data on dragboard, read it and use it */
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
        	target.alignmentProperty();
        	Label child = new Label(db.getString());
        	child.setTextFill(source.getTextFill());
        	child.setBackground(source.getBackground());
           target.getChildren().add(child);
           deleteV(child,target);
           
            success = true;
        }
        /*
         * let the source know whether the string was successfully
         * transferred and used
         */
        event.setDropCompleted(success);

        event.consume();
    });

    source.setOnDragDone(event -> {
        /* the drag-and-drop gesture ended */
        /* if the data was successfully moved, clear it */
        if (event.getTransferMode() == TransferMode.MOVE) {
            source.setText("");
        }

        event.consume();
    });

}
}
