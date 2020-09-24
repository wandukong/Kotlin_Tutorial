open class Human (var name : String = "Anonymous"){

    var age = -1;
    constructor(name : String,  age : Int) : this(name){
        this.age = age;
    }

    init {
        println("new human has been born!!")
    }

    fun eatingCake(){
        println("this is yummy~")
    }

    open fun singASong(){
        println("lalala")
    }
}

class Korean : Human(){ // 상속을 하려는 부모 클래스에 open 키워드를 명시해야 한다.

    override fun singASong(){ // override 키워드를 사용하여 오버라이딩을 한다. 또한, 오버라이딩 하려는 메소드에 open 키워드를 명시해야 한다.
        super.singASong()
        println("라라라")
        println("my name is ${super.name}")
    }

}


fun main(){
    val human = Human("seungwan")
    human.eatingCake()
    println("my name is ${human.name}")

    val stranger = Human()
    println("my name is ${stranger.name}")

    val human2 = Human("yang", 21)

    println("name : ${human2.name} age : ${human2.age}")

    val korean = Korean()

    korean.singASong()
}
