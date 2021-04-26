package felipemandu.com.br.mangaappstudy.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Manga")
data class Manga(
    @Id @GeneratedValue
    @Column(name = "MANGA_ID", nullable = false)
    val id: Long,

    @Column(name = "TITLE", nullable = false)
    val title: String,

    @Column(name = "RELEASE")
    val release: Date? = null,

    @Column(name = "RATING")
    val rating: Int? = null,

    @Column(name = "DESCRIPTION")
    val description: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    val status: Status,

    @ManyToMany
    @JoinTable(
        name = "Manga_Author",
        joinColumns = [JoinColumn(name = "MANGA_ID")],
        inverseJoinColumns = [JoinColumn(name = "AUTHOR_ID")]
    )
    val authors: Set<Author>,

    @ManyToMany
    @JoinTable(
        name = "Manga_Genre",
        joinColumns = [JoinColumn(name = "MANGA_ID")],
        inverseJoinColumns = [JoinColumn(name = "GENRE_ID")]
    )
    val genres: Set<Genre>? = null,

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    val originCountry: Country? = null,

    @ManyToOne
    @JoinColumn(name = "ORIGIN_LANGUAGE_ID")
    val originLanguage: Language? = null,

    @ManyToOne
    @JoinColumn(name = "TRANSLATED_LANGUAGE_ID")
    val translatedLanguage: Language? = null,

    @ManyToOne
    @JoinColumn(name = "HOSTING_WEBSITE_ID")
    val hostingWebsite: HostingWebsite,

    @OneToMany(mappedBy = "manga")
    @Column(name = "CHAPTERS")
    val chapters: Set<Chapter>,

    @Column(name = "LAST_CHAPTER")
    val lastChapter: Date
) {
    override fun toString(): String {
        return "Manga(id=$id, title='$title', release=$release, rating=$rating, description=$description, authors=$authors, genres=$genres, originCountry=$originCountry, originLanguage=$originLanguage, translatedLanguage=$translatedLanguage, chapters=$chapters, lastChapter=$lastChapter)"
    }
}