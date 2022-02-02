package model;

import java.io.IOException;

/**
 * Extension of the {@link ImageModel} interface which contains the operations
 * that can be performed on an image. Contains the extended features of image
 * chunking like mosaic, pixelation and pattern.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface ImageProcessingModel extends ImageModel {

  /**
   * Method to apply mosaic image chunking to an image by taking input of the
   * number of seeds for the image pixels to be reduced to.
   * 
   * @param numberOfSeeds which represents the number of seeds the image pixels
   *                      are to be reduced to.
   * @throws IllegalArgumentException for invalid number of seeds value.
   */
  public void mosaicImage(int numberOfSeeds) throws IllegalArgumentException;

  /**
   * Method to apply pixelation image chunking to an image by taking input of the
   * number of super pixels the image pixels are to be reduced to.
   * 
   * @param numberOfSuperPixels represents the number of super pixels the image
   *                            pixels are to be reduced to.
   * @throws IllegalArgumentException for invalid number of super pixels value.
   */
  public void pixelateImage(int numberOfSuperPixels) throws IllegalArgumentException;

  /**
   * Method to apply cross stitch pattern image chunking.
   * 
   * @throws IOException for invalid filename input.
   */
  public void patternImage() throws IOException;

  /**
   * Method to save the image pattern generated into a text file by taking input
   * of the destination.
   * 
   * @param filename which represents the location of the file to be saved.
   * @throws IOException for invalid filename input.
   */
  public void savePattern(String filename) throws IOException;

}
