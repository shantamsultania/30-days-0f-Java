package Api;

import Data.DataModel;
import android.content.Context;
import android.util.Log;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RestApi {

    private final List<DataModel> dataModelList = new ArrayList<>();
    private final String TAG = "APItry";
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public RestController connect() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://d2acedda7227.ngrok.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        try {
            RestController restController = retrofit.create(RestController.class);
            return restController;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getDataModelList:", e);
        }
        return null;
    }


    public void addDataModel() {
        if (connect() == null) {
            Log.d(TAG, "getAllDataModelList: " + "error connection not formed");
        }


        DataModel dataModel = new DataModel();
        dataModel.setDepartment("cse2");
        dataModel.setId("012");
        dataModel.setName("new name3");
        dataModel.setSalary("1002");
        Call<ResponseBody> dataReceived = connect().addData(dataModel);
        dataReceived.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    ResponseBody d = response.body();
                    Log.d(TAG, "onResponse: " + response.code());
                    try {
                        Log.d(TAG, "onResponse: 1 " + d.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "onResponse: " + Objects.requireNonNull(response.body()).toString());
                    Log.d(TAG, "onResponse: " + response.message());
                    Log.d(TAG, "onResponse: " + response.raw());
                    Log.d(TAG, "onResponse: " + response.headers());
                } else {
                    Log.d(TAG, "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    public void getAllDataModelList() {
        if (connect() == null) {
            Log.d(TAG, "getAllDataModelList: " + "error connection not formed");
        }

        Call<ResponseBody> dataReceived = connect().getData();
        dataReceived.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody dataList = response.body();
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response);
                    Log.d(TAG, "onResponse: " + response.code());
                    try {
                        Log.d(TAG, "onResponse: 1 " + dataList.string());
                        JsonObject jsonArray = new JsonParser().parse(dataList.string()).getAsJsonObject();
                        Log.d(TAG, "onResponse: 5" + jsonArray);
//                        Log.d(TAG, "onResponse: 4"+jsonArray.get(0).toString());
                        Log.d(TAG, "onResponse: 4" + jsonArray.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Log.d(TAG, "onResponse: 2" + dataList.contentType());
//                    Log.d(TAG, "onResponse: 3" + response.headers());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }


}
