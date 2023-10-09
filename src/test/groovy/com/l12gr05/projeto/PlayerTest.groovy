package com.l12gr05.projeto

import spock.lang.Specification

class PlayerTest extends Specification{
    def 'test score'(){
        given:
        def p = new Player('nome', '12');
        def s = p.getScore();
        when:
        p.setScore('13');
        then:
        p.getScore() == '13'
        s == '12'
    }
}
