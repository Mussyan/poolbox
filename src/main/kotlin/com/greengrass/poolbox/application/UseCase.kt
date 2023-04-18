package com.greengrass.poolbox.application

interface UseCase<in Request, out Response> {
    val name: String
        get() {
            //  2번째 상위 "interface"가 "UseCaseBase"인 첫번째 상위 "interface"로 이름을 만든다
            val type = this.javaClass.interfaces.firstOrNull { first ->
                first.interfaces.any { second ->
                    second.simpleName.equals(UseCase::class.java.simpleName)
                }
            } ?: return ""

            return "([a-z])([A-Z]+)".toRegex().replace(type.simpleName, "$1_$2").uppercase()
        }

    /**
     * Use-case 실행
     * @param user - 사용자
     * @param request - 요청
     * @return - 응답
     */
    fun execute(user: User, request: Request): Response

    /**
     * Use-case 실행
     * @param user - 사용자
     * @param request - 요청
     * @return - 응답
     */
    operator fun invoke(user: User, request: Request): Response {
        return execute(user, request)
    }

    /**
     * Use-case 요청 없이 실행
     * @param user - 사용자
     * @return - 응답
     */
    operator fun invoke(user: User): Response {
        @Suppress("UNCHECKED_CAST")
        val request = EmptyRequest.instance as? Request ?: throw Exception()
        return invoke(user, request)
    }
}

