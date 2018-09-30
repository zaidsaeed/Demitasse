package rewards

class WhiteboardController {
    def calculationsService = new CalculationsService()

    def variables(){
        def myTotal = 1
        render("Total: " + myTotal)
        myTotal = myTotal + 1
        render("New Total: " + myTotal)
        def firstName = "Mike"

        render("</br>Name: " + firstName)
        firstName = firstName + 1
        render("</br>New name: " + firstName)

        def today = new Date("2/1/2014")
        render("</br> Today is: " + today)
        today = today + 1
        render("</br> Today is: " + today)
    }

    def strings(){
        def first = "Mike"
        def second = " Kelly"
        def fullName = "Mike Kelly"
        def points = 4
        render "Hey there. Your name has ${fullName.length()} chars"
    }

    def conditions(){
        def firstName = "Mike"
        def totalPoints = 4
        def welcomeMessage = ""
        if(totalPoints >= 5){
            welcomeMessage = "Welcome back $firstName. This drink is on us."
        }else if(totalPoints == 4){
            welcomeMessage = "Welcome back $firstName. Your next drink is free."
        }else{
            welcomeMessage = "Welcome back $firstName. You have $totalPoints points."
        }
        render welcomeMessage
    }

    def switches(){
        def welcomeMessage = calculationsService.welcome(params)
        render welcomeMessage
    }



}
