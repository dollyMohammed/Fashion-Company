package com.example.lastgradutionproject

 open class Event<out T>(private val content : T) {
     var hasBeenMandled =false
     private set


     fun getContentOrNull() : T? {
         return  if (hasBeenMandled){
             null
         }
         else{
             hasBeenMandled=true
             content
         }
     }

}