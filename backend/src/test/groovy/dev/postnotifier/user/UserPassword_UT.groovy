package dev.postnotifier.user

import dev.postnotifier.domain.user.UserPassword
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * UserPasswordの単体テスト
 */
@MicronautTest
class UserPassword_UT extends Specification {

    /**
     * 正常系
     */
    @Unroll
    void "Meets the rules for passwords"() {

        when:
        def result = new UserPassword(value).checkValue()

        then:
        result == expected

        where:
        value | expected
        "0000-Abc" | true
    }

    /**
     * 異常系: パスワード長が８文字未満
     */
    @Unroll
    void "If the password is less than 8 characters"() {
        when:
        def result = new UserPassword(value).checkValue()

        then:
        result == expected

        where:
        value | expected
        "0-1A" | false
        "1Z3456?" | false
    }
}
