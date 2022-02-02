package controller.commands;

import model.BlurFilter;
import model.ImageModel;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

/**
 * Implementation class of the {@link Command} class which is used for applying
 * blur filtering to an image. Represents the command which applies blur filter
 * on the image.
 * 
 * @author Jaswin Gumpella
 *
 */
public class Blur implements Command {

  @Override
  public ImageProcessingModel execute(ImageProcessingModel model) {
    ImageModel blurModel = new BlurFilter(model.getImage());
    blurModel.blurImage();
    model = new ImageProcessingModelImpl(blurModel.getImage());
    return model;
  }
}
