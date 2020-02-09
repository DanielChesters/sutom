package xyz.coincoin.project.sutom

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class WordSolverServiceTest {

    @Test
    fun `same letter should return a result array with one good place result`() {
        val service = WordSolverService()
        assertThat(service.compareWords("a", "a"))
                .isEqualTo(arrayOf(LetterResult.GOOD_PLACE))
    }
}