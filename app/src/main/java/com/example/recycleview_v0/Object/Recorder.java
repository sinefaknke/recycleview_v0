package com.example.recycleview_v0.Object;
public class Recorder {
    private String Recorder_ID;
    private String Recorder_Name;

    public Recorder(String Recorder_ID, String Recorder_Name) {
        this.Recorder_ID = Recorder_ID;
        this.Recorder_Name = Recorder_Name;
    }

    public String getRecorder_ID() {
        return Recorder_ID;
    }

    public String getRecorder_Name() {
        return Recorder_Name;
    }

    public void setRecorder_ID(String Recorder_ID) {
        this.Recorder_ID = Recorder_ID;
    }

    public void setRecorder_Name(String Recorder_Name) {
        this.Recorder_Name = Recorder_Name;
    }
}
