package model;

import model.channel.FlossColor;
import model.channel.FlossColorImpl;
import model.image.Image;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Extension of the {@link ImagePattern} class to implement the cross stitch
 * pattern image chunking. Represents the implementations related to cross
 * stitch pattern defined in the interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class CrossStitchPattern extends ImagePattern {

  /**
   * Constructor of the {@link CrossStitchPattern} which takes input of the image
   * to be modified and the location of the available floss color palette.
   * 
   * @param image                    which represents the image on which the
   *                                 operations are to be performed.
   * @param availablePaletteFileName which represents the name of the file which
   *                                 contains the available floss color palette.
   */
  public CrossStitchPattern(Image image, String availablePaletteFileName) {
    super(image, availablePaletteFileName);
  }

  @Override
  public void patternImage() throws IOException {
    Map<Integer, FlossColor> flossColor = new HashMap<>();
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        flossColor.put(j,
            new FlossColorImpl(image.getImage()[i][j], this.availablePaletteFileName));
      }
      this.pattern.put(i, flossColor);
    }
  }

}