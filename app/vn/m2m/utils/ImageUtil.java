package vn.m2m.utils;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.DimensionConstrain;
import com.mortennobel.imagescaling.ResampleFilters;
import com.mortennobel.imagescaling.ResampleOp;
import play.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageUtil {
	public static Logger.ALogger logger = Logger.of(ImageUtil.class);

	public final static String IMG_TYPE_JPG  = "jpg";
	public final static String IMG_TYPE_PNG  = "png";
	public final static String IMG_TYPE_GIF  = "gif";
	public final static String IMG_TYPE_JPEG = "jpeg";
	public final static String IMG_TYPE_DEFAULT_AVATAR = ".jpg";
	public final static int AVATAR_WIDTH_SMALL = 100;//px
	public final static int AVATAR_WIDTH_MEDIUM = 200;//px
	public final static int AVATAR_WIDTH_LARGE = 500;//px
	public final static int AVATAR_WIDTH_BIG = 1024;//px

	// image type
	public static boolean checkValidImageType(String imageType) {
		return (IMG_TYPE_GIF.equalsIgnoreCase(imageType)
				|| IMG_TYPE_PNG.equalsIgnoreCase(imageType)
				|| IMG_TYPE_JPG.equalsIgnoreCase(imageType)
				|| IMG_TYPE_JPEG.equalsIgnoreCase(imageType));
	}

	public static String getImageType(String fileName) {
		String[] imageNameSplit   = fileName.split("\\.");
		if(imageNameSplit.length <=1){
			return null;
		}
		return imageNameSplit[imageNameSplit.length - 1];
	}

	public static boolean writeAvatarToDisk(String filename, String folderPath, File file){
		logger.debug("writeAvatarToDisk {}", filename);
		return resizeAndWriteImageToDisk(filename, folderPath, file, AVATAR_WIDTH_BIG);
	}

	public static boolean resizeAndWriteImageToDisk(String filename, String folderPath, File file, int width){
		String imageType = getImageType(filename);
		if(!checkValidImageType(imageType)){
			return false;
		}

		try {
//			File currentDirectory = new File("."+folderPath);
//
//			if (!currentDirectory.exists() || !currentDirectory.isDirectory()) {
//				currentDirectory.mkdir();
//			}
			BufferedImage originalImage = ImageIO.read(file);
			Path filePath = Paths.get(folderPath, filename);
			logger.info("filePath :{} - filename :{}", filePath, filename);

			int originalWidth  = originalImage.getWidth();
			int originalHeight = originalImage.getHeight();

			int sizePx = Math.min(width, Math.min(originalWidth, originalHeight));

			BufferedImage resizeImage = resizeImg(originalImage, sizePx, sizePx);

			ImageIO.write(resizeImage, imageType, Files.newOutputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//telco
	public static boolean writeImgToDisk(String filename, String folderPath, File file){
		logger.debug("writeAvatarToDisk {}", filename);
		return resizeAndWriteImgToDisk(filename, folderPath, file, AVATAR_WIDTH_BIG);
	}
	public static boolean resizeAndWriteImgToDisk(String filename, String folderPath, File file, int width){
		String imageType = getImageType(filename);
		if(!checkValidImageType(imageType)){
			return false;
		}

		try {
//			File currentDirectory = new File("."+folderPath);
//
//			if (!currentDirectory.exists() || !currentDirectory.isDirectory()) {
//				currentDirectory.mkdir();
//			}
			BufferedImage originalImage = ImageIO.read(file);
			Path filePath = Paths.get(folderPath, filename);
			logger.info("filePath :{} - filename :{}", filePath, filename);

			int originalWidth  = originalImage.getWidth();
			int originalHeight = originalImage.getHeight();

			BufferedImage resizeImage = resizeImg(originalImage, originalWidth, originalHeight);
			ImageIO.write(resizeImage, imageType, Files.newOutputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static BufferedImage resizeImg(BufferedImage img, int newW, int newH) {
		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
		Graphics2D g = dimg.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
		g.dispose();
		return dimg;
	}

	public static boolean writeImageToDisk(String filename,  String folderPath, File file){
		String imageType = getImageType(filename);

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			ImageIO.write(bufferedImage, imageType, Files.newOutputStream(Paths.get(folderPath,filename)));
		}
		catch (IOException ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean createFile(String filename, int width, int height){
		String imageType = getImageType(filename);
		if(!checkValidImageType(imageType)){
			return false;
		}

		try {
			BufferedImage originalImage = ImageIO.read(new File(filename));

			BufferedImage resizeImage = fit(originalImage, width, height);
			ImageIO.write(resizeImage, imageType, new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean shrinkFileByWidth(String filename, int width){
		String imageType = getImageType(filename);
		if(!checkValidImageType(imageType)){
			return false;
		}

		try {
			BufferedImage originalImage = ImageIO.read(new File(filename));

			int originalWidth  = originalImage.getWidth();
			int originalHeight = originalImage.getHeight();
						
			int resizeWidth;
			int resizeHeight;
			
			if(originalWidth <= width){
				resizeWidth  = originalWidth;
				resizeHeight = originalHeight;
			} else {
				resizeWidth  = width;
				resizeHeight = (width * originalHeight)/originalWidth;
			} 
						
			BufferedImage resizeImage = fit(originalImage, resizeWidth, resizeHeight);
			ImageIO.write(resizeImage, imageType, new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static InputStream shrinkFileByWidth(InputStream fileInputStream, String imageType, int width){
		if(!checkValidImageType(imageType)){
			return null;
		}
		try {
			BufferedImage originalImage = ImageIO.read(fileInputStream);
			
			int originalWidth  = originalImage.getWidth();
			int originalHeight = originalImage.getHeight();
						
			int resizeWidth;
			int resizeHeight;
			
			if(originalWidth <= width){
				resizeWidth  = originalWidth;
				resizeHeight = originalHeight;
			} else {
				resizeWidth  = width;
				resizeHeight = (width * originalHeight)/originalWidth;
			} 
						
			BufferedImage resizeImage = fit(originalImage, resizeWidth, resizeHeight);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(resizeImage, imageType, os);
			InputStream is = new ByteArrayInputStream(os.toByteArray());			
			os.close();
			return is;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public static InputStream createFile(InputStream fileInputStream, String imageType, int width, int height){
		if(!checkValidImageType(imageType)){
			return null;
		}
		try {
			BufferedImage originalImage = ImageIO.read(fileInputStream);

			BufferedImage resizeImage = fit(originalImage, width, height);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(resizeImage, imageType, os);
			InputStream is = new ByteArrayInputStream(os.toByteArray());
			os.close();
			return is;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}	
	
	public static BufferedImage resize(BufferedImage image, int maxWidth,
			int maxHeight) {
		
		ResampleOp op = new ResampleOp(DimensionConstrain.createMaxDimension(
				maxWidth, maxHeight));

		op.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.Normal);
		op.setFilter(ResampleFilters.getBiCubicFilter());
		
		return op.filter(image, null);
	}

	public static BufferedImage crop(BufferedImage image, int width, int height) {

		int x = 0;
		int y = 0;
		
		if (image.getWidth() <= width) {
			width = image.getWidth();			
		} else {
			x = (int) ((image.getWidth() - width) / 2);
		}
		
		if (image.getHeight() <= height) {
			height = image.getHeight();			
		} else {
			y = (int) ((image.getHeight() - height) / 2);
		}		
		
		return image.getSubimage(x, y, width, height);
	}

	public static BufferedImage fit(BufferedImage image, int width, int height) {
		
		float ow = image.getWidth();
		float oh = image.getHeight();
		float or = ow / oh;
		float r = ((float) width) / ((float) height);

		if (or > r) {
			int nw = (int) (ow * height / oh);
			return crop(resize(image, nw, height), width, height);
		} else if (or < r) {
			int nh = (int) (oh * width / ow);
			return crop(resize(image, width, nh), width, height);
		} else {
			return resize(image, width, height);
		}
	}

	public static boolean copyfile(File srFile, File dtFile) {
		try {

			InputStream in = new FileInputStream(srFile);
			OutputStream out = new FileOutputStream(dtFile);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// Returns the contents of the file in a byte array.
	public static byte[] getBytesFromFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    // Get the size of the file
	    long length = file.length();

	    // You cannot create an array using a long type.
	    // It needs to be an int type.
	    // Before converting to an int type, check
	    // to ensure that file is not larger than Integer.MAX_VALUE.
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }

	    // Create the byte array to hold the data
	    byte[] bytes = new byte[(int)length];

	    // Read in the bytes
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    // Ensure all the bytes have been read in
	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    // Close the input stream and return bytes
	    is.close();
	    return bytes;
	}
	
	public static byte [] getImgBytes(Image image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(getBufferedImage(image), "JPEG", baos);
        } catch (IOException ex) {
            //handle it here.... not implemented yet...
        }
        return baos.toByteArray();
    }
	
    public static BufferedImage getBufferedImage(Image image) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //Graphics2D g2d = bi.createGraphics();
        //g2d.drawImage(image, 0, 0, null);
        return bi;
    }

	public static boolean delImage(String filename,  String folderPath) {
		logger.debug("delImage {}", filename);
		Path path = Paths.get(folderPath,filename);
		try {
			Files.delete(path);
			logger.debug("delImage OK");
		}catch (IOException ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}
}