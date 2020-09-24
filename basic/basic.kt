fun main(){
    hello()
    println(add(3,7))
    h1()
    checkNum(1)
    array()
    forAndWhile()
    nullCheck()
}

fun hello(){
    println("Hello World!")

}

fun add(a : Int, b : Int) : Int { // 변수이름을 먼저 쓴다.
    return a+b
}


//2. val vs var
// val : 값을 바꿀 수 없다.
// var : 값을 바꿀 수 있다.

fun h1() {
    val a: Int = 10 // 자동 추론 가능해서 변수타입 안써도 됨.
    var b: Int = 9

    var c: Int // 하지만 선언할때는 변수 타입을 명시해조야 한다.

    var name = "seungwan"

    println("my name is ${name}") // 중괄호로 변수를 사용한다.
}


//3. 조건식

fun maxBy(a:Int, b: Int) : Int{
   if(a>b){
       return a
   }else{
       return b
   }
}

fun maxBy2(a:Int, b: Int) : Int = if(a>b) a else b

fun checkNum(score : Int){
    when(score){
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
    }

    var b : Int = when(score){ // expression으로 사용시 else문이 꼭 있어야 한다.
        1->1
        2->2
        else -> 3
    }
    println("b:${b}")

    when(score){
        in 90..100 -> println("your are genius")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}


// 4. Expression vs Statement

// 값을 만들면 표현식(Expression)
// Kotlin의 모든 함수는 표현식이다. 왜냐하면 반환값이 명시되어 있지 않을때 Unit(null,void 와 비슷)이라는 값을 return 하기 때문이다.
// 값을 만들지 않으면



//5. Array and List

// Array
// 정해져 있는 사이즈가 있다.

//List
// 1. List : 수정할 수 없는 List
// 2. MutableList : 수정할 수 있는 List, arrayList

 fun array(){

     val array = arrayOf(1,2,3)
     val list = listOf(1,2,3)

     val araay = arrayOf(1,"d",3.4f)
     val list2 = listOf(1,"d",3.4f)

     array[0] = 3
     println(list[0]) // = list.get(0)

     var arrayList = arrayListOf<Int>();
     arrayList.add(10)
     arrayList.add(20)
     arrayList[1] = 30
     for(i in 0..1){
         println(arrayList[i])
     }
 }

// 반복문 for / while

fun forAndWhile(){

    val students = arrayListOf("Joyce","james","jenny","jenniper")

    for( name in students){
        println(name)
    }
    for( (index, name) in students.withIndex()){
        println("${index+1}번째 학생 : ${name} ")
    }


    var sum = 0
    for( i in 1..10){
        sum += i
    }
    println(sum)


    for( i in 1..10 step 2){ // n칸씩
        print(i)
    }
    println()

    for( i in 10 downTo 1){ // downTo : n까지 내림차순
        print(i)
    }
    println()

    for( i in 1 until 100){ // 1~99
        print(i)
    }
    println()

    var index = 0
    while(index < 10){
        println("current index : ${index++}")
    }
}

// 7. Nullable / NonNull
// Nullalbe : Runtime 때 발견되는 NPE : Null Pointer Exception을 방지하기 위해 고안

fun nullCheck(){
    var name = "joyce"


    var numllName : String? = null

    var nameInUpperCase = name.toUpperCase()

    var nullName = numllName?.toUpperCase();


    // ?: 엘비스 연산자

    val lastName : String? = "Hong"

    val fulName = name +" " + (lastName?: "No LastName") // lastName이 null 이면 해당 문자열 반환
    println(fulName)

    // let{} : 해당 값이 null이 아니면 중괄호 안 코드 실행.

    var email : String ?
    email = "asdasdad@masdasd.com"
    email.let{
        println("my email : ${email}")
    }

    // !! : 널 값이 아닌 것을 보장한다.
    fun getAge(age : Int?){
        var age2 : Int = age!!
    }




}