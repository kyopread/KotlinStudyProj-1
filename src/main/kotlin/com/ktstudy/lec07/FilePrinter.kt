package com.ktstudy.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FilePrinter {
    fun readFile() { // throws 구문이 없다.
        // java 와는 다르게 모두 Unchecked Exception이다.
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    fun readFile2(path: String) {
        BufferedReader(FileReader(path)).use {
            reader -> println(reader.readLine())
        }
    }
}