package xyz.coincoin.project.sutom

class WordSolverService {
    fun compareWords(wordToGuess: String, currentWord: String): Array<LetterResult> {
        if (wordToGuess.length != currentWord.length) {
            throw WordSolverServiceException("The current word does not have the same length that the word to guess")
        }

        return if (wordToGuess == currentWord) {
            arrayOf(LetterResult.GOOD_PLACE)
        } else {
            arrayOf(LetterResult.NOT_FOUND)
        }
    }
}
