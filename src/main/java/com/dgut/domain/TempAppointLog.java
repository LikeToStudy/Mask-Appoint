package com.dgut.domain;

public class TempAppointLog {
    private String appointmentTime;
    private String appointmentSpeed;

    public TempAppointLog(String appointTime, String appointSpeed) {
        this.appointmentTime = appointTime;
        this.appointmentSpeed = appointSpeed;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentSpeed() {
        return appointmentSpeed;
    }

    public void setAppointmentSpeed(String appointmentSpeed) {
        this.appointmentSpeed = appointmentSpeed;
    }
}
