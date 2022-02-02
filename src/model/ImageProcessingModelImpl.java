package model;

import model.image.Image;

import java.io.IOException;

/**
 * Implementation class of the {@link ImageProcessingModel} interface which
 * contains the extended operations that can be performed on an image.
 * Represents the implementations defined in the interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ImageProcessingModelImpl extends ImageModelImpl implements ImageProcessingModel {
  /**
   * Constructs a ImageModel instance for a given image.
   *
   * @param image represents the original image.
   */
  public ImageProcessingModelImpl(Image image) {
    super(image);
  }

  @Override
  public void mosaicImage(int numberOfSeeds) {
    // Method to be overridden in child class.
  }

  @Override
  public void pixelateImage(int numberOfSuperPixels) {
    // Method to be overridden in child class.
  }

  @Override
  public void patternImage() throws IOException {
    // Method to be overridden in child class.
  }

  @Override
  public void savePattern(String filename) throws IOException {
    // Method to be overridden in child class.
  }

}
