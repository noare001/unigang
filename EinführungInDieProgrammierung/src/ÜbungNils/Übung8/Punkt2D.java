package ÜbungNils.Übung8;

public class Punkt2D {
 double x, y;
 
 Punkt2D(double x, double y){
	 this.x = x;
	 this.y = y;
 }
 void setX( double x) {
	 this.x = x;
 }
 void setY( double y) {
	 this.y = y;
 }
 double getX() {
	 return this.x;
 }
 double getY() {
	 return this.y;
 }
 public String  toString() {
	 return "(" + getX() + "," + getY() + ")";
 }
}
