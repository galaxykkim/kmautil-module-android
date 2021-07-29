package gkk.lib.kmautil

import android.content.Context
import android.util.Log
import com.opencsv.CSVReader
import java.io.BufferedReader
import java.io.InputStreamReader


class CSVManager(private val applicationContext: Context) {
    private val TAG = javaClass.simpleName

    /**
     * CSV 파일을 읽어서 List<Array<String>> 형태로 반환.
     */
    fun readFileFromAssets(fileName: String): List<Array<String>> {
        return try {
            val isr = InputStreamReader(applicationContext.resources.assets.open(fileName))
            val br = BufferedReader(isr)
            val reader = CSVReader(br)
            val resultList = mutableListOf<Array<String>>()
            reader.forEachIndexed { index, it ->
                resultList.add(it)
            }
            resultList

        } catch (error: Exception) {
            Log.e(TAG, "ERROR: $error")
            mutableListOf()
        }
    }
}