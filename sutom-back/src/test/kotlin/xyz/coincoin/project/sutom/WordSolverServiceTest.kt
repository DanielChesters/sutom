package xyz.coincoin.project.sutom

import assertk.assertThat
import assertk.assertions.hasMessage
import assertk.assertions.isEqualTo
import assertk.assertions.isFailure
import org.junit.jupiter.api.Test

class WordSolverServiceTest {

    private val service = WordSolverService()

    @Test
    fun `same letter should return a result array with one good place result`() {
        assertThat(service.compareWords("a", "a"))
                .isEqualTo(arrayOf(LetterResult.GOOD_PLACE))
    }

    @Test
    fun `different letters should return a array with one not found result`() {
        assertThat(service.compareWords("a", "b"))
                .isEqualTo(arrayOf(LetterResult.NOT_FOUND))
    }

    @Test
    fun `input string with different length should raise exception`() {
        assertThat { service.compareWords("ab", "a") }
                .isFailure()
                .hasMessage("The current word does not have the same length that the word to guess")
    }
}