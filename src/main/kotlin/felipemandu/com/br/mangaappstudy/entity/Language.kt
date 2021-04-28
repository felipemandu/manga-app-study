package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table


@Entity
@Table(name = "Language")
data class Language(
    @Id @GeneratedValue
    @Column(name = "LANGUAGE_ID", nullable = false)
    val id: Long,

    @ManyToMany
    @JoinTable(
        name = "Language_Country",
        joinColumns = [JoinColumn(name = "LANGUAGE_ID")],
        inverseJoinColumns = [JoinColumn(name = "COUNTRY_ID")]
    )
    val countries: Set<Country>,

    @ManyToMany
    @JoinTable(
        name = "Language_Hosting_Website",
        joinColumns = [JoinColumn(name = "LANGUAGE_ID")],
        inverseJoinColumns = [JoinColumn(name = "HOSTING_WEBSITE_ID")]
    )
    val hostingWebsites: Set<HostingWebsite>,

    @Enumerated(EnumType.STRING)
    @Column(name = "LANGUAGE", unique = true, nullable = false)
    val language: LanguageEnum
) {
    override fun toString(): String {
        return "Language(id=$id, language=$language)"
    }
}
