package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.Table


@Entity
@Table(name = "Author")
data class Author(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID", nullable = false)
    val id: Long,

    @Column(name = "NAME", nullable =  false)
    val name: String,

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    val countryOrigin: Country? = null,

    @ManyToMany(mappedBy = "authors")
    val mangas: MutableSet<Manga>? = mutableSetOf()
) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Author

        if (id != other.id) return false
        if (name != other.name) return false
        if (countryOrigin != other.countryOrigin) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (countryOrigin?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Author(id=$id, name='$name')"
    }


}