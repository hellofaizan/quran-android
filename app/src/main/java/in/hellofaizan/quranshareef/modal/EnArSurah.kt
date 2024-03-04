package `in`.hellofaizan.quranshareef.modal

data class EnArSurah(
    val result: List<Result>
) {
    data class Result(
        val arabic_text: String,
        val aya: String,
        val footnotes: String,
        val id: String,
        val sura: String,
        val translation: String
    )
}