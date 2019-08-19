package com.sda.projects.gutenberg

import spock.lang.Specification
import spock.lang.Unroll
@Unroll
class GutenbergServiceTest extends Specification {

    //ConnectionService service=Mock()
   // GutenbergService gutenbergService=new GutenbergService(service)
    GutenbergService gutenbergService = []

    @Unroll
    def "countMarks #expectedResult #text"() {
        when:
        def result=gutenbergService.countMarks(text)
        then:
        result == expectedResult

        where:
              text ||expectedResult
                "" || 0
        "sto jeden"||9
    }
    @Unroll
    def "NumberOfSentences #expectedResult #text"() {
        when:
        def result=gutenbergService.numberOfSentences(text)
        then:
        result==expectedResult
        where:
        text          || expectedResult
        "Ala.Ma.Kota" ||3
        "Ala ma kota."||1
        "Ala ma kota" ||1
        "Ala.Ma!Kota?"||3
    }
    @Unroll
    def "NumberOfChars#text#expected"() {
        when:
        def result=gutenbergService.numberOfChars(text).entrySet().stream().findFirst().get().value
        then:
        result==expected
        where:
        text       ||  expected
        "aaa"      ||3
        " bbb234bb"||5
    }
    @Unroll
    def "TopWords#text#expected"() {
        when:
        def result=gutenbergService.topWords(text).entrySet().stream().findFirst().get().value
        then:
        result==expected
        where:
        text    ||    expected
        "banany, banany banany. banany! banany banany; banany? banany! banany:"||9
    }
    @Unroll
    def "CountWhiteSpaces #Text #expected"() {
        when:
        def result=gutenbergService.countWhiteSpaces(text)
        then:
        result==expected
        where:
        text           || expected
        "Ala ma kota"  ||2
        " Ala ma kota "||4
                     ""||0
         "            "||12
    }
    @Unroll
    def "CountNonAlfabetic #expected #text"() {
        when:
        def result=gutenbergService.countNonAlfabetic(text)
        then:
        result==expected
        where:
        text             ||     expected
        "Ala ma #%^ kota"||3
                       ""||0
                    "!@#"||3
    }
}
