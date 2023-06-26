package com.example.abha_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.abha_sample.databinding.ActivitySampleAbhaBinding
import org.json.JSONObject


class SampleAbhaActivity : AppCompatActivity() {

//     var SESSION_TOKEN : String = "abcd"

     lateinit var patient_json : JSONObject

    private lateinit var binding: ActivitySampleAbhaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleAbhaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.proceedButton.setOnClickListener {
            patient_json = JSONObject(binding.aadhaarEditText.text.toString())
        }
    }

    companion object {
        var SESSION_TOKEN: String = "abcd"
        var PATIENT_JSON : JSONObject = JSONObject("{\n" +
                "  \"Subject type\": \"Patient\",\n" +
                "  \"External ID\": null,\n" +
                "  \"Voided\": false,\n" +
                "  \"Registration date\": \"2023-06-22\",\n" +
                "  \"location\": {\n" +
                "    \"State\": \"Hosakote\",\n" +
                "    \"State External ID\": null\n" +
                "  },\n" +
                "  \"First name\": \"Priya\",\n" +
                "  \"Last name\": \"Rao\",\n" +
                "  \"Date of birth\": \"2013-03-22\",\n" +
                "  \"Gender\": \"Female\",\n" +
                "  \"observations\": {\n" +
                "  },\n" +
                "  \"Address\": \"Hosakote\"\n" +
                "}\n")
    }



}