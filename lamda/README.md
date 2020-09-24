# lamda

### 람다의 기본 정의

람다식은 우리가 마치 value처럼 다룰 수 있는 **익명함수**이다.  
즉, 변수 안에 함수를 넣을 수 있다.  
1) 메소드의 파라미터로 넘겨 줄 수가 있다.  
2) return 값으로 사용할 수 가 있다.  

> val 람다이름 : (argument type) -> (return type)= {argument -> code body}
> val 람다이름 = {arguments : arguement type  -> code body}  
항상 끝이 return 값이다.  

```kotlin
var square : (Int) -> Int = {number -> number*number}  // argument 들이 여러개일 수도 있으니, ()를 꼭 사용한다.
```
두 개가 동일하다.   
```kotlin
var square2  = {number : Int -> number*number}

```
```kotlin
var nameAge =  {name : String, age : Int ->
    "my name is ${name}, I'm ${age}"
}
```

<hr />

### 확장 함수

확장 함수를 사용하면 기존 객체에 사용자가 정의한 함수를 추가할 수 있다.
> val 변수이름 : 확장하려는 type.(argument type) : return type { value }  
> fun 확장하려는 type.(argument type) : return type { return value }  
```kotlin
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!" 
}
```
두개가 동일하다.   
```kotlin
fun String.pizzaIsGreat2() :String  {
    return this + "Pizza is the best!"
}
```
**this**는 확장함수를 **호출하는 객체**를 가리킨다.    

```kotlin
fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = {
        "I am ${this} and ${it} years old" 
    }
    return name.introduceMyself(age)
}
```
**it** 지시어는 argument가 한 개면, 대신 쓸 수 있다.(age를 뜻한다.)     

<hr />

### 람다의 return

```kotlin
val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "failure"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "error" 
    }
}
```
return 해야 하는 **expression**이기 때문에 **else**문이 있어야한다.  

<hr />

### 람다를 표현하는 방법

```kotlin
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean { // 람다를 argument로 받고, Boolean 값을 반환하는 함수
    return lamda(5.234)
}
```
```kotlin
val lanmda = {number : Double ->
	number == 4.234
}
println(invokeLamda(lanmda))  // false
```
```kotlin
println(invokeLamda({it > 3.2})) // true
invokeLamda { it > 3.2 }  
```
function의 parameter가 lamda식이면 이런식으로 ()생략이 가능하다.    
invokeLamda({it > 3.2})와 같다.   


```kotlin
button.setOnClickListener(object : View.OnClickListener{
	override fun onClick(v: View?) {
	}
})
```
**람다식을 이용하는 조건**   
**1)Kotlin interface가 아닌 Java interface이어야 한다.**  
**2)그 interface는 딱 하나의 메소드만 가져야 한다.**   
```kotlin
button.setOnClickListener({
})
```

