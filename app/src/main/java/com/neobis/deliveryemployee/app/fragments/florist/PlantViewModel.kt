package com.neobis.deliveryemployee.app.fragments.florist

import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.neobis.deliveryclient.app.model.toast.ToastDuration
import com.neobis.deliveryemployee.app.base.BaseViewModel
import com.neobis.deliveryemployee.domain.interactor.usecase.florist.CreatePlantUseCase
import com.neobis.deliveryemployee.domain.models.PlantItemModel
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream


class PlantViewModel(
    private val createPlantUseCase: CreatePlantUseCase,
) : BaseViewModel() {


    fun createPlant(
        bitmap: Bitmap,
        name: String,
        category: Int,
        quantity: Int,
        price: Int,
        description: String,
    ) {
       /* val f = File(mycontext.cacheDir, "testname");
        f.createNewFile();*/

        /*val fos = FileOutputStream(f);
        fos.write(bitmapdata);
        fos.flush()
        fos.close()*/

        val plant = PlantItemModel(bitmap, name, 1, quantity, price, description)
        createPlantUseCase.execute(viewModelScope, plant) { result ->
            result.perform(
                {
                    Log.d("plant", "успешно")

                    showToast("Растение успешно добавлено!", ToastDuration.SHORT)
                }, {
                    Log.d("plant", it.message.toString() + it.localizedMessage)
                    showToast("Ошибка, повторите попытку!", ToastDuration.SHORT)
                }
            )
        }
    }

    fun getPath(uri: Uri, context: Context): String? {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor: Cursor =
            context.getContentResolver().query(uri, projection, null, null, null) ?: return null
        val column_index: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val s: String = cursor.getString(column_index)
        cursor.close()
        return s
    }
}