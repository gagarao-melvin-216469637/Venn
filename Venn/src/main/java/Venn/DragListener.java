package Venn;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragListener extends MouseAdapter {

	private final Component COMPONENT_TO_DRAG;
	private final int MOUSE_BUTTON;
	private Point mousePosition;
	private Point sourceLocation;
	private Point locationOnScreen;
	private int buttonPressed;

	public DragListener(final Component componentToDrag) {
		this(componentToDrag, MouseEvent.BUTTON1);
	}

	public DragListener(final Component componentToDrag, final int mouseButton) {
		this.COMPONENT_TO_DRAG = componentToDrag;
		this.MOUSE_BUTTON = mouseButton;
	}

	@Override
	public void mousePressed(final MouseEvent e) {
		this.buttonPressed = e.getButton();
		this.mousePosition = MouseInfo.getPointerInfo().getLocation();
		this.sourceLocation = new Point();
	}

	@Override
	public void mouseDragged(final MouseEvent e) {
		if (this.buttonPressed == MOUSE_BUTTON) {
			this.locationOnScreen = e.getLocationOnScreen();
			this.sourceLocation = this.COMPONENT_TO_DRAG.getLocation(this.sourceLocation);
			this.sourceLocation.translate((int) (this.locationOnScreen.getX() - this.mousePosition.getX()),
					(int) (this.locationOnScreen.getY() - this.mousePosition.getY()));
			this.COMPONENT_TO_DRAG.setLocation(this.sourceLocation);
			this.mousePosition = MouseInfo.getPointerInfo().getLocation();
		}
	}

	public void addHandle(Component handle) {
		handle.addMouseListener(this);
		handle.addMouseMotionListener(this);
	}
}
