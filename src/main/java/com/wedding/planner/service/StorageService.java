package com.wedding.planner.service;

//import com.wedding.planner.config.ImageKitConf;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.entity.Images;

import io.imagekit.sdk.ImageKit;

public interface StorageService {

	/**
	 * uploads the Images to the {@link ImageKit}
	 *
	 * @param image
	 * @param NAME
	 * @param FOLDER_NAME
	 * @return {@link Images} uploaded image Entity
	 * @throws IOException
	 */
	Images upload(MultipartFile image, String name, String FOLDER_NAME) throws IOException;

	/**
	 * uploads the Images to the {@link ImageKit}
	 *
	 * @param image
	 * @param NAME
	 * @param FOLDER_NAME
	 * @return {@link Images} uploaded image Entity
	 * @throws IOException
	 */
	Images upload(MultipartFile image, String name, String FOLDER_NAME, Long ImageId) throws IOException;

	/**
	 * uploads the Images to the {@link ImageKit}
	 *
	 * @param file
	 * @param NAME
	 * @param FOLDER_NAME
	 * @return {@link List<Images>} uploaded list images
	 * @throws IOException
	 */
	List<Images> upload(MultipartFile[] images, String name, String FOLDER_NAME) throws IOException;

	/**
	 * Gets the URL of the image with fileId
	 *
	 * @param fileId
	 * @return {@link String} public link of the file referencing the @param fileId
	 */
	String getImageUrl(String fileId);

	/**
	 * Deletes the file referencing the @param fileId
	 *
	 * @param fileId
	 * @return {@link Boolean} whether image is deleted or not
	 */
	Boolean delete(Images image);

	/**
	 * deletes the {@link List<Images>} from database & {@link ImageKit} CDN
	 *
	 * @param images
	 * @return {@link Boolean} whether images are deleted or not
	 */
	Boolean delete(List<Images> images);
}
