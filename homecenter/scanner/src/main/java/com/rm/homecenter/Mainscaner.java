package com.rm.homecenter;

import com.rm.homecenter.domain.FileAttribute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.UUID;

@SpringBootApplication
public class Mainscaner {
	
	public static String path = "F:/Movies";
	
	public static void main(String[] args) {
		SpringApplication.run(Mainscaner.class, args);
		File rootFile = new File(path);
		processFile(rootFile);

	}
	
	public static void processFile(File file){
		if(file.isDirectory()) {
			File[] fileList = file.listFiles();
			for(File fileTemp : fileList) {
				processFile(fileTemp);
			}			
		} else {
			FileAttribute fAttribute = new FileAttribute();
			fAttribute.setGuid(UUID.randomUUID().toString());
			fAttribute.setFileName(file.getName());
			fAttribute.setFilePath(file.getAbsolutePath().replaceAll("\\\\", "/"));
			fAttribute.setFileSize(file.length());
			int lastDot = file.getName().lastIndexOf(".");
			if(lastDot > 0) {
				fAttribute.setFileExtention(file.getName().substring(lastDot + 1, file.getName().length()));
			} else {
				file.delete();
			}
			fAttribute.setParentName(file.getParentFile().getName());

			System.out.println(fAttribute.getGuid());
			System.out.println(fAttribute.getFileName());
			System.out.println(fAttribute.getFilePath());
			System.out.println(fAttribute.getFileSize());
			System.out.println(fAttribute.getFileExtention());
			System.out.println(fAttribute.getParentName());
			System.out.println("\n");
			
		}
	}
}
