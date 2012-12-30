package $package$

import _root_.android.app.Activity
import _root_.android.os.Bundle

class $main_activity$ extends Activity with TypedActivity {
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)

    findView(TR.textview).setText("hello, world!")
  }
}
