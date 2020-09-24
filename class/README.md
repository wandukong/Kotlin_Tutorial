# Class


```kotlin
class Human (var name : String = "Anonymous"){
    init {
        println("new human has been born!!")
    }
	
    fun eatingCake(){
        println("this is yummy~")
    }
}
```
기본 생성자를 위와 같이 생성할 수 있다.   
**init**을 이용하여 처음 실행하려고 하는 코드를 작성한다.   

```kotlin
val human = Human("seungwan")
```
위와 같이 인스턴스를 만든다.  

<hr />

### 생성자를 추가하는 방법.

```kotlin
class Human (var name : String = "Anonymous"){
	var age = -1;
	
	constructor(name : String,  age : Int) : this(name){
        this.age = age;
    }
}
```

<hr />

### 상속

```kotlin
open class Human (var name : String = "Anonymous"){
	var age = -1;
	
	constructor(name : String,  age : Int) : this(name){
        this.age = age;
    }
	
	fun eatingCake(){
        println("this is yummy~")
    }

	open fun singASong(){
        println("lalala")
    }
}
```
상속을 하려는 부모 클래스에 **open** 키워드를 명시해야 한다.  

```kotlin
open class Human (var name : String = "Anonymous"){
    open fun singASong(){
        println("lalala")
    }
}

class Korean : Human(){ 
    override fun singASong(){ 
        super.singASong()
        println("라라라")
        println("my name is ${super.name}")
    }
}
```
**override** 키워드를 사용하여 오버라이딩을 한다. 또한, 오버라이딩 하려는 메소드에 **open** 키워드를 명시해야 한다.    

<hr />

### data class

데이터 클래스란 클래스가 data를 보유하면서 아무것도 하지 않는 클래스이다.   
toString(), hashCode(), equals(), copy() 메소드들이 자동으로 만들어진다.   

```kotlin
class TicketNormal(val companyName : String, val name : String, var data : String, var seatNumber : Int)

fun main(){
    val ticketA = Ticket("koreanAir", "wandukong", "2020-11-07", 14)
    val ticketB = TicketNormal("koreanAir", "wandukong", "2020-11-07", 14)

    println(ticketA)
    println(ticketB)
}
```
<img src="https://user-images.githubusercontent.com/47289479/94176692-6ab4a680-fed3-11ea-9897-0d6b3442ef7b.JPG" width="1000" height="100"/>  
사진과 같이, 인스턴스에 대한 정보를 쉽게 알 수 있다.  

<hr />

### companion object

**companion object** 키워드를 선언하면 단순히 클래스 이름을 **식별자**로 사용할 수 있다.    
**정적 메소드**와 **정적 변수**를 선언하기 위해 사용한다.   

```kotlin
class Book private constructor(val id: Int, val name : String){  // 다른 곳에서는 생성하지 못하게끔 private 키워드를 사용한다.

    companion object BookFactory : IdProvider{ // interface implements
        override fun getId(): Int {
            return 444
        }

        val myBook = "new book"
        fun create() = Book(getId(), myBook)
    }
}
```
```kotlin
interface IdProvider{
    fun getId() : Int
}
```
```kotlin
fun main(){
    val book = Book.create()
    println("${book.id} ${book.name}")

    val bookId = Book.BookFactory.getId() // 정적 메서드
    println(bookId)  // 444
}
```
Book이라는 클래스명을 식별자로 사용하여, 정적 메서드를 호출한다.  

<hr />

### object class

**object**로 클래스를 정의하면, **Singleton 패턴**이 적용되어 객체가 한 번만 생성되도록 한다.  
즉, 생성자의 호출이 반복적으로 이뤄져도 실제로 생성되는 객체는 최초 생성된 객체를 반환 해주는 것이다.  
처음 compile될 때, 만들어지는 인스턴스는 딱 하나이다.
```kotlin
object CarFactory{
    val cars = mutableListOf<Car>()

    fun makeCar(power: Int) : Car{
        val car = Car(power)
        cars.add(car)
        return car
    }
}
```
```kotlin
data class  Car(val power : Int)
```
```kotlin
fun main(){
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(20)

    println(car)
    println(car2)
    print(CarFactory.cars.size.toString()) // 2
}
```