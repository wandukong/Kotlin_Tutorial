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