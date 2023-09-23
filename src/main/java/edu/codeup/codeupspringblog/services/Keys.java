package edu.codeup.codeupspringblog.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Keys {

    @Value("${api.key.one}")
    private String API_KEY_ONE;
    @Value("${api.key.two}")
    private String API_KEY_TWO;

    public String getAPI_KEY_ONE() {
        return API_KEY_ONE;
    }

    public void setAPI_KEY_ONE(String API_KEY_ONE) {
        this.API_KEY_ONE = API_KEY_ONE;
    }

    public String getAPI_KEY_TWO() {
        return API_KEY_TWO;
    }

    public void setAPI_KEY_TWO(String API_KEY_TWO) {
        this.API_KEY_TWO = API_KEY_TWO;
    }
}
