# Basic


### function 

```kotlin
fun hello(){
    println("Hello World!")

}

fun add(a : Int, b : Int) : Int { // 변수이름을 먼저 쓴다.
    return a+b
}
```
Kotlin의 함수는 무조건 값을 반환한다.  
반환값이 명시되어 있지 않을때 **Unit**(null,void 와 비슷)이라는 값을 return 한다.       

<hr />


### val vs var

**val** : 값을 바꿀 수 없다.  
**var** : 값을 바꿀 수 있다.  

```kotlin
var a: Int = 10
var b = 9
```
변수 타입을 : 뒤에 써준다.   
자동 추론 가능해서 변수타입 안써도 된다.  


```kotlin
var c: Int 
```
하지만, 선언만 할때는 변수 타입을 명시해줘야 한다.  

```kotlin
var name = "seungwan"
println("my name is ${name}")
```
**${...}** 으로 String 안에서 변수를 사용할 수 있다.   
  
<hr />

### 조건문

#### if문
```kotlin
fun maxBy(a:Int, b: Int) : Int{
   if(a>b){
       return a
   }else{
       return b
   }
}
```
```kotlin
fun maxBy2(a:Int, b: Int) : Int = if(a>b) a else b
```
위 코드는 같다.   


#### when 문

```kotlin
fun checkNum(score : Int){
    when(score){
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
    }

    when(score){
        in 90..100 -> println("your are genius")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}
```

```kotlin
var b : Int = when(score){
	1->1
	2->2
	else -> 3
}
```
expression으로 사용시 **else**문이 꼭 있어야 한다.  

<hr />

### Expression vs Statement

**값을 만들면 표현식(Expression)**   
Kotlin의 모든 함수는 표현식이다.  
왜냐하면 반환값이 명시되어 있지 않을때 Unit(null,void 와 비슷)이라는 값을 return 하기 때문이다.   
**값을 만들지 않으면 선언문(Statement)**   

<hr />

### Array and List

#### Array
정해져 있는 사이즈가 있다. 사이즈를 바꾸지 못한다.   

```kotlin
val array = arrayOf(1,2,3)
val array2 = arrayOf(1,"d",3.4f)
array[0] = 3
```

#### List
**List** : 수정할 수 없는 List   
**MutableList** : 수정할 수 있는 List, 대표적으로 arrayList   
```kotlin
 fun array(){

     val list = listOf(1,2,3)
     val list2 = listOf(1,"d",3.4f)

     println(list[0]) 

     var arrayList = arrayListOf<Int>();
     arrayList.add(10)
     arrayList.add(20)
     arrayList[1] = 30
     for(i in 0..1){
         println(arrayList[i])
     }
 }
```
list안의 값에 접근 하려면 list[INDEX] 혹은 list.get(INDEX)로 접근이 가능하다.  

<hr />

### 반복문

#### for
```kotlin
val students = arrayListOf("Joyce","james","jenny","jenniper")

for( name in students){
	println(name)
}
for( (index, name) in students.withIndex()){
	println("${index+1}번째 학생 : ${name} ")
}
```
withIndex()를 사용하면 index와 같이 사용할 수 있다.  

```kotlin
var sum = 0
for( i in 1..10){
	sum += i
}
```
**in**: 1~10까지  

```kotlin
for( i in 1..10 step 2){ 
	print(i)
}
```
**step**: n칸씩   

```kotlin
for( i in 10 downTo 1){ 
	print(i)
}
```
**downTo** : n까지 내림차순  

```kotlin
for( i in 1 until 100){ 
	print(i)
}
```
**until**: 1~n-1까지      

<hr />

### Nullable / NonNull
Nullalbe 은 runtime 때 발견되는 NPE(Null Pointer Exception)을 방지하기 위해 고안

```kotlin
var name = "joyce"
var numllName : String? = null

var nameInUpperCase = name.toUpperCase()
var nullName = numllName?.toUpperCase(); // null이 아닐경우만 toUpperCase()
```

```kotlin
val lastName : String? = "Hong"
val fulName = name +" " + (lastName?: "No LastName")  // lastName이 null이면 해당 문자열 반환한다. 
println(fulName)
```
**`?:`** : 엘비스 연산자, 해당 값이 null일 수도 있다는 것을 가리킨다.   

```kotlin
var email : String ?
email = "asdasdad@masdasd.com"
email.let{
	println("my email : ${email}")
}
```
**let{}** : 해당 값이 null이 아니면 중괄호 안 코드 실행한다.    

```kotlin
fun getAge(age : Int?){
	var age2 : Int = age!!
}
```
**!!** : 널 값이 아닌 것을 보장한다.  

