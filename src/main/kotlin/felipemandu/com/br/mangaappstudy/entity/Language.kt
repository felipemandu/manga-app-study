package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.*

@Entity
class Language (
        @Id @GeneratedValue @Column(name="language_id") var id :Long,
        @Enumerated(EnumType.STRING) var language: LanguageEnum
)
