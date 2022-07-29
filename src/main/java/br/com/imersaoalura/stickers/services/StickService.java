package br.com.imersaoalura.stickers.services;

import br.com.imersaoalura.stickers.model.Sticker;
import br.com.imersaoalura.stickers.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StickService {
	
	private final StickerRepository stickerRepository;

	public Sticker create(Sticker sticker) {
		return stickerRepository.save(sticker);
	}

	public List<Sticker> findAll() {
		return stickerRepository.findAll();
	}

	public Sticker findById(UUID id) {
		return stickerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Registro não encontrado"));
	}
}
