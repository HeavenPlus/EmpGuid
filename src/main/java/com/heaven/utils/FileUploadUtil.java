package com.heaven.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;

public class FileUploadUtil {
	public static String upload(String oldPath, MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String suffix = fileSuffix.toUpperCase();
		String dir = null;
		if (".PNG".equals(suffix) || ".JPG".equals(suffix) || ".JPEG".equals(suffix)) {
			dir = request.getServletContext().getRealPath("/upload");
		} else {
			dir = request.getServletContext().getRealPath("/videos");
		}
		File fileDir = new File(dir);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		String fileName = UUID.randomUUID().toString() + fileSuffix;
		File files = new File(fileDir + "/" + fileName);
		File old = new File(fileDir + "/" + oldPath);
		if(old.exists()){
			old.delete();
		}
		file.transferTo(files);
		return fileName;
	}

	public static String ReadVideoTime(File file) throws InputFormatException, EncoderException {
		Encoder encoder = new Encoder();
		String length = "";
		MultimediaInfo m = encoder.getInfo(file);
		long ls = m.getDuration() / 1000;
		int hour = (int) (ls / 3600);
		int minute = (int) (ls % 3600) / 60;
		int second = (int) (ls - hour * 3600 - minute * 60);
		length = hour + "小时" + minute + "分" + second + "秒";
		return length;
	}
}
