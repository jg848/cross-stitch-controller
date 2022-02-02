# Cross-Stitch Controller

### About/Overview
Image Processing Controller which can be used to build a full MVC application.
Overview:
  - Filtering operations can be performed on an image like **_Blurring_** and **_Sharpening_**.
  - Transformation operations can be performed on an image like **_Greyscale_** and **_Sepia Tone_**.
  - Can reduce the color density of the images using _floyd-steinberg_ dithering algorithm to reduce the number of colors used in the image.
  - Can perform image chunking like mosaic image chunking for the given number of seeds, cross stitch pattern image chunking, pixelation image chunking for the given number of super pixels.
  - Can read a batch file with the list of commands to apply differing image processing features.

### List of features
  - The **_Image_** interface represents an image in the program. **_ImageImpl_** is the implementation class for this interface which implements the operations defined like retrieving image height, image width and a 3D image matrix.
  - The **_ImageModel_** Interface represents the operations that can be performed on the **_Image_**. **_ImageModelImpl_** is an abstract class which is the implementation class of the **_ImageModel_** interface which provides the implementations to the defined operations.
	> **_ImageFilters_** extends the abstract **_ImageModelImpl_** class to implement the filtering operations defined in the **_ImageModel_**.
	>> **_BlurFilter_** and **_SharpenFilter_** are the extensions of **_ImageFilters_** class to apply blur and sharpen filters.
	> **_ImageTransformations_** extends the abstract **_ImageModelImpl_** class to implement the transformation operations defined in the **_ImageModel_**.
	>> **_GreyscaleTransformation_** and **_SepiatoneTransformation_** are extensions of **_ImageTransformations_** class to apply greyscale and sepiatone transformations.
	> **_ImageDensity_** extends the abstract **_ImageModelImpl_** class to implement the density related operations defined in the **_ImageModel_**.
	>> **_ColorDither_** and **_GreyscaleDither_** are the extensions of **_ImageDensity_** class to apply the color dithering and greyscale dithering image density operations.
  - The **_ImageModelUtils_** interface represents the utilities that are provided for the **_ImageModel_** to perform the required operations. Abstract class **_ImageModelUtilsImpl_** is the implementation class for this interface which provides the implementations to the defined operations.
	> **_ImageFiltersUtils_** extends the abstract **_ImageModelUtilsImpl_** class to implement the filtering operation utilities defined in the **_ImageModelUtils_**.
	> **_ImageTransformationsUtils_** extends the abstract **_ImageModelUtilsImpl_** class to implement the transformation operation utilities defined in the **_ImageModelUtils_**.
	> **_ImageDensityUtils_** extends the abstract **_ImageModelUtilsImpl_** class to implement the density related operation utilities defined in the **_ImageModelUtils_**.
  - The **_Pixel_** interface represents a pixel in the image. **_PixelImpl_** class is the implementation class which implements the operations defined in the interface. Can provide details of the pixel like the row number, column number and color channels. Also used to modify the pixel based on the operations of the **_ImageModel_** and clamp the values as required.
  - The **_ColorChannel_** interface represents the color channels of a pixel in an image which has 3 color values **_RED, GREEN and BLUE_**. **_ColorChannelImpl_** is the implementation class of this interface which implements the operations defined in the interface. Can provide the details of the color channels, set the color channels of a pixel and find a color closest in the palette and clamp the color values accordingly for a given color.
	> **_FlossColor_** is the extension of **_ColorChannel_** class to represent the floss colors and **_FlossColorImpl_** is its implementation class which extends the **_ColorChannelImpl_** class.
  - The **_ImageProcessingModel_** interface is an extension to image model to implement image chunking. **_ImageProcessingModelImpl_** is the implementation class which extends the **_ImageModelImpl_** class.
  - The **_ImagePattern_** extends the **_ImageProcessingModelImpl_** abstract class to implement the image chunking operations defined in the **_ImageProcessingModel_**.
	> **__ImagePattern__** is the class for implementing pattern image chunking.
	> **__ImageMosaic__** is the class for implementing mosaic image chunking for the given number of seeds.
	> **__ImagePixelation__** is the class for implementing pixelation image chunking for the given number of super pixels.
  - The **__ImageController__** is the controller class which passes the control to the respective classes. **__ImageControllerImpl__**	is the implementation class. The Controller class takes the input of the command given and passes the control to the respective class declared in the **_Commands_** package.
  - The **_Command_** interface is the class which represents a command to be given to the controller. The interface contains the operations to be supported by a command when the control is passed into it.
	> **_Blur_** is the implementation of **_Command_** which executes the blur filtering operation.
	> **_Sharpen_** is the implementation of **_Command_** which executes the sharpen filtering operation.
	> **_Greyscale_** is the implementation of **_Command_** which executes the greyscale transformation operation.
	> **_Sepia_** is the implementation of **_Command_** which executes the sepiatone transformation operation.
	> **_ColorDither_** is the implementation of **_Command_** which executes the color dithering operation for the given number of colors.
	> **_GreyscaleDither_** is the implementation of **_Command_** which executes the greyscale dithering operation for the given number of colors.
	> **_Mosaic_** is the implementation of **_Command_** which executes the mosaic image chunking operation for the given number of seeds.
	> **_Pixelate_** is the implementation of **_Command_** which executes the pixelation image chunking operation for the given number of super pixels.
	> **_Pattern_** is the implementation of **_Command_** which executes the cross stitch pattern image chunking operation.
	> **_Save_** is the implementation of **_Command_** which executes the save operation for the given destination filename.
	> **_Load_** is the implementation of **_Command_** which executes the load operation for the given source filename.
  
### How To Run
  Instructions to run the **_JAR_** file provided in the **_res/_** folder
  > Use: **_java -jar .\ImageController.jar test.txt_** or **_java -jar .\ImageController.jar test2.txt_** in the command prompt(Windows).
  > **jdk-11 Java version** is used to compile and build the application.

### How to Use the Program
  > The **_ImageCrossStitchControllerMain_** class has a **_main_** function that can demonstrates all the features of **_ImageModel_** and **_ImageProcessingModel_**.
  > It requires a text file which contains the commands to execute.
  > **load** command with filename loads an image.
  > **blur** command applies the blur filter.
  > **sharpen** command applies the sharpen filter.
  > **greyscale** command applies the greyscale transformation.
  > **sepia** command applies the sepiatone transformation.
  > **colordither** command with the number of colors applies the color dithering.
  > **greyscaledither** command with the number of colors applies the greyscale dithering.
  > **mosaic** command with the number of seeds applies the mosaic image chunking.
  > **pixelate** command with the number of super pixels applies the pixelation image chunking.
  > **pattern** command applies the cross stitch pattern image chunking.
  > **save** command with the destination filename saves the image.

### Description of Example Run

  - Executing the command **_java -jar ImageController.jar test.txt_**, we have the below output:
  > Loading image., which shows that the image has been loaded successfully.
  > load successful, which shows that the loading of the image is successful.
  > blur successful, which shows that the blur filter has been applied.
  > Saving to file successful, which shows that the image has been saved with the given filename.
  > load successful, which shows that the loading of the image is successful.
  > sharpen successful, which shows that sharpen filter has been applied.
  > Saving to file successful, which shows that the image has been saved with the given filename.
  > load successful, which shows that the loading of the image is successful.
  > greyscale successful, which shows that greyscale transformation has been applied.
  > Saving to file successful, which shows that the image has been saved with the given filename.
  > load successful, which shows that the loading of the image is successful.
  > sepia successful, which shows that sepiatone transformation has been applied.
  > Saving to file successful, which shows that the image has been saved with the given filename.
  > load successful, which shows that the loading of the image is successful.
  > colordither successful, which shows that color dithering has been applied.
  > Saving to file successful, which shows that the image has been saved with the given filename.
  > load successful, which shows that the loading of the image is successful.
  > greyscaledither successful, which shows that greyscale dithering has been applied.
  > Saving to file successful, which shows that the image has been saved with the given filename.
  > load successful, which shows that the loading of the image is successful.
  > mosaic successful, , which shows that mosaic image chunking has been applied.
  > Saving to file successful, which shows that the image has been saved with the given filename.
  > load successful, which shows that the loading of the image is successful.
  > pixelate successful, which shows that pixelation image chunking has been applied.
  > Saving to file successful, which shows that the image has been saved with the given filename.
  > load successful, which shows that the loading of the image is successful.
  > pattern successful,, which shows that cross stitch pattern image chunking has been applied.
  > Saving to text successful, which shows that the image has been saved with the given filename.

### Design/Model Changes
> Methods of the classes that implement the functionalities have been modified and few helper methods have been included but the structure has been the same.

### Assumptions
> Filename has to be a valid string for reading an image.

> For dithering the image, the number of colors per channel has to be positive.

> Filter matrix for filtering an image has to be of odd dimensions.

> Number of seeds for applying Mosaic has to be valid.

> Number of super pixels for applying pixelation has to be less than any of the dimensions of the image.

> Valid filename has to be given with the commands for saving the files.

### Limitations
> Images used to test the program are of size less than 40kb.

> For filtering and transformation operations, the amount of the operation cannot be given and the operations are to be done on the modified images multiple times.

### Citations
> These images are my own and I authorize to use these images as part of this project.