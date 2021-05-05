package felipemandu.com.br.mangaappstudy.entity

import java.time.LocalDate
import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table


@Entity
@Table(name = "Chapter")
data class Chapter(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAPTER_ID", nullable = false)
    val id: Long,

    @Column(name = "TITLE")
    val title: String? = null,

    @Column(name = "CHAPTER_NUMBER")
    val number: Int,

    @Column(name = "NUMBER_PAGES")
    val numberPages: Int? = null,

    @Column(name = "ISBN")
    val ISBN: String? = null,

    @Column(name = "RELEASE")
    val release: LocalDate? = null,

    @Column(name = "NUMBER_VISUALIZATION")
    val numberVisualization: Int? = null,

    @ElementCollection
    @CollectionTable(
        name = "Pages",
        joinColumns = [JoinColumn(name = "CHAPTER_ID")]
    )
    @Column(name = "PAGES")
    val pages: Set<String>,

    @ManyToOne
    @JoinColumn(name = "MANGA_ID")
    var manga: Manga? = null
) {
    override fun toString(): String {
        return "Chapter(id=$id, title=$title, number=$number, numberPages=$numberPages, ISBN=$ISBN, release=$release, numberVisualization=$numberVisualization)"
    }
}

