package rewards

class MasksTagLib {
    static defaultEncodeAs = 'html'

    def phone334 = { attrs ->
        String phone = attrs.phone
        def formatted = "(" + phone.substring(0,3) + ") " + phone.substring(3,6) + "-" + phone.substring(6)
        out << formatted
    }
}
