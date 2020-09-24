package org.challenge.kotlin_tutorial

import android.view.View

// 1. Lamda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
// 변수 안에 함수를 넣을 수 있다.
// 1) 메소드의 파라미터로 넘겨 줄 수가 있다.
// 2) return 값으로 사용할 수 가 있다.


//람다의 기본정의
// val 람다이름 : (argument type) -> (return type)= {argument -> code body}
// val 람다이름 = {arguments : arguement type  -> code body}

// 항상 끝이 return 값이다.

var square : (Int) -> Int = {number -> number*number}  // argument 들이 여러개일 수도 있으니, ()로 감싼다.
var square2  = {number : Int -> number*number}

var nameAge =  {name : String, age : Int ->
    "my name is ${name}, I'm ${age}"
}

//확장 함수

// val 변수이름 : 확장하려는 type.(argument type) : return type { value }
// fun 확장하려는 type.(argument type) : return type { return value }

val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!" // this는 확장함수를 호출하는 객체
}
fun String.pizzaIsGreat2() :String  {
    return this + "Pizza is the best!"
}



fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = {
        "I am ${this} and ${it} years old" // it 지시어는 argument가 한 개면, 대신 쓸 수 있다. age를 뜻한다.
    }
    return name.introduceMyself(age)
}



// 람다의 return

val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "failure"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "error" // return 해조야하는 expression 이기 때문에 else 문이 있어야한다.
    }
}



// 람다를 표현하는 방법

fun invokeLamda(lamda : (Double) -> Boolean) : Boolean { // 람다를 argument로 받고, Boolean 값을 반환하는 함수
    return lamda(5.234)
}


//button.setOnClickListener(object : View.OnClickListener{
//    override fun onClick(v: View?) {
//
//    }
//})

// 1. Kotlin interface가 아닌 Java interface이어야 한다.
// 2. 그 interface는 딱 하나의 메소드만 가져야 한다.

//button.setOnClickListener({
//
//})


fun main(){
    println(square(12))
    println(square2(12))
    println(nameAge("wandukong",27))

    println("wow, ".pizzaIsGreat2())

    println(extendString("wandukong", 27))
    println(calculateGrade(97))

    val lanmda = {number : Double ->
        number == 4.234
    }

    println(invokeLamda(lanmda))
    println(invokeLamda({it > 3.2}))

    invokeLamda { it > 3.2 }  // function의 parameter가 lamda식이면 이런식으로 () 생략이 가능하다.  invokeLamda({it > 3.2})와 같다.

}