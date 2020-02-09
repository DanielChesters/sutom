package xyz.coincoin.project.sutom

import xyz.coincoin.project.sutom.LetterResult.*

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
            wordToGuess.indices
                    .map { i ->
                        val currentLetter = currentWord[i]
                        val letterToGuess = wordToGuess[i]
                        if (letterToGuess == currentLetter) {
                            GOOD_PLACE
                        } else {
                            if (wordToGuess.contains(currentLetter)) {
                                WRONG_PLACE
                            } else {
                                NOT_FOUND
                            }
                        }
                    }
                    .toTypedArray()
        }
    }
}
