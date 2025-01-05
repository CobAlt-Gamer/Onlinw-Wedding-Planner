package com.wedding.planner.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.config.general.ImageKitConf;
import com.wedding.planner.entity.Images;
import com.wedding.planner.service.ImageService;
import com.wedding.planner.service.StorageService;

import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.results.Result;

@Service
public class StorageServiceImpl implements StorageService {

	private ImageKit imageKit = ImageKitConf.getImageKitConf();

	@Autowired
	private ImageService imageService;

	@Override
	public Images upload(MultipartFile file, String name, String FOLDER_NAME) throws IOException {

		try {
			FileCreateRequest request = new FileCreateRequest(file.getBytes(), name);
			request.folder = FOLDER_NAME;
			Result response = imageKit.upload(request);
			return imageService.addImage(Images.builder().fileId(response.getFileId()).url(response.getUrl()).build())
					.getBody();
		} catch (InternalServerException | BadRequestException | UnknownException | ForbiddenException
				| TooManyRequestsException | UnauthorizedException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Images upload(MultipartFile file, String name, String FOLDER_NAME, Long ImageId) throws IOException {
		try {
			FileCreateRequest request = new FileCreateRequest(file.getBytes(), name);
			request.folder = FOLDER_NAME;
			Result response = imageKit.upload(request);
			Images image = imageService.getImage(ImageId).getBody();
			image.setFileId(response.getFileId());
			image.setUrl(response.getUrl());
			return imageService.update(image).getBody();
		} catch (InternalServerException | BadRequestException | UnknownException | ForbiddenException
				| TooManyRequestsException | UnauthorizedException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Images> upload(MultipartFile[] images, String name, String FOLDER_NAME) throws IOException {
		try {
			List<Images> imagesList = new ArrayList<>();
			for (MultipartFile file : images) {
				FileCreateRequest request = new FileCreateRequest(file.getBytes(), name);
				request.folder = FOLDER_NAME;
				Result response = imageKit.upload(request);
				imagesList.add(imageService
						.addImage(Images.builder().fileId(response.getFileId()).url(response.getUrl()).build())
						.getBody());
			}
			return imagesList;
		} catch (InternalServerException | BadRequestException | UnknownException | ForbiddenException
				| TooManyRequestsException | UnauthorizedException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getImageUrl(String fileId) {
		try {
			return imageKit.getFileDetail(fileId).getUrl();
		} catch (ForbiddenException | TooManyRequestsException | InternalServerException | UnauthorizedException
				| BadRequestException | UnknownException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Boolean delete(Images image) {
		try {
			imageKit.deleteFile(image.getFileId());
			return true;
		} catch (ForbiddenException | TooManyRequestsException | InternalServerException | UnauthorizedException
				| BadRequestException | UnknownException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Boolean delete(List<Images> images) {
		images.forEach(image -> {
			try {
				imageKit.deleteFile(image.getFileId());
			} catch (ForbiddenException | TooManyRequestsException | InternalServerException | UnauthorizedException
					| BadRequestException | UnknownException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
		return imageService.delete(images).getBody();
	}
}
