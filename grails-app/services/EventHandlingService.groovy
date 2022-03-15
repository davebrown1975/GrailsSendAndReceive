import grails.events.EventPublisher

class EventHandlingService implements EventPublisher {

    // replaces previous functionality provided by grails events plugin.
  def event(String topic, Object initialParameter) {
    log.debug("Publishing to topic $topic")

    println "before sAndR"
    Date now = new Date()
    Date timeoutIn = new Date(now.time + 3000)

    boolean done = false
    boolean messageSent = false
    while (!done && new Date().before(timeoutIn)) {
      if (!messageSent) {
        messageSent = true
        sendAndReceive(topic, initialParameter, {
          println "GOT SandR result - NEVER HITTING THIS POINT !?!"
          done = true
//                            return result
        })
      }
    }
    if (! done) println "FINSIHED BUT WITH TIMEOUT"
    println "ALL DONE"

  }
}



