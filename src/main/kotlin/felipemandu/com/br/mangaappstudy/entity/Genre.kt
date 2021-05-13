package felipemandu.com.br.mangaappstudy.entity


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "Genre")
data class Genre(
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="genre_sequence")
    @SequenceGenerator(name="genre_sequence", sequenceName="genre_sequence", allocationSize = 1)
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