package com.sk.hibernate.lob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.sk.hibernate.annotation.SpringBootTestByProfile;

@SpringBootTestByProfile
public class ImageApplicationTest {

	@Value("${file.readPath}")
	private String readPath;

	@Value("${file.writePath}")
	private String writePath;

	@Autowired
	private ImageRepository imageRepository;

	@Test
	public void testSaveImage() {
		Image img = new Image();
		img.setId(1l);
		img.setName("Batman.jpg");

		try {
			File file = new File(readPath);
			byte[] imageContent = new byte[(int) file.length()];
			FileInputStream fis = new FileInputStream(file);
			fis.read(imageContent);
			img.setData(imageContent);
			imageRepository.save(img);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadImage() {
		testSaveImage();
		Image img = imageRepository.findById(1l).get();
		try {
			File file = new File(writePath);
			file.createNewFile();
			FileOutputStream fis = new FileOutputStream(file);
			fis.write(img.getData());
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
