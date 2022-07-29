package br.com.imersaoalura.stickers.services;

import br.com.imersaoalura.stickers.model.Sticker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DownloadStickerServices {

	private final StickService stickService;

	public void createSticker(UUID id) throws Exception {
		Sticker sticker = stickService.findById(id);
		BufferedImage originalImage = getStreamByImage(sticker.getImage());

		BufferedImage newImage = createNewImageInMemory(originalImage);
		Graphics2D graphics = convertImageToGraphics(originalImage, newImage);

		applyConfigsInSticker(graphics);
		writeNewImage(id, sticker, originalImage, newImage, graphics);
	}

	private Graphics2D convertImageToGraphics(BufferedImage originalImage, BufferedImage newImage) {
		Graphics2D graphics = (Graphics2D) newImage.getGraphics();
		graphics.drawImage(originalImage, 0, 0, null);
		return graphics;
	}

	private void writeNewImage(UUID id, Sticker sticker, BufferedImage originalImage, BufferedImage newImage, Graphics2D graphics) throws IOException {
		graphics.drawString(sticker.getTitle(), Math.abs(originalImage.getWidth() / 2) - 25, newImage.getHeight() - 25);
		ImageIO.write(newImage, "png", new File(mountFileName(id, sticker)));
	}

	private String mountFileName(UUID id, Sticker sticker) {
		return "src/main/resources/static/" + id.toString() + "_" + sticker.getTitle() + "_.png";
	}

	private void applyConfigsInSticker(Graphics2D graphics) {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		graphics.setFont(font);
		graphics.setColor(Color.yellow);
	}

	private BufferedImage createNewImageInMemory(BufferedImage originalImage) {
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();
		int newHeight = height + 50;
		return new BufferedImage(width, newHeight, BufferedImage.TYPE_BYTE_GRAY);
	}

	private BufferedImage getStreamByImage(String urlImage) throws IOException {
		InputStream inputStream = new URL(urlImage).openStream();
		return ImageIO.read(inputStream);
	}





}
