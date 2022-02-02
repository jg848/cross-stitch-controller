package image;

import controller.ImageController;
import controller.ImageControllerImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main class to test image controller.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ImageCrossStitchControllerMain {

  /**
   * Main method for the class.
   * 
   * @param args represents the command line arguments.
   */
  public static void main(String[] args) {
    try {
      File file = new File("");
      BufferedReader input = new BufferedReader(
          new FileReader(file.getAbsolutePath() + "\\" + args[0]));
      ImageController controller = new ImageControllerImpl(input, System.out);
      controller.start();
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
