package com.example.abha_create_verify_android.data.api

import com.example.abha_create_verify_android.data.model.CreateABHAResp
import com.example.abha_create_verify_android.data.model.GenerateAadhaarOTPReq
import com.example.abha_create_verify_android.data.model.GenerateAadhaarOTPResp
import com.example.abha_create_verify_android.data.model.GenerateMobileOTPReq
import com.example.abha_create_verify_android.data.model.GenerateMobileOTPResp
import com.example.abha_create_verify_android.data.model.VerifyAadhaarOTPResp
import com.example.abha_create_verify_android.data.model.VerifyOTPReq
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("hiprovider/v2/registration/aadhaar/generateOtp")
    suspend fun generateAadhaarOtp(@Body requestBody: GenerateAadhaarOTPReq): Response<GenerateAadhaarOTPResp>

    @POST("hiprovider/v2/registration/aadhaar/verifyOTP")
    suspend fun verifyAadhaarOtp(@Body requestBody: VerifyOTPReq): Response<VerifyAadhaarOTPResp>

    @POST("hiprovider/v2/registration/aadhaar/checkAndGenerateMobileOTP")
    suspend fun checkAndGenerateMobileOtp(@Body requestBody: GenerateMobileOTPReq): Response<GenerateMobileOTPResp>

    @POST("hiprovider/v2/registration/aadhaar/verifyMobileOTP")
    suspend fun verifyMobileOtp(@Body requestBody: VerifyOTPReq) : Response<Unit>

    @POST("hiprovider/v2/registration/aadhaar/createHealthIdByAdhaar")
    suspend fun createHealthIdByAdhaarOtp(): Response<CreateABHAResp>
}