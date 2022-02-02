package controller.commands;

import model.ImageModel;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

/**
 * Implementation class of the {@link Command} class which is used for applying
 * sharpen filtering to an image. Represents the command which applies sharpen
 * filter on the image.
 * 
 * @author Jaswin Gumpella
 *
 */
public class Sharpen implements Command {

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) {
    ImageModel sharpenModel = new model.SharpenFilter(model.getImage());
    sharpenModel.sharpenImage();
    model = new ImageProcessingModelImpl(sharpenModel.getImage());
    return model;
  }
}
