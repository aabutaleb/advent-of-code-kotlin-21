import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInputString(name: String) = File("resources", "$name.txt").readLines()

fun readInputInt(name: String) = File("resources", "$name.txt").readLines().map { it.toInt() }

fun readCslInt(name: String): List<Int> = File("resources", "$name.txt").readLines().get(0).split(",").map { it.toInt() }.toList()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
