package fr.larrieu_lacoste.noe.ce_que_vous_voulez.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import fr.larrieu_lacoste.noe.ce_que_vous_voulez.R
import java.util.concurrent.Executors

class PicassoUtil {
    companion object {
        fun loadImg(imgUrl: String, placeholder: ImageView) {
            Picasso.get()
                .load(imgUrl)
                .error(R.drawable.placeholder)
                .into(placeholder, object : Callback {
                    override fun onSuccess() {}
                    override fun onError(e: Exception?) {
                        e?.printStackTrace()
                    }
                })
        }

        fun loadImg2(imgUrl: String, placeholder: ImageView) {
            // Declaring executor to parse the URL
            val executor = Executors.newSingleThreadExecutor()

            // Once the executor parses the URL
            // and receives the image, handler will load it
            // in the ImageView
            val handler = Handler(Looper.getMainLooper())

            // Initializing the image
            var image: Bitmap? = null

            // Only for Background process (can take time depending on the Internet speed)
            executor.execute {

                // Tries to get the image and post it in the ImageView
                // with the help of Handler
                try {
                    val img = java.net.URL(imgUrl).openStream()
                    image = BitmapFactory.decodeStream(img)

                    // Only for making changes in UI
                    handler.post {
                        placeholder.setImageBitmap(image)
                    }
                }

                // If the URL doesnot point to
                // image or any other kind of failure
                catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

    }
}