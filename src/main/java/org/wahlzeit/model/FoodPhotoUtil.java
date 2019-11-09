package org.wahlzeit.model;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesServiceFactory;

public class FoodPhotoUtil extends PhotoUtil {
    /**
     * @methodtype creation
     */
    public static FoodPhoto createPhoto(String filename, PhotoId id, Image uploadedImage) throws Exception {
        FoodPhoto result = FoodPhotoFactory.getInstance().createPhoto(id);
        result.setEnding(filename.substring(filename.lastIndexOf(".") + 1));

        createImageFiles(uploadedImage, result);

        int sourceWidth = uploadedImage.getWidth();
        int sourceHeight = uploadedImage.getHeight();
        result.setWidthAndHeight(sourceWidth, sourceHeight);

        return result;
    }

    /**
     *
     */
    public static void createImageFiles(Image source, FoodPhoto photo) throws Exception {
        assertIsValidImage(source);

        int sourceWidth = source.getWidth();
        int sourceHeight = source.getHeight();
        assertHasValidSize(sourceWidth, sourceHeight);

        for (PhotoSize size : PhotoSize.values()) {
            if (!size.isWiderAndHigher(sourceWidth, sourceHeight)) {
                scaleImage(ImagesServiceFactory.makeImage(source.getImageData()), size, photo);
            }
        }
    }

}
