import rewards.Award
import rewards.Customer

class CalculationsService{

    def welcome(Customer customer){
        def firstName = customer?.firstName
        def totalPoints = customer?.totalPoints.toInteger()
        def welcomeMessage = ""
        switch(totalPoints){
            case 5:
                welcomeMessage = "Welcome back $firstName. This drink is on us."
                break
            case 2..4:
                welcomeMessage = "Welcome back $firstName. You have $totalPoints points."
                break
            case 1:
                welcomeMessage = "Welcome back $firstName. You have $totalPoints point."
                break
            case 0:
                welcomeMessage = "Welcome back $firstName. You have $totalPoints points."
                break
        }
        welcomeMessage
    }

    def getTotalPoints(Customer customer){
        def totalAwards = 0
        customer?.awards.each{
            totalAwards = totalAwards + it.points
        }
        customer.totalPoints = totalAwards
        return customer
    }

    def processCheckin(Customer lookupInstance){
        def customerInstance = Customer.findByPhone(lookupInstance?.phone)
        if(!customerInstance){
            customerInstance = lookupInstance
            customerInstance.firstName = "Customer"
            customerInstance.totalPoints = 0
        }
        if(customerInstance.totalPoints < 5){
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
        }else{
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Reward", points: -5))
        }
        customerInstance = this.getTotalPoints(customerInstance)
        customerInstance.save(flush:true)
        def welcomeMessage = this.welcome(customerInstance)
        return [customerInstance, welcomeMessage]
    }
}