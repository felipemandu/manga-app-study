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
@Table(name = "Hosting_Website")
data class HostingWebsite(
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hosting_website_sequence")
    @SequenceGenerator(name="hosting_website_sequence", sequenceName="hosting_website_sequence", allocationSize = 1)
    @Column(name = "HOSTING_WEBSITE_ID", nullable = false)
    val id: Long,

    @Column(name = "NAME", nullable = false)
    val name: String,

    @OneToMany(mappedBy = "hostingWebsite")
    var mangas: MutableSet<Manga>? = mutableSetOf(),

    @ManyToMany(mappedBy = "hostingWebsites")
    var availableLanguage: MutableSet<Language>? = mutableSetOf()
) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HostingWebsite

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
        return "HostingWebsite(id=$id, name='$name', availableLanguage=$availableLanguage)"
    }


}