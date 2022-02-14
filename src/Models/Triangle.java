package Models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Triangle extends Shape {

	public Triangle(int x1, int y1, Color color, float storke) {
		super(x1, y1, color, storke);
		this.setType("Triangle");
	}

	public Triangle(int x1, int y1, Color color, float storke, boolean drawFilled) {
		super(x1, y1, color, storke, drawFilled);
		this.setType("Triangle");
	}

	@Override
	public void draw(Graphics g) {
		this.setHelpingPtX(Math.abs(this.getX1() - this.getX2()));
		this.setHelpingPtY(Math.abs(this.getY1() - this.getY2()));

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getStroke()));
		g2.setColor(getColor());
		int x3 = getX1() - (getX2() - getX1());
		int[] x = { getX1(), getX2(), x3 };
		int[] y = { getY1(), getY2(), getY2() };

		if (this.isIsFilled()) {
			g2.fillPolygon(x, y, 3);
		} else {
			g2.drawPolygon(x, y, 3);
		}
	}

	public void edit(Graphics g, String s) {
		this.setIsEdited(true);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getStroke()));
		g2.setColor(getColor());
		int x3 = getX1() - (getX2() - getX1());
		int[] x = { getX1(), getX2(), x3 };
		int[] y = { getY1(), getY2(), getY2() };

		if (this.isIsFilled()) {
			g2.fillPolygon(x, y, 3);
		} else {
			g2.drawPolygon(x, y, 3);
		}
	}

	@Override
	public void move(Point current, Point prev) {
		int changeX = (int) (current.getX() - prev.getX());
		int changeY = (int) (current.getY() - prev.getY());
		this.getCornerPt().translate(changeX, changeY);
		this.setX1(this.getX1() + changeX);
		this.setX2(this.getX2() + changeX);
		this.setY1(this.getY1() + changeY);
		this.setY2(this.getY2() + changeY);
	}

	public boolean contains(float x, float y) {
		int x3 = getX1() - (getX2() - getX1());
		int a = Math.min(x3, getX2());
		int b = Math.min(getY1(), getY2());
		int c = Math.max(x3, getX2());
		int d = Math.max(getY1(), getY2());
		if ((x >= a && x <= c) && (y >= b && y <= d)) {
			return true;
		}
		return false;
	}
}