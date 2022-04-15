//package com.madji.youtubetutorialapp;
//
//
//
//
//
//
//    public void doRequest(final ApiCallback callback) {
//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//
//        Call<ActivitiesResponse> call = apiService.getUserActivities(id);
//        call.enqueue(new Callback<ActivitiesResponse>() {
//            // If success
//            @Override
//            public void onResponse(Call<ActivitiesResponse>call, Response<ActivitiesResponse> response) {
//
//                list = response.body().getActivities();
//                callback.onSuccess(list); // pass the list
//            }
//            // If failed
//            @Override
//            public void onFailure(Call<ActivitiesResponse>call, Throwable t) {
//                // Log error here since request failed
//                Log.e(TAG, t.toString());
//            }
//        });
//    }
//
//    public void onResume(){
//        super.onResume();
//        doRequest(new ApiCallback(){
//            @Override
//            public void onSuccess(ArrayList<YOURTYPE> result){
//                //do stuff here with the list from the request
//            }
//        });
//    }
//
