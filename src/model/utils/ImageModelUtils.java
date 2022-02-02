package model.utils;

import model.ImageModel;
import model.channel.ColorChannel;
import model.image.Image;
import model.pixel.Pixel;

/**
 * Interface which contains the utilities provided to the operations defined in
 * the {@link ImageModel}.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface ImageModelUtils {

  /**
   * Method to apply a given filter matrix to the {@link Image} for a
   * {@link Pixel}.
   * 
   * @param image    which is the {@link Image} the filter has to be applied to.
   * @param filter   which is the filter matrix to be applied to the
   *                 {@link Image}.
   * @param curPixel which is the {@link Pixel} of the {@link Image} for which the
   *                 filter has to be applied to.
   * @return an array containing the {@link ColorChannel}.
   */
  public int[] applyFilterToImage(Image image, double[][] filter, Pixel curPixel);

  /**
   * Method to apply a given transformation matrix to the {@link Image} for a
   * {@link Pixel}.
   * 
   * @param transformation which is the transformation matrix to be applied to the
   *                       {@link Image}.
   * @param curPixel       which is the {@link Pixel} of the {@link Image} for
   *                       which the transformation has to be applied to.
   * @return an array containing the {@link ColorChannel}.
   */
  public int[] applyTransformationToImage(double[][] transformation, Pixel curPixel);

  /**
   * Method to apply dithering to the {@link Image} for a {@link ColorChannel}.
   * 
   * @param oldColor       which is the old {@link ColorChannel} of the pixel
   *                       which is to be modified.
   * @param numberOfColors which is the number of colors to be reduced to for the
   *                       {@link Image}.
   * @return an array containing the {@link ColorChannel}.
   */
  public int[] applyColorDitherToImage(ColorChannel oldColor, int numberOfColors);

  /**
   * Method used to calculate errors for applying the Floyd–Steinberg dithering
   * algorithm to dither an {@link Image}.
   * 
   * @param image which is the {@link Image} which has to be dithered.
   * @param i     which represents the height index of the {@link Image}.
   * @param j     which represents the width index of the {@link Image}.
   * @param k     which represents the {@link ColorChannel} index of the
   *              {@link Image}.
   * @param error which is the difference between the old {@link ColorChannel} and
   *              the new {@link ColorChannel} values.
   * @return a matrix representation of the {@link Image}.
   */
  public int[][][] calculateErrors(int[][][] image, int i, int j, int k, int error);
}
