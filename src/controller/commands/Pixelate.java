package controller.commands;

import model.ImagePixelation;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

/**
 * Implementation class of the {@link Command} class which is used for applying
 * pixelation image chunking to an image. Represents the command which applies
 * pixelation image chunking on the image.
 * 
 * @author Jaswin Gumpella
 *
 */
public class Pixelate implements Command {
  private final int numberOfSquares;

  /**
   * /** Constructor for the {@link Pixelate} class which takes the number of
   * squares as input.
   * 
   * @param numberOfSquares which represents the number of squares the image
   *                        pixelation is to be done on the image.
   */
  public Pixelate(int numberOfSquares) {
    this.numberOfSquares = numberOfSquares;
  }

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) throws IllegalArgumentException {
    ImageProcessingModel pixelateModel = new ImagePixelation(model.getImage());
    pixelateModel.pixelateImage(numberOfSquares);
    model = new ImageProcessingModelImpl(pixelateModel.getImage());
    return model;
  }
}
