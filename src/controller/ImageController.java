package controller;

import java.io.IOException;

/**
 * Interface for the controller class which contains the operations supported by
 * the controller for the image processing.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface ImageController {

  /**
   * Method to get the process command given.
   * 
   * @param command which represents the command executed.
   * @return a string which represents the command given.
   */
  public String processCommand(String command);

  /**
   * Method to start the controller of the image processing model.
   * 
   * @throws IOException for invalid file locations.
   */
  public void start() throws IOException;
}
