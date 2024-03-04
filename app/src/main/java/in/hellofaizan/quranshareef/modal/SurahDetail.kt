package `in`.hellofaizan.quranshareef.modal

data class SurahDetail(
    val code: Int,
    val `data`: Data,
    val status: String
) {
    data class Data(
        val ayahs: List<Ayah>,
        val edition: Edition,
        val englishName: String,
        val englishNameTranslation: String,
        val name: String,
        val number: Int,
        val numberOfAyahs: Int,
        val revelationType: String
    ) {
        data class Ayah(
            val hizbQuarter: Int,
            val juz: Int,
            val manzil: Int,
            val number: Int,
            val numberInSurah: Int,
            val page: Int,
            val ruku: Int,
            val sajda: Boolean,
            val text: String
        )

        data class Edition(
            val direction: String,
            val englishName: String,
            val format: String,
            val identifier: String,
            val language: String,
            val name: String,
            val type: String
        )
    }
}