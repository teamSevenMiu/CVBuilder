package com.example.cvbuilder


object DataService{

    val default = jhonDoeCV()


    private fun jhonDoeCV():CV{

        var skills = arrayListOf<Skills>()
        skills.add(Skills("Programming Language","Java,C++,Swift,Kotlin"))
        skills.add(Skills("Tools","Eclipse, Android Studio, XCode, IntelIJ"))
        skills.add(Skills("Database","Oracle, MySQL, SQLite, CoreData, RoomDB"))


        val home = Home(R.drawable.profile_icon,R.drawable.apple_icon,"Jhon Doe","Software Architect","Passionate software geek",skills)

        val educations = arrayListOf<Education>()
        educations.add(Education(R.drawable.education_icon,"Maharishi International University","MSC in Computer Science"))
        educations.add(Education(R.drawable.education_icon,"Massachusetts Institute of Technology","BSC in Computer Science"))
        educations.add(Education(R.drawable.education_icon,"West Senior High School ","Higher Secondary School Certificate"))
        educations.add(Education(R.drawable.education_icon,"West Junior High School ","Secondary School Certificate"))

        val certificates = arrayListOf<Certification>()
        certificates.add(Certification(R.drawable.certificate_icon,"Certified JAVA Developer"))
        certificates.add(Certification(R.drawable.certificate_icon,"Certified C++ Developer"))
        certificates.add(Certification(R.drawable.certificate_icon,"Certified Scrum Master"))

        val about = About("“I've worked in software engineering for my entire 15-year career, and my commitment to critical thinking and attention to detail have gotten me to where I am today: a senior software engineer for First Technology. I have a passion for processes, and I'm an experienced team leader who typically manages 10 developers at any given time.\n\n\n“Prior to my senior role, I worked as a software engineer for First Technology and a programmer for Mobile First. Because I've already held all the other positions in this field, I have keen insight into what it takes to run a successful project. My career goal is to move into management as a CTO, and I know this role would help me hone my leadership skills.”",educations,certificates)

        val works = arrayListOf<WorkExperience>()
        works.add(WorkExperience(R.drawable.google_icon,"Software Architect","Google","August 2022","Present","CA, USA","Working on different projects","https://www.google.com"))
        works.add(WorkExperience(R.drawable.apple_icon,"Principle Engineer","Apple","January 2022","August 2022","NY, USA","Working on different projects","https://www.apple.com"))
        works.add(WorkExperience(R.drawable.amazon_icon,"Lead Engineer","Amazon","January 2021","December 2021","TX, USA","Working on different projects","https://www.amazon.com"))
        works.add(WorkExperience(R.drawable.microsoft_icon,"Sr. Software Engineer","Microsoft","January 2019","December 2020","IL, USA","Working on different projects","https://www.microsoft.com"))
        works.add(WorkExperience(R.drawable.netflix_icon,"Software Engineer","Netflix","January 2015","December 2018","IA, USA","Working on different projects","https://www.netflix.com"))

        val contacts = arrayListOf<Contact>()
        contacts.add(Contact(R.drawable.phone_icon,"Phone Number","+16412330000","tel:16412330000"))
        contacts.add(Contact(R.drawable.email_icon,"Email","jhondoe@gmail.com","mailto:jhondoe@gmail.com"))
        contacts.add(Contact(R.drawable.linkedin_icon,"LinkedIn","linkedin.com/jhondoe","https://linkedin.com"))
        contacts.add(Contact(R.drawable.github_icon,"GITHUB","github.com/jhondoe","https://github.com/"))
        contacts.add(Contact(R.drawable.facebook_icon,"Facebook","facebook.com/jhondoe","https://facebook.com"))

        return CV(home,about,works,contacts)

    }

}