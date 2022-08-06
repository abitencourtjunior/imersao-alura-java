package br.com.imersaoalura.stickers.controller;

import br.com.imersaoalura.stickers.model.Sticker;
import br.com.imersaoalura.stickers.services.DownloadStickerServices;
import br.com.imersaoalura.stickers.services.StickService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StickerController extends BaseController {

	private final StickService stickService;
	private final DownloadStickerServices downloadStickerServices;


	@PostMapping
	@PreAuthorize("hasAnyAuthority('ROLE_APP_ADMIN')")
	public Sticker createSticker(@RequestBody Sticker sticker){
		return stickService.create(sticker);
	}

	@GetMapping
	public List<Sticker> findAllSticker(){
		return stickService.findAll();
	}

	@PostMapping(path = "/{id}/download")
	public void downloadSticker(@RequestParam("id") UUID id) throws Exception {
		downloadStickerServices.createSticker(id);
		System.out.println("Download executado com sucesso!" + id);
	}

}
