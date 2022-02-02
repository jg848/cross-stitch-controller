package model;

import model.image.Image;
import model.utils.ImageUtilities;

import java.io.IOException;

/**
 * Abstract implementation class for the {@link ImageModel} interface. Contains
 * the common features required for the operations defined in the
 * {@link ImageModel} interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public abstract class ImageModelImpl implements ImageModel {

  protected Image image;

  /**
   * Constructor for the abstract implementation class of {@link ImageModel}.
   */
  protected ImageModelImpl(Image image) {
    if (null == image) {
      throw new IllegalArgumentException("Image is invalid.");
    }
    this.image = image;
  }

  @Override
  public void blurImage() {
    // Method to be overridden in child class.
  }

  @Override
  public void sharpenImage() {
    // Method to be overridden in child class.
  }

  @Override
  public void greyscaleImage() {
    // Method to be overridden in child class.
  }

  @Override
  public void sepiatoneImage() {
    // Method to be overridden in child class.
  }

  @Override
  public void colorDitherImage(int numberOfColors) {
    // Method to be overridden in child class.
  }

  @Override
  public void greyscaleDitherImage(int numberOfColors) {
    // Method to be overridden in child class.
  }

  @Override
  public void saveImage(String filename) throws IOException {
    if (null == filename || filename.isBlank()) {
      throw new IllegalArgumentException("Filename cannot be empty.");
    }
    try {
      ImageUtilities.writeImage(this.image.getImage(), this.image.getWidth(),
          this.image.getHeight(), filename);
    } catch (IOException e) {
      throw new IOException("Unable to write image.");
    }
  }
  
  @Override
  public Image getImage() {
    return this.image;
  }

}
