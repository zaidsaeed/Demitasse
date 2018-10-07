import rewards.Customer

class CalculationsService{

    def welcome(params){
        def firstName = params.first
        def totalPoints = params.points.toInteger()
        def welcomeMessage = ""
        switch(totalPoints){
            case totalPoints >= 5:
                welcomeMessage = "Welcome back $firstName. This drink is on us."
            case 1..4:
                welcomeMessage = "Welcome back $firstName. You have $totalPoints points."
            default:
                welcomeMessage = "Welcome back $firstName. You have $totalPoints points."
        }
    }

    def getTotalPoints(Customer customer){
        def totalAwards = 0
        customer.awards.each{
            totalAwards = totalAwards + it.points
        }
        customer.totalPoints = totalAwards
        return customer
    }
}