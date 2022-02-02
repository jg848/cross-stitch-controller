package controller.commands;

import model.CrossStitchPattern;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

import java.io.File;
import java.io.IOException;

/**
 * Implementation class of the {@link Command} class which is used for saving an
 * image into a text file. Represents the command which saves the image into a
 * text in the given location.
 * 
 * @author Jaswin Gumpella
 *
 */
public class SaveText implements Command {
  private final String filename;

  /**
   * Constructor for the {@link SaveText} class which takes the filename as input.
   * 
   * @param filename which represents the location of the file to be saved.
   */
  public SaveText(String filename) {
    this.filename = filename;
  }

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) throws IOException {
    File file = new File("");
    ImageProcessingModel patternModel = new CrossStitchPattern(model.getImage(),
        file.getAbsolutePath() + "\\dmc-floss.csv");
    patternModel.savePattern(file.getAbsolutePath() + "\\" + filename);
    model = new ImageProcessingModelImpl(patternModel.getImage());
    return model;
  }
}
