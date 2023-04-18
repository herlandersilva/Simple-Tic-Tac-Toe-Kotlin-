fun main() = mutableMapOf<String, Int>().run {
    while (true) {
        val sName = readLine()!!
        if (sName == "stop") break
        putIfAbsent(sName, readLine()!!.toInt())
    }
    print(this)
}