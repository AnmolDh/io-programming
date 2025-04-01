package com.jsondata.cardata;

import org.json.JSONObject;

public class CarDataJSON {
    public static void main(String[] args) {
        Car car = new Car(1, "Toyota", "Blue");

        JSONObject obj = new JSONObject();
        obj.put("id", car.getId());
        obj.put("color", car.getColor());
        obj.put("model", car.getModel());

        System.out.println(obj.toString());
    }
}
