package model.channel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implementation class of the {@link FlossColor} interface which represents the
 * implementations of the operations defined in the interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class FlossColorImpl extends ColorChannelImpl implements FlossColor {
  private final Map<Integer, Character> legend;
  private final Map<Integer, ColorChannel> colorPalatte;

  /**
   * Constructs a {@link FlossColor} instance with 3 color channels R, G and B by
   * taking input of the color palette.
   *
   * @param colors   represents the RGB values.
   * @param filename represents the name of the file to fetch the color palette.
   * @throws IllegalArgumentException for invalid size of colors.
   */
  public FlossColorImpl(int[] colors, String filename) throws IOException {
    super(colors);
    colorPalatte = new TreeMap<>();
    legend = new TreeMap<>();
    this.getColorPalette(filename);
  }

  private void getColorPalette(String filename) throws IOException {
    @SuppressWarnings("resource")
    BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      String[] lineArray = line.split(",");
      this.colorPalatte.put(Integer.parseInt(lineArray[0]),
          new ColorChannelImpl(new int[] { Integer.parseInt(lineArray[2]),
              Integer.parseInt(lineArray[3]), Integer.parseInt(lineArray[4]) }));
      this.legend.put(Integer.parseInt(lineArray[0]), (char) Integer.parseInt(lineArray[5]));
    }
  }

  @Override
  public Integer findClosestAvailableFloss() {
    Integer index = (Integer) colorPalatte.keySet().toArray()[0];
    double closestDistance = applyMean(this, colorPalatte.get(index));
    for (Integer code : colorPalatte.keySet()) {
      double newDistance = applyMean(this, colorPalatte.get(code));
      if (newDistance < closestDistance) {
        closestDistance = newDistance;
        index = code;
      }
    }
    return index;
  }

  @Override
  public Character getLegend(int dmcCode) {
    return this.legend.get(dmcCode);
  }

  private double applyMean(ColorChannel c1, ColorChannel c2) {
    double redMean = (c1.getColorChannel()[0] + c2.getColorChannel()[0]) / 2.0;
    double red = (2 + redMean / 256)
        * (Math.abs(c1.getColorChannel()[0] - c2.getColorChannel()[0]));
    double green = Math.pow((Math.abs(c1.getColorChannel()[1] - c2.getColorChannel()[1])), 2) * 4;
    double blue = (2 + (255 - redMean) / 256)
        * Math.pow((Math.abs(c1.getColorChannel()[2] - c2.getColorChannel()[2])), 2);
    return Math.sqrt(red + green + blue);
  }
}
