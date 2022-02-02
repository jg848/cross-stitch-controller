import static org.junit.Assert.assertEquals;

import controller.ImageController;
import controller.ImageControllerImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Test class for {@link ImageController}.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ImageControllerTest {
  private ImageController controller;
  private File file;

  /**
   * Method to setup the test class with required attributes.
   */
  @Before
  public void setUp() {
    file = new File("");
  }

  /**
   * Test method for load command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testLoadCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\load.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\n", out.toString());
  }

  /**
   * Test method for command without load.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testNoLoadCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\noload.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("load command expected before any other commands.\n" + "blur failed\n",
        out.toString());
  }

  /**
   * Test method for command with invalid load.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test(expected = IOException.class)
  public void testInvalidLoadCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\invalidload.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
  }

  /**
   * Test method for blur command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testBlurCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\blur.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\nblur successful\n", out.toString());
  }

  /**
   * Test method for sharpen command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testSharpenCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\sharpen.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\nsharpen successful\n", out.toString());
  }

  /**
   * Test method for greyscale command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testGreyscaleCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\greyscale.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\ngreyscale successful\n", out.toString());
  }

  /**
   * Test method for sepia command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testSepiaCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\sepia.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\nsepia successful\n", out.toString());
  }

  /**
   * Test method for colordither command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testColorDitherCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\colordither.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\ncolordither successful\n", out.toString());
  }

  /**
   * Test method for colordither command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testColorDitherCommandInvalidArguments() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\invalidcolordither.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\ncolordither failed\n", out.toString());
  }

  /**
   * Test method for greyscaledither command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testGreyscaleDitherCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\greyscaledither.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\ngreyscaledither successful\n", out.toString());
  }

  /**
   * Test method for greyscaledither command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testGreyscaleDitherCommandInvalidArguments() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\invalidgreyscaledither.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\ngreyscaledither failed\n", out.toString());
  }

  /**
   * Test method for mosaic command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testMosaicCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\mosaic.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\nmosaic successful\n", out.toString());
  }

  /**
   * Test method for mosaic command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testMosaicCommandInvalidArguments() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\invalidmosaic.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\nmosaic failed\n", out.toString());
  }

  /**
   * Test method for pixelate command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testPixelateCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\pixelate.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\npixelate successful\n", out.toString());
  }

  /**
   * Test method for pixelate command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testPixelateCommandInvalidArguments() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\invalidpixelate.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\npixelate failed\n", out.toString());
  }

  /**
   * Test method for pattern command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testPatternCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\pattern.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\npattern successful\n", out.toString());
  }

  /**
   * Test method for save command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testSaveImageCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\blursave.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\nblur successful\n" + "Saving to file successful\n",
        out.toString());
  }

  /**
   * Test method for savetext command.
   * 
   * @throws IOException for invalid file locations.
   */
  @Test
  public void testSaveTextCommand() throws IOException {
    Reader in = new FileReader(file.getAbsolutePath() + "\\res\\patternsavetext.txt");
    StringBuffer out = new StringBuffer();
    controller = new ImageControllerImpl(in, out);
    controller.start();
    assertEquals("Loading image.\npattern successful\n" + "Saving to text successful\n",
        out.toString());
  }

}
