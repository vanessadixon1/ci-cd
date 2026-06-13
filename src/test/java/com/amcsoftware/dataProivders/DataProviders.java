package com.amcsoftware.dataProivders;

import com.amcsoftware.models.UsersItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "users")
    public Object[][] userData() {

        try {
            Type type = new TypeToken<List<UsersItem>>() {}.getType();

            List<UsersItem> users = new Gson().fromJson(
                    new FileReader("src/test/resources/testdata/users.json"),
                    type
            );

            Object[][] data = new Object[users.size()][1];

            for (int i = 0; i < users.size(); i++) {
                data[i][0] = users.get(i);
            }

            return data;

        } catch (Exception e) {
            throw new RuntimeException("Failed to load users test data", e);
        }
    }
}