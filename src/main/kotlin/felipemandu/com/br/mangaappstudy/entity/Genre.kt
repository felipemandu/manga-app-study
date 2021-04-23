package felipemandu.com.br.mangaappstudy.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Genre (
        @Id @GeneratedValue @Column(name = "genre_id") var id :Long,
        var genre: GenreEnum
)