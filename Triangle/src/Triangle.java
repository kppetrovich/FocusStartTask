public class Triangle {
    private Coordinate A;
    private Coordinate B;
    private Coordinate C;
    private int a;
    private int b;
    private int c;

    public Boolean isTriangleExists(){
        return ((this.a < this.b+this.c) && (this.b < this.a+this.c) && (this.c < this.a+this.b));
    }
    public Boolean checkCoords(){
        return false;
    }

    public Triangle(Coordinate a, Coordinate b, Coordinate c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }

    public int getA() {
        return a;
    }

    public void setA() {
        this.a = (int) Math.sqrt(Math.pow(this.A.getB(), 2)-Math.pow(this.A.getA(), 2));
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = (int) Math.sqrt(Math.pow(this.B.getB(), 2)-Math.pow(this.B.getA(), 2));
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = (int) Math.sqrt(Math.pow(this.C.getB(), 2)-Math.pow(this.C.getA(), 2));
    }
}
