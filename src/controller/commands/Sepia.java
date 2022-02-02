package controller.commands;

import model.ImageModel;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

/**
 * Implementation class of the {@link Command} class which is used for applying
 * sepiatone transformation to an image. Represents the command which applies
 * sepiatone transformation on the image.
 * 
 * @author Jaswin Gumpella
 *
 */
public class Sepia implements Command {

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) {
    ImageModel sepiatoneModel = new model.SepiatoneTransformation(model.getImage());
    sepiatoneModel.sepiatoneImage();
    model = new ImageProcessingModelImpl(sepiatoneModel.getImage());
    return model;
  }
}
