package controller.commands;

import model.ImageMosaic;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

/**
 * Implementation class of the {@link Command} class which is used for applying
 * mosaic image chunking to an image. Represents the command which applies
 * mosaic image chunking on the image.
 * 
 * @author Jaswin Gumpella
 *
 */
public class Mosaic implements Command {
  private final int numberOfSeeds;

  /**
   * Constructor for the {@link Mosaic} class which takes the number of seeds as
   * input.
   * 
   * @param numberOfSeeds which represents the number of seeds the image chunking
   *                      is to be done on the image.
   */
  public Mosaic(int numberOfSeeds) {
    this.numberOfSeeds = numberOfSeeds;
  }

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) throws IllegalArgumentException {
    ImageProcessingModel mosaicModel = new ImageMosaic(model.getImage());
    mosaicModel.mosaicImage(numberOfSeeds);
    model = new ImageProcessingModelImpl(mosaicModel.getImage());
    return model;
  }
}
