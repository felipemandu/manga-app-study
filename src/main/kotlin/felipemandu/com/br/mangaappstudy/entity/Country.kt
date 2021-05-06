package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "Country")
data class Country(
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="country_sequence")
    @SequenceGenerator(name="country_sequence", sequenceName="country_sequence", allocationSize = 1)
    @Column(name = "COUNTRY_ID", nullable = false)
    val id: Long,

    @Column(name = "NAME", nullable = false)
    val name: String,

    @ManyToMany(mappedBy = "countries")
    var spokenLanguage: MutableSet<Language>? = mutableSetOf(),

    @OneToMany(mappedBy = "originCountry")
    @Column(name = "MANGAS")
    var mangas: MutableSet<Manga>? = mutableSetOf(),

    @OneToMany(mappedBy = "countryOrigin")
    @Column(name = "AUTHORS")
    var authors: MutableSet<Author>? = mutableSetOf()

) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Country

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "Country(id=$id, name='$name')"
    }


}