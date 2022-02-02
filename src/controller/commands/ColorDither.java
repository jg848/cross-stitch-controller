package controller.commands;

import model.ImageModel;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

/**
 * Implementation class of the {@link Command} class which is used for applying
 * color dithering to an image. Represents the command which applies color
 * dithering on the image.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ColorDither implements Command {
  private final int numberOfColors;

  /**
   * Constructor for the {@link ColorDither} class which takes the number of
   * colors as input.
   * 
   * @param numberOfColors which represents the number of colors the image density
   *                       is to be reduced to.
   */
  public ColorDither(int numberOfColors) {
    this.numberOfColors = numberOfColors;
  }

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) {
    ImageModel colorDitherModel = new model.ColorDither(model.getImage());
    colorDitherModel.colorDitherImage(numberOfColors);
    model = new ImageProcessingModelImpl(colorDitherModel.getImage());
    return model;
  }

}
