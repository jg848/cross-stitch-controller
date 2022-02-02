package controller.commands;

import model.ImageModel;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

/**
 * Implementation class of the {@link Command} class which is used for applying
 * greyscale transformation to an image. Represents the command which applies
 * greyscale transformation on the image.
 * 
 * @author Jaswin Gumpella
 *
 */
public class GreyScale implements Command {

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) {
    ImageModel greyscaleModel = new model.GreyscaleTransformation(model.getImage());
    greyscaleModel.greyscaleImage();
    model = new ImageProcessingModelImpl(greyscaleModel.getImage());
    return model;
  }
}
