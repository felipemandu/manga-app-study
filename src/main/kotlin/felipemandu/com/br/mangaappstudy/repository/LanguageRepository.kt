package felipemandu.com.br.mangaappstudy.repository

import felipemandu.com.br.mangaappstudy.entity.Language
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LanguageRepository : JpaRepository<Language, Long> {
}