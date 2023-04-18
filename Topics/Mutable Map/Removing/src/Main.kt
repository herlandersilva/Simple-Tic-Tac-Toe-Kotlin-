fun removing(currentMap: MutableMap<Int, String>, value: String): MutableMap<Int, String> {
    // Write your code here. Do not print the result of the function!
    val newMap = mutableMapOf<Int, String>()
    newMap.putAll(currentMap)
    for (map in newMap.toMap()) {
        if (map.value == value) {
            newMap.remove(map.key)
        }
    }

    return newMap
}