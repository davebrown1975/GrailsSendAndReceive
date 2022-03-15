import grails.events.annotation.Subscriber
import org.springframework.context.event.EventListener
import reactor.spring.context.annotation.Consumer
import reactor.spring.context.annotation.Selector

class EventSubscribersService {

  @Subscriber("article_published")
  def handleEvent(Article article) {
    println "Event detected for: " + article.name
    article.name = "DONE"
    return article
  }

}