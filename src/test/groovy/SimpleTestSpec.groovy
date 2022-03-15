import grails.testing.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
class SimpleTestSpec extends Specification {

  @Autowired
  EventHandlingService service

  void "fire the events"() {
    given:
      Article article = new Article()
      article.name = "NOTDONE"
    when:
      println "sending event"
      service.event("article_published", article)
      println "after sending event"
    then:
      article.name == "DONE"
  }
}
