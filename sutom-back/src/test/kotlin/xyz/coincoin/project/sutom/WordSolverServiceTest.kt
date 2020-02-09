package xyz.coincoin.project.sutom

import assertk.assertThat
import assertk.assertions.hasMessage
import assertk.assertions.isEqualTo
import assertk.assertions.isFailure
import org.junit.jupiter.api.Test
import xyz.coincoin.project.sutom.LetterResult.*

class WordSolverServiceTest {

    private val service = WordSolverService()

    @Test
    fun `same letter should return an array with one good place result`() =
            assertThat(service.compareWords("a", "a"))
                    .isEqualTo(arrayOf(GOOD_PLACE))

    @Test
    fun `different letters should return an array with one not found result`() =
            assertThat(service.compareWords("a", "b"))
                    .isEqualTo(arrayOf(NOT_FOUND))

    @Test
    fun `input string with different length should raise exception`() =
            assertThat { service.compareWords("ab", "a") }
                    .isFailure()
                    .hasMessage("The current word does not have the same length that the word to guess")

    @Test
    fun `two same letters should return an array with two good place results`() =
            assertThat(service.compareWords("aa", "aa"))
                    .isEqualTo(arrayOf(GOOD_PLACE, GOOD_PLACE))

    @Test
    fun `different words with two completely different letters should return an array with two not found`() =
            assertThat(service.compareWords("aa", "bb"))
                    .isEqualTo(arrayOf(NOT_FOUND, NOT_FOUND))

    @Test
    fun `one difference in two letters word should return an array with one good place and one not found`() =
            assertThat(service.compareWords("aa", "ab"))
                    .isEqualTo(arrayOf(GOOD_PLACE, NOT_FOUND))

    @Test
    fun `inverse letters in a 2 letters word should return an array of two wrong place`() =
            assertThat(service.compareWords("ab", "ba"))
                    .isEqualTo(arrayOf(WRONG_PLACE, WRONG_PLACE))

    @Test
    fun `Ignore case in service call`() =
            assertThat(service.compareWords("ab", "AB"))
                    .isEqualTo(arrayOf(GOOD_PLACE, GOOD_PLACE))

    @Test
    fun `Ignore special characters in service call`() =
            assertThat(service.compareWords("éç", "ec"))
                    .isEqualTo(arrayOf(GOOD_PLACE, GOOD_PLACE))
}