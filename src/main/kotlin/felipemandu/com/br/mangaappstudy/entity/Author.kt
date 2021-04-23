package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.*

@Entity
class Author(
        @Id @GeneratedValue
        @Column(name = "author_id")
        var id: Long,

        var name: String,

        @OneToOne
        var countryOrigin: Country,

        @ManyToMany(mappedBy = "authors")
        var mangas: Set<Manga>

)