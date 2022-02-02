package model.utils;

import model.ImageModel;
import model.channel.ColorChannel;
import model.image.Image;
import model.pixel.Pixel;

/**
 * Implementation class of the {@link ImageModelUtils} interface which contains
 * the implementations of the operations defined in the interface. Represents
 * the utilities provided for the {@link ImageModel}.
 * 
 * @author Jaswin Gumpella
 *
 */
public abstract class ImageModelUtilsImpl implements ImageModelUtils {

  /**
   * Default constructor of the class.
   */
  protected ImageModelUtilsImpl() {
    super();
  }

  @Override
  public int[] applyFilterToImage(Image image, double[][] filter, Pixel curPixel) {
    return new int[0];
  }

  @Override
  public int[] applyTransformationToImage(double[][] transformation, Pixel curPixel) {
    return new int[0];
  }

  @Override
  public int[] applyColorDitherToImage(ColorChannel oldColor, int numberOfColors) {
    return new int[0];
  }

  @Override
  public int[][][] calculateErrors(int[][][] image, int row, int column, int color, int error) {
    if (null == image) {
      throw new IllegalArgumentException("Invalid image matrix.");
    }
    try {
      int errorRightPixel = image[row][column + 1][color] + (int) Math.round((7 / 16.0) * error);
      image[row][column + 1][color] = errorRightPixel;
    } catch (ArrayIndexOutOfBoundsException a) {
      // ignore exception.
    }
    try {
      int errorNextRowLeftPixel = image[row + 1][column - 1][color]
          + (int) Math.round((3 / 16.0) * error);
      image[row + 1][column - 1][color] = errorNextRowLeftPixel;
    } catch (ArrayIndexOutOfBoundsException a) {
      // ignore exception.
    }
    try {
      int errorNextRowPixel = image[row + 1][column][color] + (int) Math.round((5 / 16.0) * error);
      image[row + 1][column][color] = errorNextRowPixel;
    } catch (ArrayIndexOutOfBoundsException a) {
      // ignore exception.
    }
    try {
      int errorNextRowRightPixel = image[row + 1][column + 1][color]
          + (int) Math.round((1 / 16.0) * error);
      image[row + 1][column + 1][color] = errorNextRowRightPixel;
    } catch (ArrayIndexOutOfBoundsException a) {
      // ignore exception.
    }

    return image;
  }

}
