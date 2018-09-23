package rewards

class Customer {
    String firstName
    String lastName
    Long phone
    String email
    Integer totalPoints
    static hasMany = [awards:Award, onlineOrders:OnlineOrder]

    static constraints = {
        phone nullable:true
        firstName nullable:true
        lastName nullable:true
        email nullable:true, email:true
        totalPoints nullable:true, max: 10
    }

}
