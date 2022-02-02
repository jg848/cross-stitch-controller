package model;

import model.channel.FlossColor;
import model.channel.FlossColorImpl;
import model.image.Image;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class which extends the {@link ImageProcessingModelImpl} class to implement
 * the operations related to pattern image chunking defined in
 * {@link ImageProcessingModel}. Represents the implementation of the pattern
 * image chunking related operations defined in the interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ImagePattern extends ImageProcessingModelImpl {

  protected Map<Integer, Map<Integer, FlossColor>> pattern;
  protected String availablePaletteFileName;

  protected ImagePattern(Image image, String fileName) {
    super(image);
    this.pattern = new HashMap<>();
    this.availablePaletteFileName = fileName;
  }

  @Override
  public void savePattern(String filename) throws IOException {
    FileWriter fileWriter = new FileWriter(filename);
    Map<Integer, Character> legendMap = new TreeMap<>();
    fileWriter.append(String.valueOf(image.getWidth()));
    fileWriter.append("x").append(String.valueOf(image.getHeight())).append("\n");
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        FlossColor dmcColor = new FlossColorImpl(image.getImage()[i][j],
            this.availablePaletteFileName);
        int closestColor = dmcColor.findClosestAvailableFloss();
        char legend = dmcColor.getLegend(closestColor);
        legendMap.put(closestColor, legend);
        fileWriter.append(legend);
      }
      fileWriter.append("\n");
    }

    fileWriter.append("\n").append("LEGEND:").append("\n");
    legendMap.keySet().forEach(code -> {
      try {
        fileWriter.append(legendMap.get(code)).append(" ").append("DMC - ")
            .append(String.valueOf(code)).append("\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    fileWriter.close();
  }

}
