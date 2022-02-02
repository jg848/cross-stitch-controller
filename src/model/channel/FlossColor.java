package model.channel;

/**
 * Extension of the {@link ColorChannel} interface which represents the color of
 * DMC Floss. Contains the operations to be supported by the floss color.
 * 
 * @author Jaswin Gumpella
 *
 */
public interface FlossColor extends ColorChannel {

  /**
   * Method used to find the closest available floss color.
   * 
   * @return an {@link Integer} object which contains the number of the floss
   *         color.
   */
  public Integer findClosestAvailableFloss();

  /**
   * Method used to get the legend to be put into the pattern text file which
   * contains the symbols.
   * 
   * @param dmcCode which is the number of the DMC Floss color.
   * @return an object of {@link Character} which represents the character to be
   *         printed in the pattern text file.
   */
  public Character getLegend(int dmcCode);
}
