package model;

import model.image.Image;

/**
 * This class extends the abstract {@link ImageProcessingModelImpl} class and
 * implements the {@link ImageProcessingModel} interface. Class to be used as an
 * extension for the operations related to the chunking of an image defined in
 * the {@link ImageProcessingModel} interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ImageChunking extends ImageProcessingModelImpl {

  /**
   * Constructor for the {@link ImageChunking} class which takes the {@link Image}
   * as argument to provide the model with the {@link Image} that has to be
   * operated on.
   * 
   * @param image which is the image on which the filter is to be applied.
   */
  protected ImageChunking(Image image) {
    super(image);
  }

}
