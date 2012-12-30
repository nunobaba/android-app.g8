package $package$

import com.github.jbrechtel.robospecs.RoboSpecs
import org.specs2.specification.Scope
import org.specs2.mock.Mockito


class MainActivitySpec extends RoboSpecs with Mockito {

  trait TestContext extends Scope {
    val activity = new MainActivity()
    activity.onCreate(null)
  }

  "onCreate" should {
    "inflate the layout" in new TestContext {
      activity must not beNull
    }
  }
}