package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class FoodPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static FoodPhotoFactory instance = null;

    protected FoodPhotoFactory() {
        super();
    }

    /**
     * Public singleton access method.
     */
    public static synchronized FoodPhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new FoodPhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    protected static synchronized void setInstance(FoodPhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize PhotoFactory twice");
        }

        instance = photoFactory;
    }


    /**
     * Loads a photo. The Java object is loaded from the Google Datastore, the Images in all sizes are loaded from the
     * Google Cloud storage.
     */
    public FoodPhoto loadPhoto(PhotoId id) {
	   /* Photo result =
                OfyService.ofy().load().type(Photo.class).ancestor(KeyFactory.createKey("Application", "Wahlzeit")).filter(Photo.ID, id).first().now();
        for (PhotoSize size : PhotoSize.values()) {
            GcsFilename gcsFilename = new GcsFilename("picturebucket", filename);

        }*/
        return null;
    }

    /**
     * @methodtype factory
     */
    public FoodPhoto createPhoto() {
        return new FoodPhoto();
    }

    /**
     * Creates a new photo with the specified id
     */
    public FoodPhoto createPhoto(PhotoId id) {
        return new FoodPhoto(id);
    }

    /**
     *
     */
    public PhotoFilter createPhotoFilter() {
        return super.createPhotoFilter();
    }

    /**
     *
     */
    public PhotoTagCollector createPhotoTagCollector() {
        return super.createPhotoTagCollector();
    }

}
