package rewards

class WhiteboardController {

    def index(){}

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
        def points = 4
        render "Hey there $first. You already have $points points."
    }



}
