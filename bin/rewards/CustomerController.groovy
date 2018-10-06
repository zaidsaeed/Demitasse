package rewards

class CustomerController {
    static scaffold = Customer

    def lookup(){
        def customerInstance = Customer.findAllByFirstNameIlikeAndTotalPointsGreaterThanEquals("B%", 3)
//        def customerInstance = Customer.findAllByFirstNameAndTotalPoints("Bo", 3)
//        def customerInstance = Customer.findAllByTotalPointsBetween(2,4,[sort: "totalPoints", order: "desc"])
//        def customerInstance = Customer.findAllByLastNameILike("b%")
//        def customerInstance = Customer.findByPhone(params.id)
//        def customerInstance = Customer.findAllByPoints(5, [sort: "lastName"]);
//        def customerInstance = Customer.list(sort: "lastName", order: "desc", max: 5, offset: 0)
        [customerInstanceList:customerInstance]
    }

    def checkin(){}


    def index(){}
}
