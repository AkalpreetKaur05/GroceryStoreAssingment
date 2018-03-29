package ServicesTest

import java.util.{Calendar, Timer}

import com.hashmap.Services.Scheduler
import org.scalatest.FunSuite

class SchedulerServiceTest extends FunSuite
{
  test("calling Scheduler")
  {
    val now = Calendar.getInstance()
    val hour = now.get(Calendar.HOUR_OF_DAY)
    println("hour of day is " + hour)
    if (hour == 12) {
    val timer = new Timer()
    val obj = new Scheduler("src/main/scala/com/hashmap/resources/storenew.xml", "src/main/scala/com/hashmap/resources/store.xml")
    timer.schedule(obj, 1000)
    }
  }
}
