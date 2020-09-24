package org.challenge.kotlin_tutorial

data class Ticket(val companyName : String, val name : String, var data : String, var seatNumber : Int)
// 데이터 클래스란 클래스가 data를 보유하면서 아무것도 하지 않는 클래스이다.
// toString(), hashCode(), equals(), copy() 메소드들이 자동으로 만들어진다.

class TicketNormal(val companyName : String, val name : String, var data : String, var seatNumber : Int)

fun main(){
    val ticketA = Ticket("koreanAir", "wandukong", "2020-11-07", 14)
    val ticketB = TicketNormal("koreanAir", "wandukong", "2020-11-07", 14)

    println(ticketA)
    println(ticketB)
}