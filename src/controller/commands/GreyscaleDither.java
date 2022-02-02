package controller.commands;

import model.ImageModel;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

/**
 * Implementation class of the {@link Command} class which is used for applying
 * greyscale dithering to an image. Represents the command which applies
 * greyscale dithering on the image.
 * 
 * @author Jaswin Gumpella
 *
 */
public class GreyscaleDither implements Command {
  private final int numberOfColors;

  /**
   * Constructor for the {@link GreyscaleDither} class which takes the number of
   * colors as input.
   * 
   * @param numberOfColors which represents the number of colors the image density
   *                       is to be reduced to.
   */
  public GreyscaleDither(int numberOfColors) {
    this.numberOfColors = numberOfColors;
  }

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) {
    ImageModel greyscaleDitherModel = new model.GreyscaleDither(model.getImage());
    greyscaleDitherModel.greyscaleDitherImage(numberOfColors);
    model = new ImageProcessingModelImpl(greyscaleDitherModel.getImage());
    return model;
  }

}
