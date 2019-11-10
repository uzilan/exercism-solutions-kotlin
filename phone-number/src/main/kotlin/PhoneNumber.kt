class PhoneNumber(private val input: String) {

    companion object {
        private const val countryCode = """\+?(1[ \-]?)?"""
        private const val areaCodeWithoutParentheses = """[2-9]\d\d"""
        private const val areaCodeWithParentheses = """\($areaCodeWithoutParentheses\)"""
        private const val areaCode = """($areaCodeWithParentheses|$areaCodeWithoutParentheses)"""
        private const val localNumber = """[ \-\.0-9]*"""
        private const val ok = "$countryCode$areaCode$localNumber"
        private const val replace = """[\+\(\) \-\.]"""
    }

    val number: String?
        get() {
            val replaced = input.replace(replace.toRegex(), "")
            val length10 = replaced.length == 10
            val length11StartingWith1 = replaced.length == 11 && replaced.first() == '1'

            return when {
                !input.matches(ok.toRegex()) -> null
                !length10 && !length11StartingWith1 -> null
                replaced[3] !in ('2'..'9') -> null
                length11StartingWith1 -> replaced.takeLast(10)
                else -> return replaced
            }
        }
}