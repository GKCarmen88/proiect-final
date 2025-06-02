package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class HomePageModel {


        private String arrivalQuantity;
        private int expectedSliderCount;
        private int expectedArrivalsCount;
        private String productURLFragment;
        private String messageText;



    public HomePageModel(String relativeJsonPath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this)
                    .readValue(new File(relativeJsonPath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erorre reading the JSON file : " + relativeJsonPath);
        }

    }

    public String getArrivalQuantity() {
        return arrivalQuantity;
    }

    public void setArrivalQuantity(String arrivalQuantity) {
        this.arrivalQuantity = arrivalQuantity;
    }



    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public int getExpectedSliderCount() {
        return expectedSliderCount;
    }

    public void setExpectedSliderCount(int expectedSliderCount) {
        this.expectedSliderCount = expectedSliderCount;
    }

    public int getExpectedArrivalsCount() {
        return expectedArrivalsCount;
    }

    public void setExpectedArrivalsCount(int expectedArrivalsCount) {
        this.expectedArrivalsCount = expectedArrivalsCount;
    }

    public String getProductURLFragment() {
        return productURLFragment;
    }

    public void setProductURLFragment(String productURLFragment) {
        this.productURLFragment = productURLFragment;
    }


}
