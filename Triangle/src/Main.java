public class Main {
    public static void main(String[] args) {
        Coordinate first= new Coordinate(-1,-1);
        Coordinate second=new Coordinate(10, -1);
        Coordinate third = new Coordinate(-1, 10);
        Triangle test = new Triangle(first, second, third);
        System.out.println(test.isCorrectCoords());
        test.setSides();
        System.out.println(test.isTriangleExists());
        System.out.println(test.isTriangeIsosceles());
        test.setS();
        System.out.println(test.getS());
    }
}
