package com.longnguyenquy.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MultiPartFilesUtilsService {

	@Autowired
	MultipartFile multipartFile;

	@Autowired
	ServletContext servletContext;


	public MultiPartFilesUtilsService(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public MultipartFile getMultipartFile() {
		return this.multipartFile;
	}

	public void setMultiPartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public void saveFileTo(String pathName,
			boolean enableReplaceFileIfExists) {

		File file = new File(pathName);
		if (enableReplaceFileIfExists) {

			deleteFileIfExist(file, true);
			try {
				multipartFile.transferTo(file);

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	
	public void deleteFileIfExist(File file, boolean enableReplaceFileIfExists) {
		if (file.exists()) {
			file.delete();
			if (enableReplaceFileIfExists) {
				try {
					file.createNewFile();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void deleteFileIfExist(String pathName, boolean replaceWithNewFile) {
		File file = new File(pathName);
		if (file.exists()) {
			file.delete();
			if (replaceWithNewFile) {
				try {
					file.createNewFile();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
