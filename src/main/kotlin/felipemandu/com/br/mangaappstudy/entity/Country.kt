package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "Country")
data class Country(
    @Id @GeneratedValue
    @Column(name = "COUNTRY_ID", nullable = false)
    val id: Long,

    @Column(name = "NAME", nullable = false)
    val name: String,

    @ManyToMany(mappedBy = "countries")
    val spokenLanguage: Set<Language>? = null,

    @OneToMany(mappedBy = "originCountry")
    @Column(name = "MANGAS")
    val mangas: Set<Manga>,

    @OneToMany(mappedBy = "countryOrigin")
    @Column(name = "AUTHORS")
    val authors: Set<Author>

) {
    override fun toString(): String {
        return "Country(id=$id, name='$name', spokenLanguageEnum=$spokenLanguage, mangas=$mangas, authors=$authors)"
    }
}