import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String fileIn = "";
        String fileOut = "";
        if (args.length != 2) {
            System.out.println("Write correct input and output files paths");
            System.exit(0);

        } else {
            fileIn = args[0];
            fileOut = args[1];
        }
        String line;
        double currentMaxS = -1;
        boolean isAnswer = false;
        Triangle answerTrinagle = null;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileIn))) {
            while ((line = br.readLine()) != null) {
                String lines[] = line.split(" ");
                if (lines.length == 6) {
                    try {
                        Coordinate currentA = new Coordinate(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]));
                        Coordinate currentB = new Coordinate(Integer.parseInt(lines[2]), Integer.parseInt(lines[3]));
                        Coordinate currentC = new Coordinate(Integer.parseInt(lines[4]), Integer.parseInt(lines[5]));
                        Triangle currentTriangle = new Triangle(currentA, currentB, currentC);
                        if (currentTriangle.isCorrectCoords()) {
                            currentTriangle.setSides();
                            if (currentTriangle.isTriangleExists()) {
                                if (currentTriangle.isTriangeIsosceles()) {
                                    currentTriangle.setS();
                                    if (currentTriangle.getS() > currentMaxS) {
                                        answerTrinagle = currentTriangle;
                                        isAnswer = true;
                                    }
                                }
                            }
                        }

                    } catch (NumberFormatException nfe) {

                    }
                }
            }
        } catch (AccessDeniedException ac) {
            System.out.println("Error, check access rights to the file in");
        } catch (FileNotFoundException fnf) {
            System.out.println("Error, file in is not exists");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

        if (isAnswer) {
            try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileOut))) {
                bw.write(answerTrinagle.getCoords());
            } catch (AccessDeniedException ac) {
                System.out.println("Error, check access rights to the file out");
            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
    }
}
