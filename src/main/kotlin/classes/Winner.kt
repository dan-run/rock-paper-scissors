package classes

interface Winner<T> {
    fun winsAgainst(other: T): Boolean
}