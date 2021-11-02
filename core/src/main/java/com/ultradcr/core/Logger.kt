package com.ultradcr.core

class Logger(
    private val tag:String,
    private val isDebug: Boolean = true,
) {

    fun  log(msg: String){
        if(!isDebug){
            //production logging
        }else{
            printLogD(tag , msg)
        }
    }

  companion object Factory{
      fun buildDebug(tag: String): Logger {
          return Logger(
              tag = tag,
              isDebug = true
          )
      }
      fun buildRelease(tag: String): Logger {
          return Logger(
              tag = tag,
              isDebug = false
          )
      }
  }

}
private fun printLogD(tag: String, msg: String) {
    print("$tag: message")
}