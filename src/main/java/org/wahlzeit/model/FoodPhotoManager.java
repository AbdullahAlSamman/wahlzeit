package org.wahlzeit.model;

import com.google.appengine.api.images.Image;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FoodPhotoManager extends PhotoManager {

    /**
     *
     */
    protected static final FoodPhotoManager instance = new FoodPhotoManager();
    /**
     * In-memory cache for photos
     */
    protected Map<PhotoId, FoodPhoto> photoCache = new HashMap<PhotoId, FoodPhoto>();

    /**
     *
     */
    public FoodPhotoManager() {
        photoTagCollector = FoodPhotoFactory.getInstance().createPhotoTagCollector();
    }

    /**
     *
     */
    public FoodPhoto getPhoto(PhotoId id) {
        return instance.getPhotoFromId(id);
    }


    public void init() {
        super.init();
    }

    /**
     *
     */
    public static FoodPhotoManager getInstance() {
        return instance;
    }

    public void savePhoto(FoodPhoto photo) {
        updateObject(photo);
    }


    /**
     *
     */
    public FoodPhoto getVisiblePhoto(PhotoFilter filter) {
        filter.generateDisplayablePhotoIds();
        return getPhotoFromId(filter.getRandomDisplayablePhotoId());
    }

    /**
     *
     */
    public FoodPhoto createPhoto(String filename, Image uploadedImage) throws Exception {
        PhotoId id = PhotoId.getNextId();
        FoodPhoto result = FoodPhotoUtil.createPhoto(filename, id, uploadedImage);
        addPhoto(result);
        return result;
    }

    /**
     * @methodtype get
     * @methodproperties primitive
     */
    protected FoodPhoto doGetPhotoFromId(PhotoId id) {
        return photoCache.get(id);
    }

    /**
     *
     */
    public FoodPhoto getPhotoFromId(PhotoId id) {
        if (id == null) {
            return null;
        }

        FoodPhoto result = doGetPhotoFromId(id);

        if (result == null) {
            result = FoodPhotoFactory.getInstance().loadPhoto(id);
            if (result != null) {
                doAddPhoto(result);
            }
        }

        return result;

    }

    /**
     * @methodtype command
     */
    public void addPhoto(FoodPhoto photo) throws IOException {
        super.addPhoto(photo);
    }
}