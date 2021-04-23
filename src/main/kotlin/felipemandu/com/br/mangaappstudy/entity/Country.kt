package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.*

@Entity
class Country (
        @Id @GeneratedValue
        @Column(name="country_id") var id:Long,
        var name:String,

        @OneToMany
        @JoinColumn(name = "spoken_language_id")
        var spokenLanguageEnum: Set<Language>,

        @OneToMany
        var mangas: Set<Manga>,

        @OneToMany
        var authors:Set<Author>

) {
    override fun toString(): String {
        return "Country(name='$name')"
    }
}