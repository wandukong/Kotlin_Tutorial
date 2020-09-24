package org.challenge.kotlin_tutorial

import org.challenge.kotlin_tutorial.Book.BookFactory.getId

// companion object 키워드를 선언하면 단순히 클래스 이름을 식별자로 사용할 수 있다.
// 정적 메소드와 정적 변수를 선언하기 위해 사용한다.

class Book private constructor(val id: Int, val name : String){ // 다른 곳에서는 생성하지 못하게끔 private 키워드를 사용한다.

    companion object BookFactory : IdProvider{ // interface implements
        override fun getId(): Int {
            return 444
        }

        val myBook = "new book"
        fun create() = Book(getId(), myBook)
    }
}

interface IdProvider{
    fun getId() : Int
}

fun main(){
    val book = Book.create()
    println("${book.id} ${book.name}")

    val bookId = Book.BookFactory.getId()
    println(bookId)
}