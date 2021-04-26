package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.*

@Entity
@Table(name = "Hosting_Website")
data class HostingWebsite(
    @Id @GeneratedValue
    @Column(name = "HOSTING_WEBSITE_ID", nullable = false)
    val id: Long,

    @Column(name = "NAME", nullable = false)
    val name: String,

    @OneToMany(mappedBy = "hostingWebsite")
    val mangas: Set<Manga>,

    @ManyToMany(mappedBy = "hostingWebsites")
    val availableLanguage: Set<Language>
) {
    override fun toString(): String {
        return "HostingWebsite(id=$id, name='$name', mangas=$mangas, availableLanguage=$availableLanguage)"
    }
}