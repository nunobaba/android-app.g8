package $package$

import android.app.Activity
import android.os.Bundle

class $main_activity$ extends Activity with TypedActivity {
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)

    findView(TR.textview).setText("hello, world!")
  }
}
