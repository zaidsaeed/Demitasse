package rewards

class CustomerController {
    static scaffold = Customer

    def calculationsService = new CalculationsService()

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


    def index(){
        [customerList: Customer.list(), customerCount: Customer.count()]
    }

    def create(){
        [customer: new Customer()]
    }

    def save(Customer customer){
        customer.save(flush: true)
        redirect(action: "show", id: customer.id)
    }

    def show(Long id){
        def customer = Customer.get(id)
        customer = calculationsService.getTotalPoints(customer)
        [customer: customer]
    }

    def edit(Long id){
        def customer = Customer.get(id)
        [customer: customer]
    }

    def update(Long id){
        def customer = Customer.get(id)
        customer.properties = params
        this.save(customer)
    }

    def delete(Long id){
        def customer = Customer.get(id)
        customer.delete(flush: true)
        redirect(action: "index")
    }

    def customerLookup(Customer lookupInstance){
        def (customerInstance, welcomeMessage)= calculationsService.processCheckin(lookupInstance)
        render(view: "checkin", model:[customerInstance: customerInstance, welcomeMessage: welcomeMessage])
        //Query customer by phone number
        //If no result
        //Create a new customer
        //Create a welcome message
        //add award record
        //save customer
        //send welcome to kiosk

        //If customer is found
        //Calculate the total points of the customer
        //Create a welcome message
        //add award record
        //save customer
        //send welcome to kiosk
    }

    def profile(){
        def customerInstance = Customer.findByPhone(params.id)
        [customerInstance: customerInstance]
    }

    def updateProfile(Customer customerInstance){
        customerInstance.save(flush:true)
        render (view: "profile", model:[customerInstance: customerInstance])
    }
}
