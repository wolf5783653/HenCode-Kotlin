package com.example.lesson

import android.util.Log
import com.example.lesson.entity.Lesson

data class Response constructor(var date: Int, var msg: String)

/**
 * 模拟请求
 * */
fun execute(): Response {
    val code = 200
    val msg = "Success"
    return Response(code, msg)
}
fun main(){
    val (code,msg)= execute()
    System.out.print("--->"+"${code}  ${msg}")
}




interface API{

}
// fun <T>creat(clazz: Class<T>):T{
//    return toCreat(clazz)
//}
// inline fun <reified T>creat():T{
//    return toCreat(T::class.java)
//}
//
//fun <T> toCreat(java: Class<T>): T {
//    return java
//}


