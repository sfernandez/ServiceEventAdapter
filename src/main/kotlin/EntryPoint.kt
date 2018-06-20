import org.apache.camel.builder.RouteBuilder
import org.apache.camel.main.Main

class ServiceEventAdapterRouteBuilder: RouteBuilder() {
    override fun configure() {
        from("rabbitmq://localhost:5672/testExchange?username=user&password=123").to("file:/tmp/test.txt")
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