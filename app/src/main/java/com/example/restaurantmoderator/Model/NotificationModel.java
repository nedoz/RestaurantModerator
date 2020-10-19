package com.example.restaurantmoderator.Model;

public class NotificationModel {

    private String notificationTitle;
    private String notificationDate;

    public NotificationModel(String notificationTitle, String notificationDate) {
        this.notificationTitle = notificationTitle;
        this.notificationDate = notificationDate;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }
}