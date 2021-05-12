package felipemandu.com.br.mangaappstudy.controller

import java.time.LocalDateTime

class Error(
    val error: String,
    val message: String,
    val timestamp: LocalDateTime
)