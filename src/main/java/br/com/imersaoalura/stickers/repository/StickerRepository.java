package br.com.imersaoalura.stickers.repository;

import br.com.imersaoalura.stickers.model.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StickerRepository extends JpaRepository<Sticker, UUID> {
}
