package org.challenge.kotlin_tutorial

// object로 클래스를 정의하면, Singleton 패턴이 적용되어 객체가 한 번만 생성되도록 한다.
// 즉 생성자의 호출이 반복적으로 이뤄져도 실제로 생성되는 객체는 최초 생성된 객체를 반환 해주는 것이다.
// 처음 compile될 때, 만들어지는 인스턴스는 딱 하나이다.
object CarFactory{
    val cars = mutableListOf<Car>()

    fun makeCar(power: Int) : Car{
        val car = Car(power)
        cars.add(car)
        return car
    }
}

data class  Car(val power : Int)

fun main(){
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(20)

    println(car)
    println(car2)
    print(CarFactory.cars.size.toString())
}