package felipemandu.com.br.mangaappstudy.entity

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
import javax.persistence.SequenceGenerator
import javax.persistence.Table


@Entity
@Table(name = "Language")
data class Language(
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="language_sequence")
    @SequenceGenerator(name="language_sequence", sequenceName="language_sequence", allocationSize = 1)
    @Column(name = "LANGUAGE_ID", nullable = false)
    val id: Long,

    @ManyToMany
    @JoinTable(
        name = "Language_Country",
        joinColumns = [JoinColumn(name = "LANGUAGE_ID")],
        inverseJoinColumns = [JoinColumn(name = "COUNTRY_ID")]
    )
    var countries: MutableSet<Country>? = mutableSetOf(),

    @ManyToMany
    @JoinTable(
        name = "Language_Hosting_Website",
        joinColumns = [JoinColumn(name = "LANGUAGE_ID")],
        inverseJoinColumns = [JoinColumn(name = "HOSTING_WEBSITE_ID")]
    )
    var hostingWebsites: MutableSet<HostingWebsite>? = mutableSetOf(),

    @Enumerated(EnumType.STRING)
    @Column(name = "LANGUAGE", unique = true, nullable = false)
    val language: LanguageEnum
) {
    override fun toString(): String {
        return "Language(id=$id, language=$language)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Language

        if (id != other.id) return false
        if (language != other.language) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + language.hashCode()
        return result
    }


}
