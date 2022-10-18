package com.example.cvbuilder


data class CV(val home: Home,
              val about: About,
              val workExperience: ArrayList<WorkExperience>,
              val contact: ArrayList<Contact>)


data class Home(val image:Int,
                val banner:Int,
                val name:String,
                val role:String,
                var careerNote:String,
                val skills:HashMap<String,String>)

data class About(val intro:String,
                 val education:ArrayList<Education>,
                 val certification:ArrayList<Certification>)

data class Education(val image:Int,
                     val institue:String,
                     val degree:String)

data class Certification(val image:Int,
                         val name:String)

data class WorkExperience(val image:Int,
                          val position:String,
                          val name:String,
                          val start:String,
                          val end:String,
                          val location:String,
                          val responsibilty:String,
                          val url: String)

data class Contact(val image:Int,
                   val title:String,
                   val value:String,
                   val url:String)