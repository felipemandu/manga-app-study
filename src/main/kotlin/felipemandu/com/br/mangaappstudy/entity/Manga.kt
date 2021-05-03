package felipemandu.com.br.mangaappstudy.entity

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity
@Table(name = "Manga")
data class Manga(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANGA_ID", nullable = false)
    val id: Long,

    @Column(name = "TITLE", nullable = false)
    val title: String,

    @Column(name = "RELEASE")
    var release: LocalDate? = null,

    @Column(name = "RATING")
    var rating: Int? = null,

    @Column(name = "DESCRIPTION")
    var description: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    val status: Status? = Status.ONGOING,

    @ManyToMany
    @JoinTable(
        name = "Manga_Author",
        joinColumns = [JoinColumn(name = "MANGA_ID")],
        inverseJoinColumns = [JoinColumn(name = "AUTHOR_ID")]
    )
    var authors: MutableSet<Author>? = mutableSetOf(),

    @ManyToMany
    @JoinTable(
        name = "Manga_Genre",
        joinColumns = [JoinColumn(name = "MANGA_ID")],
        inverseJoinColumns = [JoinColumn(name = "GENRE_ID")]
    )
    var genres: MutableSet<Genre>? = mutableSetOf(),

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    var originCountry: Country? = null,

    @ManyToOne
    @JoinColumn(name = "ORIGIN_LANGUAGE_ID")
    var originLanguage: Language? = null,

    @ManyToOne
    @JoinColumn(name = "TRANSLATED_LANGUAGE_ID")
    var translatedLanguage: Language? = null,

    @ManyToOne
    @JoinColumn(name = "HOSTING_WEBSITE_ID")
    val hostingWebsite: HostingWebsite,

    @OneToMany(mappedBy = "manga")
    @Column(name = "CHAPTERS")
    var chapters: MutableSet<Chapter>? = mutableSetOf(),

    @Column(name = "LAST_CHAPTER")
    val lastChapter: LocalDate? = null
) {
    override fun toString(): String {
        return "Manga(id=$id, title='$title', release=$release, rating=$rating, description=$description, authors=$authors, genres=$genres, originCountry=$originCountry, originLanguage=$originLanguage, translatedLanguage=$translatedLanguage, chapters=$chapters, lastChapter=$lastChapter)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Manga

        if (id != other.id) return false
        if (title != other.title) return false
        if (release != other.release) return false
        if (rating != other.rating) return false
        if (description != other.description) return false
        if (status != other.status) return false
        if (originCountry != other.originCountry) return false
        if (originLanguage != other.originLanguage) return false
        if (translatedLanguage != other.translatedLanguage) return false
        if (hostingWebsite != other.hostingWebsite) return false
        if (lastChapter != other.lastChapter) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + (release?.hashCode() ?: 0)
        result = 31 * result + (rating ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        result = 31 * result + (originCountry?.hashCode() ?: 0)
        result = 31 * result + (originLanguage?.hashCode() ?: 0)
        result = 31 * result + (translatedLanguage?.hashCode() ?: 0)
        result = 31 * result + hostingWebsite.hashCode()
        result = 31 * result + (lastChapter?.hashCode() ?: 0)
        return result
    }

}