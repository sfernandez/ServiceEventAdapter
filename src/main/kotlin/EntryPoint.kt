import org.apache.camel.builder.RouteBuilder
import org.apache.camel.main.Main

class ServiceEventAdapterRouteBuilder : RouteBuilder() {
    override fun configure() {
        from("rabbitmq://localhost:5672/myServiceExchange?" +
                "username=user" +
                "&password=123" +
                "&queue=myService" +
                "&routingKey=service1" +
                ""
        ).to("http4:localhost/event/service")
    }

}

object EntryPoint {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val main = Main()
        main.addRouteBuilder(ServiceEventAdapterRouteBuilder())
        main.run(args)
    }

}