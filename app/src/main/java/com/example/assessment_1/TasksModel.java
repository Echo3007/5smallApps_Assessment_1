/*Student Name: Angela Pellillo
 * Student ID: 21499500
 * Module: Mobile Web Application Development
 * Module ID: CP5CS93E*/


package com.example.assessment_1;
//Class for the items that will be contained in the RecyclerView
public class TasksModel {
    String taskDescr;
    int taskImage;

    public TasksModel(String taskDescr, int taskImage) {
        this.taskDescr = taskDescr;
        this.taskImage = taskImage;
    }

    public String getTaskDescr() {
        return taskDescr;
    }

    public int getTaskImage() {
        return taskImage;
    }
}
