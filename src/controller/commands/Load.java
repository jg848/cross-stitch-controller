package controller.commands;

import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import model.image.ImageImpl;

import java.io.File;
import java.io.IOException;

/**
 * Implementation class of the {@link Command} class which is used for loading
 * an image. Represents the command which loads the image from the given
 * location.
 * 
 * @author Jaswin Gumpella
 *
 */
public class Load implements Command {
  private final String filename;

  /**
   * Constructor for the {@link Load} class which takes input of the filename
   * where the image is to be loaded from.
   * 
   * @param filename which represents the location of the file to be loaded.
   */
  public Load(String filename) {
    this.filename = filename;
  }

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) throws IOException {
    File file = new File("");
    model = new ImageProcessingModelImpl(new ImageImpl(file.getAbsolutePath() + "\\" + filename));
    return model;
  }
}
