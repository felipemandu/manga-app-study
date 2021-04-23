package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.*

@Entity
class Source (
        @Id @GeneratedValue
        @Column(name="source_id")
        var id:Long,

        var name:String,

        @OneToMany
        var mangas:Set<Manga>,

        @OneToMany
        var availableLanguageEnums: List<Language>
) {
    override fun toString(): String {
        return "Source(name='$name')"
    }
}