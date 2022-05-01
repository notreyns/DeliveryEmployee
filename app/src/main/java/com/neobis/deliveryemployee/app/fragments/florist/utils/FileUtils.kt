package com.neobis.deliveryemployee.app.fragments.florist.utils


import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import java.io.*
import java.util.*

object FileUtils {
    private const val EOF = -1
    private const val DEFAULT_BUFFER_SIZE = 1024 * 10

    @Throws(IOException::class)
    fun from(context: Context, uri: Uri): File {
        context.contentResolver.openInputStream(uri).use { inputStream ->
            val fileName = context.getFileName(uri = uri)
            val splitName = splitFileName(fileName)

            var tempFile = File.createTempFile(splitName[0], splitName[1])
            tempFile = rename(tempFile, fileName)
            tempFile.deleteOnExit()

            FileOutputStream(tempFile).use { outputSteam ->
                if (inputStream != null) {
                    copy(inputStream, outputSteam)
                    inputStream.close()
                }
            }

            return tempFile
        }
    }

    private fun splitFileName(fileName: String): Array<String> {
        var name = fileName
        var extension = ""

        val i = fileName.lastIndexOf(".")

        if (i != -1) {
            name = fileName.substring(0, i)
            extension = fileName.substring(i)
        }

        return arrayOf(name, extension)
    }

    private fun rename(file: File, newName: String): File {
        val newFile = File(file.parent, newName)
        if (newFile != file) {
            if (newFile.exists() && newFile.delete()) {
                Log.d("FileUtil", "Delete old $newName file")
            }
            if (file.renameTo(newFile)) {
                Log.d("FileUtil", "Rename file to $newName")
            }
        }
        return newFile
    }

    @Throws(IOException::class)
    private fun copy(input: InputStream, output: OutputStream): Long {
        var count: Long = 0
        var n: Int
        val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
        while (EOF != input.read(buffer).also { n = it }) {
            output.write(buffer, 0, n)
            count += n.toLong()
        }
        return count
    }
}

fun Context.getFileName(uri: Uri): String {
    var name: String? = when (uri.scheme?.lowercase(Locale.US)) {
        "content" -> contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
            } else {
                null
            }
        }
        else -> null
    }

    if (name.isNullOrEmpty()) {
        name = uri.path

        val cut = name?.lastIndexOf(File.separator) ?: -1

        if (cut != -1) {
            name = name?.substring(cut + 1)
        }
    }

    return requireNotNull(name)
}