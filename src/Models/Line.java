package Models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

public class Line extends Shape {

	public Line(int x1, int y1, Color color, float stroke) {
		super(x1, y1, color, stroke);
		this.setType("Line");
	}

	@Override
	public void draw(Graphics g) {
		this.setCornerPt(new Point(this.getX1(), this.getY1()));
		this.setHelpingPtX(this.getX2() - this.getX1());
		this.setHelpingPtY(this.getY2() - this.getY1());
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(this.getStroke()));
		g2.setColor(this.getColor());
		g2.draw(new Line2D.Float((int) this.getCornerPt().getX(), (int) this.getCornerPt().getY(), this.getX2(),
				this.getY2()));

	}

	public void edit(Graphics g, String s) {
		this.setIsEdited(true);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(this.getStroke()));
		g2.setColor(this.getColor());
		g2.draw(new Line2D.Float((int) this.getCornerPt().getX(), (int) this.getCornerPt().getY(),
				(int) this.getCornerPt().getX() + this.getHelpingPtX(),
				(int) this.getCornerPt().getY() + this.getHelpingPtY()));
	}

	@Override
	public void move(Point current, Point prev) {
		this.getCornerPt().translate((int) (current.getX() - prev.getX()), (int) (current.getY() - prev.getY()));
	}
	

	public boolean contains(float x, float y) {
		int width = this.getHelpingPtX();
		int height = this.getHelpingPtY();
		int x1 = Math.min(this.getCornerPt().x, width + this.getCornerPt().x);
		int x2 = Math.max(this.getCornerPt().x, width + this.getCornerPt().x);
		int y1 = Math.min(this.getCornerPt().y, height + this.getCornerPt().y);
		int y2 = Math.max(this.getCornerPt().y, height + this.getCornerPt().y);

		float y3 = this.getY2() - this.getY1();
		float x3 = this.getX2() - this.getX1();
		float m = y3 / x3;
		int fx;
		if (m < 0) {
			fx = Math.round(Math.abs(m) * (x2 - x) + y1 - 20);
		} else {
			fx = Math.round(m * (x - x1) + y1);
		}
		int dif = Math.abs((int) y - fx);
		int vert = Math.max((int) Math.abs(x - x1), (int)Math.abs(x2 - x));
		int hori = Math.max((int) Math.abs(y - y1), (int)Math.abs(y2 - y));
		if (vert >= 0 && vert <= 10 && (y >= (y1 - 20) && y <= (y2 + 20))) {
			return true;
		}
		
		if (hori >= 0 && hori <= 10 && (x >= (x1 - 20) && x <= (x2 + 20))) {
			return true;
		}
		
		if ((x >= (x1 - 20) && x <= (x2 + 20)) && (y >= (y1 - 20) && y <= (y2 + 20))) {
			if (dif >= 0 && dif <= 25) {
				return true;
			}
			if (vert >= 0 && vert <= 10) {
				return true;
			}
			if (hori >= 0 && hori <= 10) {
				return true;
			}
		}
		return false;
	}
}
