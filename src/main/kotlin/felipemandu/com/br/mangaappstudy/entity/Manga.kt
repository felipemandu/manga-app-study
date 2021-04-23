package felipemandu.com.br.mangaappstudy.entity

import java.util.*
import javax.persistence.*

@Entity
class Manga(
        @Id @GeneratedValue
        @Column(name = "manga_id") var id: Long,
        var title: String,

        var release: Date,

        var rating: Int?,

        var description: String?,

        @ManyToMany
        @JoinTable(name = "manga_author",
                joinColumns = [JoinColumn(name = "manga_id")],
                inverseJoinColumns = [JoinColumn(name = "author_id")])
        var authors: Set<Author>,

        @ManyToMany
        @JoinTable(name = "manga_genre",
                joinColumns = [JoinColumn(name = "manga_id")],
                inverseJoinColumns = [JoinColumn(name = "genre_id")])
        var genreEnums: Set<Genre>?,

        @ManyToOne
        @JoinColumn(name = "origin_language_id", nullable = false)
        var originLanguage: Language?,

        @ManyToOne
        @JoinColumn(name = "country_id", nullable = false)
        var originCountry: Country,

        @ManyToOne
        @JoinColumn(name = "translated_language_id", nullable = false)
        var translatedLanguage: Language?,

        @OneToMany
        var chapters: Set<Chapter>,

        var lastChapter: Date
) {
    override fun toString(): String {
        return "Manga(title='$title')"
    }
}