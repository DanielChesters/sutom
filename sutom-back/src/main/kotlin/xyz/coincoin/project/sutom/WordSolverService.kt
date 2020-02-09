package xyz.coincoin.project.sutom

import xyz.coincoin.project.sutom.LetterResult.*
import java.text.Normalizer
import java.text.Normalizer.Form.NFD

class WordSolverService {
    fun compareWords(wordToGuess: String, currentWord: String): Array<LetterResult> {
        val wordToGuessWithoutAccentLowerCase = removeAccentAndLowerCase(wordToGuess)
        val currentWordWithoutAccentLowerCase = removeAccentAndLowerCase(currentWord)
        if (wordToGuessWithoutAccentLowerCase.length != currentWordWithoutAccentLowerCase.length) {
            throw WordSolverServiceException("The current word does not have the same length that the word to guess")
        }

        return if (wordToGuessWithoutAccentLowerCase == currentWordWithoutAccentLowerCase) {
            wordToGuessWithoutAccentLowerCase
                    .map { GOOD_PLACE }
                    .toTypedArray()
        } else {
            wordToGuessWithoutAccentLowerCase.indices
                    .map { i ->
                        val currentLetter = currentWordWithoutAccentLowerCase[i]
                        when {
                            wordToGuessWithoutAccentLowerCase[i] == currentLetter -> {
                                GOOD_PLACE
                            }
                            wordToGuessWithoutAccentLowerCase.contains(currentLetter) -> {
                                WRONG_PLACE
                            }
                            else -> {
                                NOT_FOUND
                            }
                        }
                    }
                    .toTypedArray()
        }
    }

    private fun removeAccentAndLowerCase(wordToGuess: String) = Normalizer.normalize(wordToGuess.toLowerCase(), NFD)
            .replace("\\p{M}".toRegex(), "")
}
