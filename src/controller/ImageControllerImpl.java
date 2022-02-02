package controller;

import controller.commands.Blur;
import controller.commands.ColorDither;
import controller.commands.Command;
import controller.commands.GreyScale;
import controller.commands.GreyscaleDither;
import controller.commands.Load;
import controller.commands.Mosaic;
import controller.commands.Pattern;
import controller.commands.Pixelate;
import controller.commands.Save;
import controller.commands.SaveText;
import controller.commands.Sepia;
import controller.commands.Sharpen;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import model.image.Image;
import model.image.ImageImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Implementation class of the {@link ImageController} interface which contains
 * the implementations of the operations to be supported by the controller
 * defined in the interface.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ImageControllerImpl implements ImageController {
  private final Readable input;
  private final Appendable output;
  private final Map<String, Function<String, Command>> listOfCommands;

  /**
   * Constructor for the {@link ImageControllerImpl}.
   * 
   * @param input  which is the command input given to the controller.
   * @param output which represents the output to be given after execution.
   */
  public ImageControllerImpl(Readable input, Appendable output) {
    this.input = input;
    this.output = output;
    this.listOfCommands = new HashMap<>();
    this.listOfCommands.put("save", Save::new);
    this.listOfCommands.put("blur", in -> new Blur());
    this.listOfCommands.put("sharpen", in -> new Sharpen());
    this.listOfCommands.put("greyscale", in -> new GreyScale());
    this.listOfCommands.put("sepia", in -> new Sepia());
    this.listOfCommands.put("colordither", in -> new ColorDither(Integer.parseInt(in)));
    this.listOfCommands.put("greyscaledither", in -> new GreyscaleDither(Integer.parseInt(in)));
    this.listOfCommands.put("pixelate", in -> new Pixelate(Integer.parseInt(in)));
    this.listOfCommands.put("mosaic", in -> new Mosaic(Integer.parseInt(in)));
    this.listOfCommands.put("pattern", in -> new Pattern());
    this.listOfCommands.put("load", in -> new Load(in));
  }

  @Override
  public String processCommand(String status) {
    return status;
  }

  @Override
  public void start() throws IOException {
    Scanner scanner = new Scanner(input);
    List<String> commands = new ArrayList<>();
    Image image = null;
    ImageProcessingModel model = null;
    while (scanner.hasNextLine()) {
      commands.add(scanner.nextLine());
    }
    scanner.close();
    File file = new File("");
    boolean load = false;
    if (commands.get(0).split(" ")[0].equals("load") || (commands.get(0).split(" ").length > 1)) {
      image = new ImageImpl(file.getAbsolutePath() + "\\" + commands.get(0).split(" ")[1]);
      model = new ImageProcessingModelImpl(image);
      this.output.append("Loading image.\n");
      load = true;
    } else {
      this.output.append("load command expected before any other commands.\n");
      load = false;
    }
    if (load) {
      for (String commandString : commands) {
        String command = commandString.split(" ")[0];
        if (this.listOfCommands.containsKey(command)) {
          if (commandString.split(" ").length > 1) {
            if (command.equals("save")) {
              if (commandString.split(" ")[1].split("\\.")[1].equals("txt")) {
                try {
                  Command saveText = new SaveText(commandString.split(" ")[1]);
                  saveText.execute(model);
                  this.output.append("Saving to text successful\n");
                } catch (IOException | NullPointerException e) {
                  this.output.append(processCommand("Saving to text")).append(" failed\n");
                }
              } else {
                try {
                  Command save = new Save(commandString.split(" ")[1]);
                  save.execute(model);
                  this.output.append("Saving to file successful\n");
                } catch (IOException | NullPointerException e) {
                  this.output.append(processCommand("Saving to file")).append(" failed\n");
                }
              }
            } else {
              try {
                model = this.listOfCommands.get(command).apply(commandString.split(" ")[1])
                    .execute(model);
                this.output.append(processCommand(command)).append(" successful\n");
              } catch (IllegalArgumentException | IOException | NullPointerException exception) {
                this.output.append(processCommand(command)).append(" failed\n");
              }
            }
          } else {
            try {
              model = this.listOfCommands.get(command).apply("").execute(model);
              this.output.append(processCommand(command)).append(" successful\n");
            } catch (IllegalArgumentException | IOException | NullPointerException exception) {
              this.output.append(processCommand(command)).append(" failed\n");
            }
          }
        }
      }
    }
  }
}