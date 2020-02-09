package xyz.coincoin.project.sutom

import xyz.coincoin.project.sutom.LetterResult.GOOD_PLACE
import xyz.coincoin.project.sutom.LetterResult.NOT_FOUND

class WordSolverService {
    fun compareWords(wordToGuess: String, currentWord: String): Array<LetterResult> {
        if (wordToGuess.length != currentWord.length) {
            throw WordSolverServiceException("The current word does not have the same length that the word to guess")
        }

        return if (wordToGuess == currentWord) {
            wordToGuess
                    .map { GOOD_PLACE }
                    .toTypedArray()
        } else {
            wordToGuess
                    .map { NOT_FOUND }
                    .toTypedArray()
        }
    }
}
