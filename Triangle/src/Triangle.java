public class Triangle {
    private Coordinate A;
    private Coordinate B;
    private Coordinate C;

    public Triangle(Coordinate a, Coordinate b, Coordinate c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }
    private int slide1;
    private int slide2;
    private int slide3;
    private double S;

    public Boolean isCorrectCoords(){
        return ((this.C.getX()-this.A.getX())*(this.B.getY()-this.A.getY())!=(this.C.getY()-this.A.getY())*(this.B.getX()-this.A.getX()));
    }
    public void setSides() {
        this.slide1 = (int) Math.sqrt(Math.pow(this.B.getX()-this.A.getX(), 2)+Math.pow(this.B.getY()-this.A.getY(), 2));
        this.slide2 = (int) Math.sqrt(Math.pow(this.C.getX()-this.B.getX(), 2)+Math.pow(this.C.getY()-this.B.getY(), 2));
        this.slide3 = (int) Math.sqrt(Math.pow(this.C.getX()-this.A.getX(), 2)+Math.pow(this.C.getY()-this.A.getY(), 2));
    }

    public Boolean isTriangleExists(){
        return ((this.slide1 < this.slide2+this.slide3) && (this.slide2 < this.slide1+this.slide3) && (this.slide3 < this.slide1+this.slide2));
    }

    public boolean isTriangeIsosceles(){
        boolean isTriangleIsosceles = false;
        if ((this.slide1==this.slide2 || this.slide2==this.slide3 || this.slide1==this.slide3) && (this.slide1!=this.slide2) || this.slide2!=this.slide3 || this.slide1!=this.slide3){
            isTriangleIsosceles = true;
        }
        return isTriangleIsosceles;
    }
    public void setS(){
        double p=(this.slide1+this.slide2+this.slide3)/2;
        this.S= Math.sqrt(p*(p-this.slide1)*(p-this.slide2)*(p-slide3));
    }

    public double getS() {
        return S;
    }

    public int getSlide1() {
        return this.slide1;
    }

    public int getSlide2() {
        return this.slide2;
    }

    public int getSlide3() {
        return this.slide3;
    }
    public String getCoords(){
        return this.A.getX()+" "+this.A.getY()+" "+this.B.getX()+" "+this.B.getY()+" "+this.C.getX()+" "+this.C.getY();
    }

}
