import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String fileIn = args[0];
        String line = "";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileIn))) {
            while ((line = br.readLine()) != null) {
                String lines[] = line.split(" ");
                Coordinate currentA= new Coordinate(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]));
                Coordinate currentB = new Coordinate(Integer.parseInt(lines[2]), Integer.parseInt(lines[3]));
                Coordinate currentC = new Coordinate(Integer.parseInt(lines[4]), Integer.parseInt(lines[5]));
                Triangle currentTriangle = new Triangle(currentA, currentB, currentC);
                if(currentTriangle.isCorrectCoords()){
                    currentTriangle.setSides();
                    if(currentTriangle.isTriangleExists()){
                        if(currentTriangle.isTriangeIsosceles()){
                            currentTriangle.setS();
                            System.out.println(currentTriangle.getS());
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
