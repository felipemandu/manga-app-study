package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.*

@Entity
@Table(name = "Author")
data class Author(
    @Id @GeneratedValue
    @Column(name = "AUTHOR_ID", nullable = false)
    val id: Long,

    @Column(name = "NAME", nullable =  false)
    val name: String,

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    val countryOrigin: Country,

    @ManyToMany(mappedBy = "authors")
    val mangas: Set<Manga>
) {
    override fun toString(): String {
        return "Author(id=$id, name='$name', countryOrigin=$countryOrigin, mangas=$mangas)"
    }
}