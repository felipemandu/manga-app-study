package felipemandu.com.br.mangaappstudy.entity

import java.util.*
import javax.persistence.*

@Entity
class Chapter (
        @Id @GeneratedValue
        @Column(name="chapter_id")var id:Long,
        var title:String,

        var chapterNumber:Int,

        var numberOfPages:Int,

        var ISBN:String,

        var release:Date,

        var numberOfVisualization:Int,

        @ElementCollection
        var pages:Set<String>
) {
    override fun toString(): String {
        return "Chapter(title='$title', chapterNumber=$chapterNumber, numberOfPages=$numberOfPages)"
    }
}

