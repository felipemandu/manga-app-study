package felipemandu.com.br.mangaappstudy.entity


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "Genre")
data class Genre(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GENRE_ID")
    val id: Long,

    @ManyToMany(mappedBy = "genres")
    val mangas: MutableSet<Manga>? = mutableSetOf(),

    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE", unique = true)
    val genre: GenreEnum
) {
    override fun toString(): String {
        return "Genre(id=$id, genre=$genre)"
    }
}