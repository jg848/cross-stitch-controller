package controller.commands;

import model.CrossStitchPattern;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

import java.io.File;
import java.io.IOException;

/**
 * Implementation class of the {@link Command} class which is used for applying
 * pattern image chunking to an image. Represents the command which applies
 * pattern image chunking on the image.
 * 
 * @author Jaswin Gumpella
 *
 */
public class Pattern implements Command {

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) throws IOException {
    File file = new File("");
    ImageProcessingModel patternModel = new CrossStitchPattern(model.getImage(),
        file.getAbsolutePath() + "\\dmc-floss.csv");
    patternModel.patternImage();
    model = new ImageProcessingModelImpl(patternModel.getImage());
    return model;
  }
}
