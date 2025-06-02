package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class HomePageModel {

        private String arrivalProductName;
        private String arrivalQuantity;
        private String expectedReviewMessage;
        private int expectedSliderCount;
        private int expectedArrivalsCount;
        private String productURLFragment;
        private String productToSearch;
        private String expectedProductTitle;
        private String priceFilterMin;
        private String priceFilterMax;
        private String sortOption;
        private String messageText;




    public String getArrivalProductName() {
        return arrivalProductName;
    }

    public void setArrivalProductName(String arrivalProductName) {
        this.arrivalProductName = arrivalProductName;
    }

    public String getArrivalQuantity() {
        return arrivalQuantity;
    }

    public void setArrivalQuantity(String arrivalQuantity) {
        this.arrivalQuantity = arrivalQuantity;
    }

    public String getExpectedReviewMessage() {
        return expectedReviewMessage;
    }

    public void setExpectedReviewMessage(String expectedReviewMessage) {
        this.expectedReviewMessage = expectedReviewMessage;
    }

    public String getProductToSearch() {
        return productToSearch;
    }

    public void setProductToSearch(String productToSearch) {
        this.productToSearch = productToSearch;
    }

    public String getExpectedProductTitle() {
        return expectedProductTitle;
    }

    public void setExpectedProductTitle(String expectedProductTitle) {
        this.expectedProductTitle = expectedProductTitle;
    }

    public String getPriceFilterMin() {
        return priceFilterMin;
    }

    public void setPriceFilterMin(String priceFilterMin) {
        this.priceFilterMin = priceFilterMin;
    }

    public String getPriceFilterMax() {
        return priceFilterMax;
    }

    public void setPriceFilterMax(String priceFilterMax) {
        this.priceFilterMax = priceFilterMax;
    }

    public String getSortOption() {
        return sortOption;
    }

    public void setSortOption(String sortOption) {
        this.sortOption = sortOption;
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

}
