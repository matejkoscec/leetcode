package leet.code.util

fun Iterable<Int>.toLinkedList(): ListNode {
    val iterator = iterator()
    if (!iterator.hasNext()) return ListNode()

    val head = node(iterator.next())
    var current = head
    while (iterator.hasNext()) {
        current.next = node(iterator.next())
        current = current.next!!
    }

    return head
}

fun IntRange.toIntArray(): IntArray {
    if (last < first) {
        return IntArray(0)
    }

    val result = IntArray(last - first + 1)
    for ((i, element) in this.withIndex()) {
        result[i] = element
    }

    return result
}

fun <R> strArraysToList(arrays: String, transform: (List<Int>) -> R): List<R> {
    return arrays.removeSurrounding("[", "]")
        .split("],")
        .map {
            it.removePrefix("[").removeSuffix("]")
                .split(',')
                .filter(String::isNotBlank)
                .map(String::toInt)
        }
        .map(transform)
}